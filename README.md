# Warmup Exercise: Longest Word Finder

## Assignment

Implement a method that finds the length of the longest word in an array of strings.

## Requirements

Complete the `findLongestWordLength` method in `Warmup.java`:

- Takes an array of strings as input
- Returns the length of the longest word in the array
- Returns -1 if the array is empty or null

## Method Signature

```java
public static int findLongestWordLength(String[] words)
```

## Examples

```java
// Example 1
String[] words1 = {"hello", "world", "programming"};
int result1 = Warmup.findLongestWordLength(words1);
// Returns: 11 (length of "programming")

// Example 2
String[] words2 = {"cat", "dog"};
int result2 = Warmup.findLongestWordLength(words2);
// Returns: 3 (length of "cat" or "dog")

// Example 3
String[] words3 = {};
int result3 = Warmup.findLongestWordLength(words3);
// Returns: -1 (empty array)

// Example 4
String[] words4 = null;
int result4 = Warmup.findLongestWordLength(words4);
// Returns: -1 (null array)
```

## Testing

Your implementation will be tested with automated tests that check various scenarios:
- Empty arrays and null arrays
- Single word arrays
- Multiple words of different lengths
- Words with special characters, numbers, and spaces
- Edge cases like very long words
