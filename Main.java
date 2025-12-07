// Warmup Assignment: Longest Word Finder
// 
// Write a few lines of code that prompts the user to enter a series of words,
// stopping when the user has entered the word "quit". The program should then
// print the length of the longest word entered or "no words entered" if no
// words other than "quit" were entered.
//
// TODO: Implement the following methods to make all unit tests pass

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    
    /**
     * Returns the length of the longest word in the array.
     * Returns 0 if the array is empty or null.
     * 
     * @param words Array of words to search
     * @return Length of the longest word, or 0 if no words
     */
    public static int getLongestWordLength(String[] words) {
        // TODO: Implement this method
        // Hint: Check if the array is null or empty first
        // Then loop through the words and track the maximum length
        return 0; // Replace with your implementation
    }
    
    /**
     * Main method that prompts the user to enter words until "quit" is entered.
     * Then prints the length of the longest word or "no words entered" if applicable.
     * 
     * Example output:
     *   If words entered: "The longest word has length: 11"
     *   If no words entered: "no words entered"
     */
    public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create a Scanner to read user input
        // 2. Create an ArrayList to store words
        // 3. Loop to read words until "quit" is entered (don't add "quit" to the list)
        // 4. Convert ArrayList to array and call getLongestWordLength
        // 5. Print appropriate message based on result
        
        System.out.println("Warmup Assignment: Longest Word Finder");
        System.out.println("Enter words (type 'quit' to finish):");
        
        // Your implementation here
    }
}
