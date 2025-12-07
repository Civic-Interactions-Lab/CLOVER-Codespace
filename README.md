# The Rainfall Problem

## Description
This assignment will provide you with practice using Java variables and expressions, if/else statements, Scanner objects for interactive programming, and writing methods.

Users will provide daily rainfall measurements, and the program will output statistics about the rainfall data according to the rules that follow.

## The Program
You will write a Java class called Rainfall that must be saved into a file called Rainfall.java, which should be submitted through Canvas.

Your program will read in daily rainfall measurements for some period of time, and it will calculate statistics about the rainfall. Below is one example log of execution of the program (user input is underlined for the sake of clarity in the log --- you do not need to duplicate this behavior).

**An example run of the program:**

```
Enter daily rainfall amounts (enter -999 to stop):
10
20
0
15
-999
Total rainfall = 45.0
Average rainfall = 11.25
Number of heavy rain days (>= 10 mm) = 3
```

The program processes an input consisting of daily rainfall measurements (non-negative numbers) until it encounters the integer -999. The program should output the total rainfall, average rainfall, and the number of heavy rain days (days with rainfall >= 10 mm).

Your program should be careful to handle invalid numeric values entered by the user. If a user enters a negative number (other than -999), it should be ignored and not included in the calculations. The sentinel value -999 is used only to signal the end of input.

## Testing and Running Your Code

This assignment includes automated tests that will help you verify your implementation. **Your grade will be based on passing these tests**, so it is important to run them frequently as you develop your solution.

To run the tests and execute your program:
1. Click the **Run** button in your development environment
2. The automated tests will run first, showing you which test cases pass or fail
3. After the tests complete, your program will run interactively so you can test it manually

The automated tests check:
- Input validation (handling negative values and the -999 sentinel)
- Total rainfall calculation
- Average rainfall calculation
- Heavy rain day counting (days with >= 10 mm rainfall)

## Stylistic Guidelines
When handling numeric data, you are expected to choose appropriately between types int and double.

Please indent your code and use whitespace to make your program readable. Give meaningful names to variables in your code. Follow Java's naming and capitalization standards.

Include a comment at the beginning of your program with basic information and a description of the program.

## Rubric
* [25 points] Proper handling of invalid inputs
* [25 points] The program correctly outputs average
* [25 points] The program correctly outputs total
* [25 points] The program correctly outputs the number of heavy rain days (>= 10 mm)
