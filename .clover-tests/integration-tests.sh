#!/bin/bash
# Integration tests for the Longest Word Finder assignment
# Tests the program by providing input and checking output

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(dirname "$SCRIPT_DIR")"

# Check if Main.java exists
if [ ! -f "$PROJECT_DIR/Main.java" ]; then
    echo "Error: Main.java not found in project directory"
    exit 1
fi

# Compile the program
echo "Compiling Main.java..."
cd "$PROJECT_DIR"
javac Main.java 2>&1
if [ $? -ne 0 ]; then
    echo "Compilation failed!"
    exit 1
fi

# Test results tracking
TOTAL_TESTS=0
PASSED_TESTS=0

# Function to run a test
run_test() {
    local test_name="$1"
    local input="$2"
    local expected="$3"
    
    TOTAL_TESTS=$((TOTAL_TESTS + 1))
    
    echo ""
    echo "Test $TOTAL_TESTS: $test_name"
    echo "  Input: $input"
    
    # Run the program with input and capture last line of stdout
    actual=$(echo -e "$input" | java Main 2>&1 | grep -v "^Exception" | grep -v "^Error" | tail -1)
    
    echo "  Expected: $expected"
    echo "  Actual: $actual"
    
    # Check if output matches
    if [ "$actual" = "$expected" ]; then
        echo "  ✓ PASS"
        PASSED_TESTS=$((PASSED_TESTS + 1))
    else
        echo "  ✗ FAIL"
    fi
}

echo "========================================"
echo "Running Integration Tests"
echo "========================================"

# Test 1: No words entered (just quit)
run_test "No words entered" "quit" "no words entered"

# Test 2: Single word
run_test "Single word" "hello\nquit" "5"

# Test 3: Multiple words with different lengths
run_test "Multiple words" "cat\ndog\nelephant\nquit" "8"

# Test 4: Words with same length
run_test "Same length words" "cat\ndog\nbat\nquit" "3"

# Test 5: Longest word at beginning
run_test "Longest at beginning" "elephant\ncat\ndog\nquit" "8"

# Test 6: Longest word at end
run_test "Longest at end" "cat\ndog\nelephant\nquit" "8"

# Test 7: Single character words
run_test "Single character" "a\nb\nc\nquit" "1"

# Test 8: Very long word
run_test "Very long word" "hi\nsupercalifragilisticexpialidocious\nbye\nquit" "34"

# Test 9: Two words, longer one second
run_test "Two words" "cat\nelephant\nquit" "8"

# Test 10: Mixed case
run_test "Mixed case words" "Hello\nWORLD\ntest\nquit" "5"

echo ""
echo "========================================"
echo "Test Results"
echo "========================================"
echo "Total Tests: $TOTAL_TESTS"
echo "Passed: $PASSED_TESTS"
echo "Failed: $((TOTAL_TESTS - PASSED_TESTS))"
echo "========================================"

if [ $PASSED_TESTS -eq $TOTAL_TESTS ]; then
    echo "All tests passed! ✓"
    exit 0
else
    echo "Some tests failed."
    exit 1
fi
