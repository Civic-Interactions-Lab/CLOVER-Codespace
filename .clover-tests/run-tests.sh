#!/bin/bash
# Run integration tests for student's Warmup.java implementation
# This script is hidden from students and used by instructors to evaluate submissions

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# Run the integration tests
bash "$SCRIPT_DIR/integration-tests.sh"

exit $?
