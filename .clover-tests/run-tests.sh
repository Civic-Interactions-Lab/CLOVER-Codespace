#!/bin/bash
# Run tests for student's Warmup.java implementation
# This script is hidden from students and used by instructors to evaluate submissions

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# Run the LeetCode-style test runner
bash "$SCRIPT_DIR/leetcode-test-runner.sh"

exit $?
