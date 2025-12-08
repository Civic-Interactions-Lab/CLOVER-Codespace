#!/bin/bash
# LeetCode-style test runner for student's implementation
# Runs tests without revealing test file location or exact assertions

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(dirname "$SCRIPT_DIR")"

# Check if Warmup.java exists
WARMUP_FILE="$PROJECT_DIR/Warmup.java"
if [ ! -f "$WARMUP_FILE" ]; then
    echo "Error: Warmup.java not found"
    exit 1
fi

# Create temp directory for compilation
TEMP_DIR=$(mktemp -d)
trap "rm -rf $TEMP_DIR" EXIT

# Check if JUnit is available
JUNIT_JAR="$PROJECT_DIR/lib/junit-platform-console-standalone-1.10.1.jar"
if [ ! -f "$JUNIT_JAR" ]; then
    echo "Error: JUnit test framework not found"
    exit 1
fi

# Copy source files to temp directory
cp "$WARMUP_FILE" "$TEMP_DIR/"
cp "$SCRIPT_DIR/WarmupTest.java" "$TEMP_DIR/"

# Compile
echo "Compiling..."
cd "$TEMP_DIR"
COMPILE_OUTPUT=$(javac -cp "$JUNIT_JAR" Warmup.java WarmupTest.java 2>&1)
COMPILE_STATUS=$?

# Show compilation errors if any
if [ $COMPILE_STATUS -ne 0 ]; then
    echo "$COMPILE_OUTPUT" | grep -v "WarmupTest.java" | grep -v "^$" || true
    echo "Compilation failed!"
    exit 1
fi

echo ""
echo "Running Test Cases..."
echo "=================================================="
echo ""

# Run tests and capture output
TEST_OUTPUT=$(java -jar "$JUNIT_JAR" --class-path "$TEMP_DIR" --select-class WarmupTest --details=tree 2>&1)

# Parse and display results in LeetCode style
TEST_NUM=1
PASSED=0
FAILED=0

# Process each test case line
while IFS= read -r line; do
    if [[ "$line" =~ │\ \ \ \ \ ├─|│\ \ \ \ \ └─ ]]; then
        # Found a test case line
        if [[ "$line" =~ ✔ ]]; then
            echo "Test Case $TEST_NUM: ✓ PASSED"
            ((PASSED++))
            ((TEST_NUM++))
        elif [[ "$line" =~ ✘ ]]; then
            echo "Test Case $TEST_NUM: ✗ FAILED"
            ((FAILED++))
            ((TEST_NUM++))
        fi
    fi
done <<< "$TEST_OUTPUT"

TOTAL=$((PASSED + FAILED))

echo ""
echo "=================================================="
echo "Test Results Summary"
echo "=================================================="
echo "Total Test Cases: $TOTAL"
echo "Passed: $PASSED"
echo "Failed: $FAILED"

if [ $FAILED -eq 0 ]; then
    echo ""
    echo "Status: ✓ All tests passed!"
    exit 0
else
    echo ""
    echo "Status: ✗ Some tests failed"
    echo ""
    echo "Keep working on your implementation to pass all test cases."
    exit 1
fi
