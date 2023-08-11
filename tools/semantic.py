#!python3

import os
import subprocess
import threading
import atomic

test_cases_dir = "./tutorial/Compiler-Design-Implementation/testcases/sema/"
execute_command = "java -Xbootclasspath/a:/Library/Java/JavaVirtualMachines/openjdk-17.jdk/Contents/Home/lib/antlr-4.13.0-complete.jar -jar ./target/comet-0.1.0-alpha.jar"

pool = threading.BoundedSemaphore(1)
start_testcase = ""
remain_count = atomic.AtomicLong(0)
failed_tag = atomic.AtomicLong(False)
fail_only_tag = False
output_dir = ""

def collect_test_cases():
  test_cases = []
  for dir in os.listdir(test_cases_dir):
    if os.path.isdir(test_cases_dir + dir):
      for f in os.listdir(test_cases_dir + dir):
        if f.split('.')[0] == start_testcase:
          test_cases = []
        if os.path.splitext(f)[1] == '.mx':
          test_cases.append(dir + '/' + f)
  test_cases.sort()
  remain_count.get_and_set(len(test_cases))
  return test_cases

def test(test_name):
  pool.acquire()
  input = open(test_cases_dir + test_name, 'r')
  expected = ""
  comment = ""
  try:
    line_count = 0
    while line_count < 10:
      line_count += 1
      line = input.readline()
      pos = line.find("Verdict:")
      if pos != -1:
        expected = line[pos + 8:].strip()
        if (expected == "Success"):
          break
      pos = line.find("Comment:")
      if pos != -1:
        comment = line[pos + 8:].strip()
        break
  finally:
    input.close()
    
  str = execute_command + " < " + test_cases_dir + test_name
  status, result = subprocess.getstatusoutput(str)
  if fail_only_tag == False & status == expected_status:
    print("Running test " + test_name + ":")
    print("  " + "Expected: " + expected + " " + comment)
    print("  " + "Result: " + result)
  expected_status = 0 if expected == "Success" else 1
  if status != expected_status:
    print("Test fail at " + test_name + ".")
    if output_dir != "":
      print("Failed source code has been copied to " + output_dir + " for debugging.")
      subprocess.call("cp " + test_cases_dir + test_name + " " + output_dir, shell=True)
    failed_tag.get_and_set(True)
  else:
    remain_count.get_and_set(remain_count.value - 1)
  pool.release()

def main():
  test_cases = collect_test_cases()
  threads = [threading.Thread(target=test, args=(test_name,)) for test_name in test_cases]
  [thread.start() for thread in threads]
  [thread.join() for thread in threads]
  print("All test cases passed!")

if __name__ == "__main__":
  for arg in os.sys.argv:
    if arg.startswith("--start="):
      start_testcase = arg[8:]
    if arg.startswith("--thread="):
      pool = threading.BoundedSemaphore(int(arg[9:]))
    if arg.startswith("--fail-only"):
      fail_only_tag = True
    if arg.startswith("--output="):
      output_dir = arg[9:]
    if arg.startswith("--help"):
      print("Usage: python3 tools/semantic.py [--start=<testcase>] [--fail-only] [--thread=<thread_count>]")
      exit()
  main()