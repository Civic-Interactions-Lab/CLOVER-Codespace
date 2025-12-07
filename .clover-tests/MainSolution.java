// Reference solution for the Longest Word Finder assignment
// This file is for instructor reference only

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int maxLength = 0;
        boolean hasWords = false;
        
        while (true) {
            String word = scanner.nextLine();
            if (word.equals("quit")) {
                break;
            }
            hasWords = true;
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        
        scanner.close();
        
        if (hasWords) {
            System.out.println(maxLength);
        } else {
            System.out.println("no words entered");
        }
    }
}
