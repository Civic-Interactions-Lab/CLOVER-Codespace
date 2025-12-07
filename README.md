# Warmup Exercise: Longest Word Finder

This repository contains a Java warmup assignment for students to practice basic programming concepts including:
- User input with Scanner
- Loops and conditionals
- String manipulation
- Arrays/ArrayLists

## Assignment

Write a few lines of code that prompts the user to enter a series of words, stopping when the user has entered the word "quit". The program should then print the length of the longest word entered or "no words entered" if no words other than "quit" were entered.

## Requirements

Implement the following in `Main.java`:

1. **Method: `getLongestWordLength(String[] words)`**
   - Takes an array of words as input
   - Returns the length of the longest word
   - Returns 0 if the array is empty or null

2. **Method: `main(String[] args)`**
   - Prompts the user to enter words
   - Continues reading until "quit" is entered
   - Stores all words (except "quit") in a collection
   - Calls `getLongestWordLength` with the collected words
   - Prints the result:
     - If words were entered: prints the length of the longest word
     - If no words entered: prints "no words entered"

## Example Output

```
Warmup Assignment: Longest Word Finder
Enter words (type 'quit' to finish):
hello
world
programming
quit
The longest word has length: 11
```

```
Warmup Assignment: Longest Word Finder
Enter words (type 'quit' to finish):
quit
no words entered
```
