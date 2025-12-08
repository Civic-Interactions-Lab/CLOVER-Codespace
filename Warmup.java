// Warmup Assignment: Longest Word Finder
// 
// Implement a method that finds the length of the longest word in an array.
// If the array is empty or null, return -1.
//
// Example:
// Input: ["hello", "world", "programming"]
// Output: 11
//
// Example:
// Input: []
// Output: -1

public class Warmup {
    /**
     * Finds the length of the longest word in the given array.
     * 
     * @param words an array of strings to search through
     * @return the length of the longest word, or -1 if the array is empty or null
     */
    public static int findLongestWordLength(String[] words) {
        // TODO: Implement this method
        return -1;
    }

    /**
     * Main method for testing your implementation.
     * DO NOT implement the logic here - implement it in findLongestWordLength() above.
     * Use this main method only for manual testing of your findLongestWordLength() method.
     */
    public static void main(String[] args) {
        // Example test cases - you can modify these to test your implementation
        String[] test1 = {"hello", "world", "programming"};
        System.out.println("Test 1: " + findLongestWordLength(test1)); // Should return 11
        
        String[] test2 = {"cat", "dog"};
        System.out.println("Test 2: " + findLongestWordLength(test2)); // Should return 3
        
        String[] test3 = {};
        System.out.println("Test 3: " + findLongestWordLength(test3)); // Should return -1
        
        // Note: This test may throw NullPointerException if your implementation doesn't handle null
        try {
            String[] test4 = null;
            System.out.println("Test 4: " + findLongestWordLength(test4)); // Should return -1
        } catch (NullPointerException e) {
            System.out.println("Test 4: NullPointerException - make sure to handle null input!");
        }
    }
}
