#!/bin/bash
# Run script for Java assignments
# Runs unit tests with LeetCode-style output

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# Check if the test runner exists
TEST_RUNNER="$SCRIPT_DIR/.clover-tests/leetcode-runner.py"

if [ ! -f "$TEST_RUNNER" ]; then
    echo "Error: Test runner not found"
    exit 1
fi

# Run the LeetCode-style test runner
python3 "$TEST_RUNNER"
