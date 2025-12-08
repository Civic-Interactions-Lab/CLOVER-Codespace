#!/bin/bash
# Run tests for student's Warmup.java implementation
# This script is hidden from students and used by instructors to evaluate submissions

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(dirname "$SCRIPT_DIR")"

# Run the LeetCode-style test runner
bash "$SCRIPT_DIR/leetcode-test-runner.sh"
TEST_EXIT_CODE=$?

# Run the main method for manual testing
echo ""
echo "=================================================="
echo "Running Warmup.main() for manual testing"
echo "=================================================="
echo ""

cd "$PROJECT_DIR"
if [ -f "Warmup.java" ]; then
    # Compile if needed
    COMPILE_OUTPUT=$(javac -cp ".:lib/*" Warmup.java 2>&1)
    if [ $? -eq 0 ]; then
        # Run the main method
        java -cp ".:lib/*" Warmup
    else
        echo "Compilation failed for manual test run:"
        echo "$COMPILE_OUTPUT"
    fi
else
    echo "Warmup.java not found"
fi

exit $TEST_EXIT_CODE
