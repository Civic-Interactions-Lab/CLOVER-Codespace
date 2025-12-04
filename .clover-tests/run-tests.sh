#!/bin/bash
# Run JUnit tests for student's Rainfall.java implementation
# This script is hidden from students and used by instructors to evaluate submissions

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(dirname "$SCRIPT_DIR")"

# Check if Rainfall.java exists
if [ ! -f "$PROJECT_DIR/Rainfall.java" ]; then
    echo "Error: Rainfall.java not found in project directory"
    exit 1
fi

# Create temp directory for compilation
TEMP_DIR=$(mktemp -d)
trap "rm -rf $TEMP_DIR" EXIT

# Download JUnit if not available
JUNIT_JAR="$SCRIPT_DIR/junit-platform-console-standalone.jar"
if [ ! -f "$JUNIT_JAR" ]; then
    echo "Downloading JUnit..."
    curl -sL "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.0/junit-platform-console-standalone-1.10.0.jar" -o "$JUNIT_JAR"
fi

# Copy source files to temp directory
cp "$PROJECT_DIR/Rainfall.java" "$TEMP_DIR/"
cp "$SCRIPT_DIR/RainfallTest.java" "$TEMP_DIR/"

# Compile
echo "Compiling..."
cd "$TEMP_DIR"
javac -cp "$JUNIT_JAR" Rainfall.java RainfallTest.java 2>&1

if [ $? -ne 0 ]; then
    echo "Compilation failed!"
    exit 1
fi

# Run tests
echo "Running tests..."
java -jar "$JUNIT_JAR" --class-path "$TEMP_DIR" --scan-class-path --details=verbose

exit $?
