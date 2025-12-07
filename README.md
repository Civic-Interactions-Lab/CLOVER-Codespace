## Description

This assignment will provide you with practice using Java variables, Scanner objects for interactive programming, and writing methods.

Users will provide a series of words, and the program will output the length of the longest word entered according to some rules that follow.

## The Program

You will write a Java class called Warmup that must be saved into a file called Warmup.java, which should be submitted through Canvas.

Remember that you will be using a Scanner object for console input, so you will need to import java.util.Scanner; into your program.

Your program will read in words from the user, and it will calculate the length of the longest word. Below is one example log of execution of the program (user input is underlined for the sake of clarity in the log --- you do not need to duplicate this behavior).

**an example run of the program**

```
hello
world
programming
quit
11
```

The program prompts the user to enter a series of words, stopping when the user has entered the word "quit". The program should then print the length of the longest word entered or "no words entered" if no words other than "quit" were entered.

Complete the `main` method in `Warmup.java`:

- Read words from user input (one per line)
- Stop reading when "quit" is entered
- Track the longest word length
- Print the output:
  - If words were entered: print just the length number (e.g., `11`)
  - If no words entered: print `no words entered`

You can implement this however you like - there are no required methods or specific data structures you must use.

In the log of execution shown, the user entered three words: "hello" (5 letters), "world" (5 letters), and "programming" (11 letters), before entering "quit" to stop. The program then output 11, which is the length of the longest word.

Another example execution:

```
quit
no words entered
```

In this execution, the user immediately entered "quit" without entering any other words, so the program output "no words entered".

## Stylistic Guidelines

Please indent your code and use whitespace to make your program readable. Give meaningful names to variables in your code. Follow Java's naming and capitalization standards.

Include a comment at the beginning of your program with basic information and a description of the program.

Your program will be tested with automated input/output tests. Make sure your output matches exactly:
- Print only the number (no extra text) when words are entered
- Print exactly `no words entered` when only quit is entered

## rubric

* [2 points] Scanner set up properly
* [2 points] Readable indentation and spacing
* [3 points] Proper handling of edge cases (empty input, only "quit")
* [5 points] Correct tracking of longest word length
* [3 points] Descriptive variable and constant names
* [5 points] Calculates correct longest word length
