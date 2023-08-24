#!python3

import os
import re
import subprocess

test_cases_dir = "./tutorial/Compiler-Design-Implementation/testcases/codegen/"
compile_command = "make"
execute_command = "./bin/mxc"
ravel_command = "./bin/ravel"
test_dir = "./src/test/mx/"
builtin_s = "./src/test/mx/builtin.s"
start_testcase = ""

def collect_test_cases():
  test_cases = []
  for dir in os.listdir(test_cases_dir):
    if os.path.isfile(test_cases_dir + dir):
      if os.path.splitext(dir)[1] == '.mx':
        test_cases.append(dir)
    elif os.path.isdir(test_cases_dir + dir):
      for f in os.listdir(test_cases_dir + dir):
        if os.path.splitext(f)[1] == '.mx':
          test_cases.append(dir + '/' + f)
  test_cases.sort()
  for i in range(len(test_cases)):
    if str(test_cases[i]).startswith(start_testcase):
      test_cases = test_cases[i:]
      break
  return test_cases

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
  mx2exe = execute_command + " <" + (test_dir + "input.mx") + " >" + (test_dir + "output.s")
  print("Compiling to executable: " + mx2exe)
  compile_status, compile_output = subprocess.getstatusoutput(mx2exe)
  if (compile_status != 0):
    print("Compile Error when generating exe: " + compile_output)
    return False
  return True

def execute(file_io = False, expected_result = 0):
  # example: ./bin/ravel test/output.s test/builtin.s
  execute = ravel_command  + " " + test_dir + "output.s" + " " + builtin_s
  if file_io:
    execute += " --input-file=" + test_dir + "test.in" + " --output-file=" + test_dir + "test.out"
  print("Executing: " + execute)
  execute_output = subprocess.getoutput(execute)
  execute_status = int((re.findall(r'exit code: (\d+)', execute_output))[0])
  if (execute_status != expected_result):
    print("Runtime Error: expected " + str(expected_result) + ", got " + str(execute_status));
    print(execute_output)
    return False
  if file_io == False:
    print("Output:")
    print(execute_output)
  return True

def test(test_name):
  input = test_cases_dir + test_name
  print("Running testcase " + test_name)
  subprocess.call("cp " + input + " " + test_dir + "input.mx", shell=True)
  if compile2exe() == False:
    return False
  result = process_io(input)
  if execute(file_io=True, expected_result=result) == False:
    return False
  diff = "diff -bB " + test_dir + "test.out " + test_dir + "test.ans"
  compare_status_1, compare_output = subprocess.getstatusoutput(diff)
  diff = "diff -w " + test_dir + "test.out " + test_dir + "test.ans"
  compare_status_2, compare_output = subprocess.getstatusoutput(diff)
  if (compare_status_1 != 0) & (compare_status_2 != 0) :
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
      compile2exe()
      execute(file_io=False)
      exit(0)
    if arg.startswith("--exec-only"):
      execute(file_io=False)
      exit(0)
  main()
