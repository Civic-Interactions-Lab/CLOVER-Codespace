# Warmup Exercise: Longest Word Finder

## Assignment

Write a few lines of code that prompts the user to enter a series of words, stopping when the user has entered the word "quit". The program should then print the length of the longest word entered or "no words entered" if no words other than "quit" were entered.

## Requirements

Complete the `main` method in `Warmup.java`:

- Read words from user input (one per line)
- Stop reading when "quit" is entered
- Track the longest word length
- Print the output:
  - If words were entered: print just the length number (e.g., `11`)
  - If no words entered: print `no words entered`

You can implement this however you like - there are no required methods or specific data structures you must use.

## Example Output

```
hello
world
programming
quit
11
```

```
quit
no words entered
```

## Testing

Your program will be tested with automated tests. Make sure your output matches exactly:
- Print only the number (no extra text) when words are entered
- Print exactly `no words entered` when only quit is entered
