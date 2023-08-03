#!python3

import os
import subprocess

test_cases_dir = "./testcases/sema/"
compile_command = "mvn compile"
execute_command = "java -Xbootclasspath/a:/Library/Java/JavaVirtualMachines/openjdk-17.jdk/Contents/Home/lib/antlr-4.13.0-complete.jar -jar ./target/comet-0.1.0-alpha.jar"

def collect_test_cases():
  test_cases = []
  for dir in os.listdir(test_cases_dir):
    if os.path.isdir(test_cases_dir + dir):
      for f in os.listdir(test_cases_dir + dir):
        if os.path.splitext(f)[1] == '.mx':
          test_cases.append(dir + '/' + f)
  test_cases.sort()
  return test_cases

def main():
  test_cases = collect_test_cases()
  for test_name in test_cases:
    input = open(test_cases_dir + test_name, 'r')
    expected = ""
    comment = ""
    try:
      line_count = 0
      while line_count < 10:
        line_count += 1
        line = input.readline()
        pos = line.find("Verdict:")
        # print(line)
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
    print("Running test " + test_name + ":")
    print("  " + "Expected: " + expected + " " + comment)
    print("  " + "Result: " + result)
    expected_status = 0 if expected == "Success" else 1
    if status != expected_status:
      break

if __name__ == "__main__":
  main()