#!python3

import os
import re
import subprocess

test_cases_dir = "./testcases/codegen/"
compile_command = "make"
execute_command = "./bin/mxc"
test_dir = "./src/test/mx/"
builtIn_c = "./src/main/c/builtIn.c"
start_testcase = ""

def collect_test_cases():
  test_cases = []
  for dir in os.listdir(test_cases_dir):
    if os.path.isfile(test_cases_dir + dir):
      if os.path.splitext(dir)[1] == '.mx':
        test_cases.append(dir)
    elif os.path.isdir(test_cases_dir + dir):
      for f in os.listdir(test_cases_dir + dir):
        if f.split('.')[0] == start_testcase:
          test_cases = []
        if os.path.splitext(f)[1] == '.mx':
          test_cases.append(dir + '/' + f)
  test_cases.sort()
  return test_cases

def compile2ll():
  mx2llvm = execute_command + " <" + (test_dir + "input.mx") + " >" + (test_dir + "output.ll")
  print("Compiling to LLVM IR: " + mx2llvm)
  compile_status, compile_output = subprocess.getstatusoutput(mx2llvm)
  if (compile_status != 0):
    print("Compile Error in input.mx: " + compile_output)
    return False
  builtIn2llvm = "clang-16 -S -c -emit-llvm -O0 " + builtIn_c + " -o " + test_dir + "builtIn.ll"
  print("Compiling builtIn.c to LLVM IR: " + builtIn2llvm)
  compile_status, compile_output = subprocess.getstatusoutput(builtIn2llvm)
  if (compile_status != 0):
    print("Compile Error in builtIn.c: " + compile_output)
    return False
  return True

def process_io(origin_input):
  input_file = open(origin_input, 'r')
  input_text = re.findall(r'=== input ===\n([\s\S]*?)\n=== end ===', input_file.read())
  input_file_o = open(test_dir + "test.in", 'w')
  input_file_o.writelines(input_text)
  output_file = open(origin_input, 'r')
  output_text = re.findall(r'=== output ===\n([\s\S]*?)\n=== end ===', output_file.read())
  output_file_o = open(test_dir + "test.ans", 'w')
  output_file_o.writelines(output_text)
  result_file = open(origin_input, 'r')
  result_text = re.findall(r'ExitCode: (\d+)', result_file.read())
  return int(result_text[0])

def compile2exe():
  llvm2exe = "clang-16 " + test_dir + "output.ll " + test_dir + "builtIn.ll -o " + test_dir + "output"
  print("Compiling to executable: " + llvm2exe)
  compile_status, compile_output = subprocess.getstatusoutput(llvm2exe)
  if (compile_status != 0):
    print("Compile Error when generating exe: " + compile_output)
    return False
  return True

def execute(file_io = False, expected_result = 0):
  execute = test_dir + "output"
  if file_io:
    execute += " <" + (test_dir + "test.in") + " >" + (test_dir + "test.out")
  print("Executing: " + execute)
  execute_status, execute_output = subprocess.getstatusoutput(execute)
  if (execute_status != expected_result):
    print("Runtime Error: " + execute_output)
    return False
  if file_io == False:
    print("Output:")
    print(execute_output)
  return True

def test(test_name):
  input = test_cases_dir + test_name
  print("Running testcase " + test_name)
  subprocess.call("cp " + input + " " + test_dir + "input.mx", shell=True)
  if compile2ll() == False:
    return False
  result = process_io(input)
  if compile2exe() == False:
    return False
  if execute(file_io=True, expected_result=result) == False:
    return False
  diff = "diff -ZB " + test_dir + "test.out " + test_dir + "test.ans"
  compare_status, compare_output = subprocess.getstatusoutput(diff)
  if (compare_status != 0):
    print("Wrong Answer: " + compare_output)
    return False
  return True

def main():
  subprocess.call("mkdir -p " + test_dir, shell=True)
  collect_test_cases()
  for test_name in collect_test_cases():
    if test(test_name) == False:
      break

if __name__ == "__main__":
  for arg in os.sys.argv:
    if arg.startswith("--start="):
      start_testcase = arg.split("=")[1]
    if arg.startswith("--compile-exec"):
      compile2ll()
      compile2exe()
      execute(file_io=False)
      exit(0)
    if arg.startswith("--exec-only"):
      compile2exe()
      execute(file_io=False)
      exit(0)
  main()
