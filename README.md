# The Rainfall Problem

**Author:** Elliot Soloway

## Abstract

The rainfall problem is a programming exercise where users input daily rainfall amounts until a sentinel value (e.g., -999) is entered, after which the program calculates and reports the total and average rainfall.

---

## 1. Assignment

Write a program that processes an input consisting of daily rainfall measurements (non-negative integers) until it encounters the integer -999. The program should output the total and average of the numbers.

**Example:**

```
Enter daily rainfall amounts (enter -999 to stop):
10
20
0
15
-999
Total rainfall = 45.0
Average rainfall = 11.25
```

---

## 2. Hints

To complete this assignment, you will need to utilize some methods not used in class.

### 2.1 Reading User Input

Use `Scanner` to read input from the user:

```java
Scanner scanner = new Scanner(System.in);
int value = scanner.nextInt();  // Read an integer
```

### 2.2 Using a Loop

Use a `while` loop to keep reading values until -999 is entered:

```java
int value = scanner.nextInt();
while (value != -999) {
    // Process the value
    value = scanner.nextInt();
}
```

### 2.3 Calculating Average

Remember that average = total / count. Be careful to avoid division by zero!

```java
double average = total / count;
```

---

## 3. Grading Criteria

- 30 points - The program can tell if the input is valid.
- 30 points - The program correctly outputs average.
- 30 points - The program correctly outputs total.
- 10 points - The source code is reasonably formatted.
