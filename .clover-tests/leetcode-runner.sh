#!/bin/bash
# LeetCode-style test runner for student's implementation
# Runs tests without revealing test file location or exact assertions

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(dirname "$SCRIPT_DIR")"

# Validate function signatures
validate_signatures() {
    local java_file="$1"
    
    if [ ! -f "$java_file" ]; then
        echo "Error: Rainfall.java not found"
        return 1
    fi
    
    # Check for required function signatures
    local missing=""
    
    if ! grep -q "public.*static.*calculateTotal.*double\[\]" "$java_file"; then
        missing="${missing}  ✗ calculateTotal\n    Expected: public static double calculateTotal(double[] rainfallValues)\n\n"
    fi
    
    if ! grep -q "public.*static.*calculateAverage.*double\[\]" "$java_file"; then
        missing="${missing}  ✗ calculateAverage\n    Expected: public static double calculateAverage(double[] rainfallValues)\n\n"
    fi
    
    if ! grep -q "public.*static.*boolean.*isValidRainfall" "$java_file"; then
        missing="${missing}  ✗ isValidRainfall\n    Expected: public static boolean isValidRainfall(double value)\n\n"
    fi
    
    if ! grep -q "public.*static.*int.*countHeavyRainDays.*double\[\]" "$java_file"; then
        missing="${missing}  ✗ countHeavyRainDays\n    Expected: public static int countHeavyRainDays(double[] rainfallValues)\n\n"
    fi
    
    if [ -n "$missing" ]; then
        echo "=================================================="
        echo "ERROR: Missing or Renamed Functions"
        echo "=================================================="
        echo ""
        echo "The following required functions are missing or have been renamed:"
        echo ""
        echo -e "$missing"
        echo "Please ensure all required function names and signatures match exactly."
        echo "Do not rename the functions provided in the starter code."
        echo ""
        return 1
    fi
    
    return 0
}

# Check if Rainfall.java exists
RAINFALL_FILE="$PROJECT_DIR/Rainfall.java"
if [ ! -f "$RAINFALL_FILE" ]; then
    echo "Error: Rainfall.java not found"
    exit 1
fi

# Validate function signatures
if ! validate_signatures "$RAINFALL_FILE"; then
    exit 1
fi

# Create temp directory for compilation
TEMP_DIR=$(mktemp -d)
trap "rm -rf $TEMP_DIR" EXIT

# Download JUnit if not available
JUNIT_JAR="$SCRIPT_DIR/junit-platform-console-standalone.jar"
if [ ! -f "$JUNIT_JAR" ]; then
    echo "Downloading test framework..."
    if ! curl -sL "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.0/junit-platform-console-standalone-1.10.0.jar" -o "$JUNIT_JAR"; then
        echo "Error downloading JUnit. Please ensure you have internet connectivity."
        exit 1
    fi
fi

# Copy source files to temp directory
cp "$RAINFALL_FILE" "$TEMP_DIR/"
cp "$SCRIPT_DIR/RainfallTest.java" "$TEMP_DIR/"

# Compile
echo "Compiling..."
cd "$TEMP_DIR"
COMPILE_OUTPUT=$(javac -cp "$JUNIT_JAR" Rainfall.java RainfallTest.java 2>&1)
COMPILE_STATUS=$?

# Filter compilation errors to show only student code errors
if [ $COMPILE_STATUS -ne 0 ]; then
    echo "$COMPILE_OUTPUT" | grep -v "RainfallTest.java" | grep -v "^$" || true
    echo "Compilation failed!"
    exit 1
fi

echo ""
echo "Running Test Cases..."
echo "=================================================="
echo ""

# Run tests and capture output
TEST_OUTPUT=$(java -jar "$JUNIT_JAR" --class-path "$TEMP_DIR" --scan-class-path --details=tree 2>&1)

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
