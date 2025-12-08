#!/bin/bash
# Run script for Java assignments
# Runs unit tests with LeetCode-style output

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# Run LeetCode-style test runner
TEST_RUNNER="$SCRIPT_DIR/.clover-tests/leetcode-test-runner.sh"

if [ -f "$TEST_RUNNER" ]; then
    bash "$TEST_RUNNER"
else
    echo "Error: Test runner not found"
    exit 1
fi
