#!/bin/bash
# Integration tests for the Longest Word Finder assignment
# Tests the program by providing input and checking output

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(dirname "$SCRIPT_DIR")"

# Check if Warmup.java exists
if [ ! -f "$PROJECT_DIR/Warmup.java" ]; then
    echo "Error: Warmup.java not found in project directory"
    exit 1
fi

# Compile the program
echo "Compiling..."
echo ""
cd "$PROJECT_DIR"
javac Warmup.java 2>&1
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
    
    # Run the program with input and capture last line of stdout
    actual=$(echo -e "$input" | java Warmup 2>&1 | grep -v "^Exception" | grep -v "^Error" | tail -1)
    
    # Check if output matches
    if [ "$actual" = "$expected" ]; then
        echo "Test Case $TOTAL_TESTS: ✓ PASSED"
        PASSED_TESTS=$((PASSED_TESTS + 1))
    else
        echo "Test Case $TOTAL_TESTS: ✗ FAILED"
    fi
}

echo "Running Test Cases..."
echo "=================================================="
echo ""

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

# Test 11: Empty word (just enter with no text)
run_test "Empty word in middle" "cat\n\ndog\nquit" "3"

# Test 13: Numerical strings
run_test "Numerical strings" "123\n45678\n9\nquit" "5"

# Test 14: Special characters
run_test "Special characters" "hello!\ntest@\nworld#$\nquit" "7"

# Test 15: All same length
run_test "All same length" "one\ntwo\nsix\nquit" "3"

# Test 16: Very short and long mix
run_test "Short and long mix" "a\nsuperlongword\nb\nquit" "13"

# Test 17: Multiple longest words
run_test "Multiple longest" "test\nword\nwork\nquit" "4"

# Test 19: Hyphenated words
run_test "Hyphenated words" "test-word\nhello\nquit" "9"

# Test 20: Single very long word
run_test "Single very long word" "supercalifragilisticexpialidocious\nquit" "34"

# Test 21: Words with underscores
run_test "Words with underscores" "hello_world\ntest\nquit" "11"

# Test 22: Alternating lengths
run_test "Alternating lengths" "a\nbb\nccc\ndddd\neeeee\nquit" "5"

# Test 23: Palindromes
run_test "Palindrome words" "racecar\nlevel\nradar\nquit" "7"

# Test 24: Three words
run_test "Three words" "one\ntwo\nthree\nquit" "5"

# Test 25: Words ending with numbers
run_test "Words with numbers" "test1\ntest22\ntest333\nquit" "7"

# Test 26: Unicode/special characters
run_test "Unicode characters" "café\nhello\nquit" "5"

echo ""
echo "=================================================="
echo "Test Results Summary"
echo "=================================================="
echo "Total Test Cases: $TOTAL_TESTS"
echo "Passed: $PASSED_TESTS"
echo "Failed: $((TOTAL_TESTS - PASSED_TESTS))"
echo ""

if [ $PASSED_TESTS -eq $TOTAL_TESTS ]; then
    echo "Status: ✓ All tests passed"
    echo ""
    echo "Great job! Your implementation passes all test cases."
    exit 0
else
    echo "Status: ✗ Some tests failed"
    echo ""
    echo "Keep working on your implementation to pass all test cases."
    exit 1
fi
