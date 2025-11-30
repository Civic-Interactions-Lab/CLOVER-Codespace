#!/bin/bash
# Run script for the Rainfall Problem Java assignment
# Compiles and runs Main.java

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# Compile Main.java
echo "Compiling Main.java..."
javac "$SCRIPT_DIR/Main.java" 2>&1

if [ $? -ne 0 ]; then
    echo "Compilation failed!"
    exit 1
fi

# Run the program
echo "Running program..."
echo "---"
java -cp "$SCRIPT_DIR" Main
