import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Main class longest word finder.
 * These tests verify student implementation of the getLongestWordLength method.
 */
public class MainTest {

    // ==================== Basic Tests ====================

    @Test
    @DisplayName("Single word should return its length")
    public void testSingleWord() {
        String[] words = {"hello"};
        assertEquals(5, Main.getLongestWordLength(words), 
            "Length of 'hello' should be 5");
    }

    @Test
    @DisplayName("Multiple words with different lengths")
    public void testMultipleWords() {
        String[] words = {"cat", "elephant", "dog", "bird"};
        assertEquals(8, Main.getLongestWordLength(words), 
            "Longest word 'elephant' has length 8");
    }

    @Test
    @DisplayName("Words with same length should return that length")
    public void testSameLengthWords() {
        String[] words = {"cat", "dog", "bat", "rat"};
        assertEquals(3, Main.getLongestWordLength(words), 
            "All words have length 3");
    }

    @Test
    @DisplayName("Empty array should return 0")
    public void testEmptyArray() {
        String[] words = {};
        assertEquals(0, Main.getLongestWordLength(words), 
            "Empty array should return 0");
    }

    @Test
    @DisplayName("Null array should return 0")
    public void testNullArray() {
        assertEquals(0, Main.getLongestWordLength(null), 
            "Null array should return 0");
    }

    // ==================== Edge Cases ====================

    @Test
    @DisplayName("Single character words")
    public void testSingleCharacters() {
        String[] words = {"a", "b", "c"};
        assertEquals(1, Main.getLongestWordLength(words), 
            "Single character words have length 1");
    }

    @Test
    @DisplayName("Very long word")
    public void testVeryLongWord() {
        String[] words = {"a", "supercalifragilisticexpialidocious", "cat"};
        assertEquals(34, Main.getLongestWordLength(words), 
            "Very long word should be detected");
    }

    @Test
    @DisplayName("Longest word at the beginning")
    public void testLongestAtBeginning() {
        String[] words = {"elephant", "cat", "dog"};
        assertEquals(8, Main.getLongestWordLength(words), 
            "Longest word at beginning should be detected");
    }

    @Test
    @DisplayName("Longest word at the end")
    public void testLongestAtEnd() {
        String[] words = {"cat", "dog", "elephant"};
        assertEquals(8, Main.getLongestWordLength(words), 
            "Longest word at end should be detected");
    }

    @Test
    @DisplayName("Longest word in the middle")
    public void testLongestInMiddle() {
        String[] words = {"cat", "elephant", "dog"};
        assertEquals(8, Main.getLongestWordLength(words), 
            "Longest word in middle should be detected");
    }

    // ==================== Special Characters and Cases ====================

    @Test
    @DisplayName("Words with numbers")
    public void testWordsWithNumbers() {
        String[] words = {"abc123", "hello", "x"};
        assertEquals(6, Main.getLongestWordLength(words), 
            "Words with numbers should count all characters");
    }

    @Test
    @DisplayName("Mixed case words")
    public void testMixedCase() {
        String[] words = {"Hello", "WORLD", "test"};
        assertEquals(5, Main.getLongestWordLength(words), 
            "Case should not affect length calculation");
    }

    @Test
    @DisplayName("Words with special characters")
    public void testSpecialCharacters() {
        String[] words = {"hello!", "world?", "test"};
        assertEquals(6, Main.getLongestWordLength(words), 
            "Special characters should be counted");
    }

    // ==================== Multiple Longest Words ====================

    @Test
    @DisplayName("Two words with same longest length")
    public void testTwoLongestWords() {
        String[] words = {"elephant", "computer", "cat"};
        assertEquals(8, Main.getLongestWordLength(words), 
            "Should return length when multiple words have same max length");
    }

    @Test
    @DisplayName("All words same length")
    public void testAllSameLength() {
        String[] words = {"one", "two", "six", "ten"};
        assertEquals(3, Main.getLongestWordLength(words), 
            "Should return length when all words are same length");
    }

    // ==================== Large Dataset Tests ====================

    @Test
    @DisplayName("Large number of words")
    public void testLargeDataset() {
        String[] words = new String[100];
        for (int i = 0; i < 99; i++) {
            words[i] = "word" + i;
        }
        words[99] = "verylongwordhere";
        assertEquals(16, Main.getLongestWordLength(words), 
            "Should handle large arrays efficiently");
    }

    @Test
    @DisplayName("Increasing word lengths")
    public void testIncreasingLengths() {
        String[] words = {"a", "ab", "abc", "abcd", "abcde"};
        assertEquals(5, Main.getLongestWordLength(words), 
            "Should find longest in increasing sequence");
    }

    @Test
    @DisplayName("Decreasing word lengths")
    public void testDecreasingLengths() {
        String[] words = {"abcde", "abcd", "abc", "ab", "a"};
        assertEquals(5, Main.getLongestWordLength(words), 
            "Should find longest in decreasing sequence");
    }

    // ==================== Empty String Tests ====================

    @Test
    @DisplayName("Array with empty strings")
    public void testWithEmptyStrings() {
        String[] words = {"", "hello", "", "world"};
        assertEquals(5, Main.getLongestWordLength(words), 
            "Should handle empty strings and find longest non-empty word");
    }

    @Test
    @DisplayName("All empty strings")
    public void testAllEmptyStrings() {
        String[] words = {"", "", ""};
        assertEquals(0, Main.getLongestWordLength(words), 
            "All empty strings should return 0");
    }
}
