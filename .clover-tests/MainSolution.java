// Reference solution for the Longest Word Finder assignment
// This file is for instructor reference only

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
        if (words == null || words.length == 0) {
            return 0;
        }
        
        int maxLength = 0;
        for (String word : words) {
            if (word != null && word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        return maxLength;
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
        System.out.println("Warmup Assignment: Longest Word Finder");
        System.out.println("Enter words (type 'quit' to finish):");
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> wordList = new ArrayList<>();
        
        while (true) {
            String word = scanner.nextLine();
            if (word.equals("quit")) {
                break;
            }
            wordList.add(word);
        }
        
        scanner.close();
        
        if (wordList.isEmpty()) {
            System.out.println("no words entered");
        } else {
            String[] wordsArray = wordList.toArray(new String[0]);
            int longestLength = getLongestWordLength(wordsArray);
            System.out.println("The longest word has length: " + longestLength);
        }
    }
}
