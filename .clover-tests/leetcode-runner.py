#!/usr/bin/env python3
"""
LeetCode-style test runner for student's implementation
Runs tests without revealing test file location or exact assertions
"""

import subprocess
import sys
import os
import re
import tempfile
import shutil
from pathlib import Path

def validate_function_signatures(rainfall_file):
    """
    Validate that required function signatures are present in the student's code.
    This prevents students from accidentally renaming functions.
    """
    with open(rainfall_file, 'r') as f:
        content = f.read()
    
    # Required function signatures
    required_functions = [
        ('calculateTotal', 'public static double calculateTotal(double[] rainfallValues)'),
        ('calculateAverage', 'public static double calculateAverage(double[] rainfallValues)'),
        ('isValidRainfall', 'public static boolean isValidRainfall(double value)')
    ]
    
    missing_functions = []
    for func_name, signature in required_functions:
        # Check if the function exists with public static modifier
        pattern = f'public\\s+static\\s+.*\\s+{func_name}\\s*\\('
        if not re.search(pattern, content):
            missing_functions.append(func_name)
    
    if missing_functions:
        print("=" * 50)
        print("ERROR: Missing or Renamed Functions")
        print("=" * 50)
        print("")
        print("The following required functions are missing or have been renamed:")
        print("")
        for func_name, signature in required_functions:
            if func_name in missing_functions:
                print(f"  ✗ {func_name}")
                print(f"    Expected: {signature}")
        print("")
        print("Please ensure all required function names and signatures match exactly.")
        print("Do not rename the functions provided in the starter code.")
        print("")
        return False
    
    return True

def run_tests():
    script_dir = Path(__file__).parent.resolve()
    project_dir = script_dir.parent
    rainfall_file = project_dir / "Rainfall.java"
    
    # Check if Rainfall.java exists
    if not rainfall_file.exists():
        print("Error: Rainfall.java not found")
        return 1
    
    # Validate function signatures before running tests
    if not validate_function_signatures(rainfall_file):
        return 1
    
    # Create temp directory for compilation
    with tempfile.TemporaryDirectory() as temp_dir:
        temp_path = Path(temp_dir)
        
        # Check for JUnit JAR and download if needed
        junit_jar = script_dir / "junit-platform-console-standalone.jar"
        junit_jar = junit_jar.resolve()  # Resolve to absolute path and symbolic links
        if not junit_jar.exists():
            print("Downloading test framework...")
            import urllib.request
            try:
                # Download from Maven Central over HTTPS
                jar_url = "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.0/junit-platform-console-standalone-1.10.0.jar"
                urllib.request.urlretrieve(jar_url, junit_jar)
            except Exception as e:
                print(f"Error downloading JUnit: {e}")
                print("Please ensure you have internet connectivity.")
                return 1
        
        # Copy source files to temp directory
        shutil.copy(rainfall_file, temp_path / "Rainfall.java")
        shutil.copy(script_dir / "RainfallTest.java", temp_path / "RainfallTest.java")
        
        def filter_student_errors(error_text):
            """Filter compilation errors to show only student code errors"""
            if not error_text:
                return ""
            if "RainfallTest.java" not in error_text:
                return error_text
            # Filter out lines referencing test file
            filtered_lines = [line for line in error_text.split('\n') 
                            if line and "RainfallTest.java" not in line]
            return '\n'.join(filtered_lines)
        
        # Compile
        print("Compiling...")
        compile_result = subprocess.run(
            ["javac", "-cp", str(junit_jar), "Rainfall.java", "RainfallTest.java"],
            cwd=temp_path,
            capture_output=True,
            text=True
        )
        
        if compile_result.returncode != 0:
            # Only show compilation errors related to student's code
            filtered_errors = filter_student_errors(compile_result.stderr)
            if filtered_errors:
                print(filtered_errors)
            print("Compilation failed!")
            return 1
        
        print("")
        print("Running Test Cases...")
        print("=" * 50)
        print("")
        
        # Run tests with detailed output
        test_result = subprocess.run(
            ["java", "-jar", str(junit_jar), "--class-path", str(temp_path), 
             "--scan-class-path", "--details=tree"],
            cwd=temp_path,
            capture_output=True,
            text=True
        )
        
        # Parse test output
        output = test_result.stdout + test_result.stderr
        
        # Extract test results - the format is:
        # │     ├─ Test Name ✘ error message
        # │     ├─ Test Name ✔
        tests = []
        lines = output.split('\n')
        
        for line in lines:
            # Look for test case lines - they have ├─ or └─ followed by test name
            if ('│     ├─' in line or '│     └─' in line):
                # Extract test name and status
                if '✘' in line:
                    # Failed test
                    parts = line.split('✘', 1)
                    if len(parts) > 0:
                        test_name = parts[0].split('─')[-1].strip()
                        tests.append({'name': test_name, 'status': 'FAILED'})
                elif '✔' in line:
                    # Passed test
                    parts = line.split('✔', 1)
                    if len(parts) > 0:
                        test_name = parts[0].split('─')[-1].strip()
                        tests.append({'name': test_name, 'status': 'SUCCESSFUL'})
        
        # Display results in LeetCode style
        PASSED_STATUS = 'SUCCESSFUL'
        FAILED_STATUS = 'FAILED'
        
        for idx, test in enumerate(tests, 1):
            if test['status'] == PASSED_STATUS:
                print(f"Test Case {idx}: ✓ PASSED")
            else:
                print(f"Test Case {idx}: ✗ FAILED")
        
        # Get summary statistics
        passed = sum(1 for t in tests if t['status'] == PASSED_STATUS)
        failed = len(tests) - passed
        
        print("")
        print("=" * 50)
        print("Test Results Summary")
        print("=" * 50)
        print(f"Total Test Cases: {len(tests)}")
        print(f"Passed: {passed}")
        print(f"Failed: {failed}")
        
        if failed == 0:
            print("")
            print("Status: ✓ All tests passed!")
            return 0
        else:
            print("")
            print("Status: ✗ Some tests failed")
            print("")
            print("Keep working on your implementation to pass all test cases.")
            return 1

if __name__ == "__main__":
    sys.exit(run_tests())
