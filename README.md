# Blame Pope Gregory XIII

**Author:** Andrew Rosen

## Abstract

This lab is an exercise that goes over `if/else` statements or `switch` statements, modular arithmetic, String indices, and converting Strings to integers.  
It is adapted from Savitch’s Java book.

---

## 1. Assignment

Write a program that, given a string as an input, tests if the given string is a valid date in the Gregorian Calendar. Your program should output whether the given date is valid. If the given date is not valid, report why.

- Dates in the US are formatted **MM/DD/YYYY**.
- Valid months are in the range `[1, 12]`.
- September, April, June, and November each have 30 days.
- All other months but February have 31 days.
- February has 28 days, except on a leap year, where it has 29.

**Leap year rules:**

- A year not divisible by 4 is a normal year.
- A year divisible by 4 is a leap year except...
- A year divisible by 100 is not a leap year except...
- A year divisible by 400 is a leap year.

**Examples:**

- 1644 → leap year
- 1645 → not a leap year
- 1600 → leap year
- 1700 → not a leap year

You will need to think of a way to arrange the logic of these statements. Think about different ways to categorize leap years and non-leap years.

> **Note:** The Gregorian Calendar is the most widely used civil calendar, instituted by Pope Gregory XIII (1572–1585). Some countries resisted using it until well into the 1900s.

---

## 2. Hints

To complete this assignment, you will need to utilize some methods not used in class. Start by reading in the user’s input using `input()`.

### 2.1 Slicing a String

To get a small portion of the string, use slice notation:

```python
s = "My name"

s2 = s[0:2]  # "My"
s3 = s[3:6]  # "nam"
s4 = s[3:]   # "name"
s5 = s[3]    # "n"
space = s[2:3]  # " "
```
Slicing returns a substring from start to, but not including, end.
Indices in Python start at 0.
### 2.2 Converting Strings to Integers
Use int() to convert a string into an integer:
```python
s = "123"
i = int(s)  # 123
```

Combine this with slicing to extract the month, date, and year, then convert each into an int with int().
The rest of the program is logic!

### 2.3 Other Hints
The month is the first thing you want to check.
The year only matters in February.
Work on the other months first.
## 3. Grading Criteria
30 points – The program can tell if the input is a date.
30 points – The program correctly handles non-leap year dates.
30 points – The program correctly handles leap year dates.
10 points – The source code is reasonably formatted.
## 4. A Postscript About Time
This program may have been difficult, but you have only scratched the surface. Time and dates are complicated by many factors, including daylight savings, odd time zones, historical calendar conversions, governmental policy, and leap seconds.
Take this lesson to heart: Do not meddle with time.

In your future career:

Rely on libraries others have provided for you.
Ask yourself: do you actually care about the actual time, or just internal consistency?
📺 Video Reference: Computerphile – The Problem with Time & Dates (Tim Scott)
