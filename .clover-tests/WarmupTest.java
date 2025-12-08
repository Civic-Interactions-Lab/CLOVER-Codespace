// Unit tests for Warmup assignment
// This file tests the student's implementation in Warmup.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WarmupTest {

    @Test
    public void testEmptyArray() {
        assertEquals(-1, Warmup.findLongestWordLength(new String[]{}));
    }

    @Test
    public void testNullArray() {
        assertEquals(-1, Warmup.findLongestWordLength(null));
    }

    @Test
    public void testSingleWord() {
        assertEquals(5, Warmup.findLongestWordLength(new String[]{"hello"}));
    }

    @Test
    public void testMultipleWords() {
        assertEquals(8, Warmup.findLongestWordLength(new String[]{"cat", "dog", "elephant"}));
    }

    @Test
    public void testSameLengthWords() {
        assertEquals(3, Warmup.findLongestWordLength(new String[]{"cat", "dog", "bat"}));
    }

    @Test
    public void testLongestAtBeginning() {
        assertEquals(8, Warmup.findLongestWordLength(new String[]{"elephant", "cat", "dog"}));
    }

    @Test
    public void testLongestAtEnd() {
        assertEquals(8, Warmup.findLongestWordLength(new String[]{"cat", "dog", "elephant"}));
    }

    @Test
    public void testSingleCharacter() {
        assertEquals(1, Warmup.findLongestWordLength(new String[]{"a", "b", "c"}));
    }

    @Test
    public void testVeryLongWord() {
        assertEquals(34, Warmup.findLongestWordLength(new String[]{"hi", "supercalifragilisticexpialidocious", "bye"}));
    }

    @Test
    public void testTwoWords() {
        assertEquals(8, Warmup.findLongestWordLength(new String[]{"cat", "elephant"}));
    }

    @Test
    public void testMixedCase() {
        assertEquals(5, Warmup.findLongestWordLength(new String[]{"Hello", "WORLD", "test"}));
    }

    @Test
    public void testEmptyStringInArray() {
        assertEquals(3, Warmup.findLongestWordLength(new String[]{"cat", "", "dog"}));
    }

    @Test
    public void testWordsWithSpaces() {
        assertEquals(11, Warmup.findLongestWordLength(new String[]{"hello world", "test"}));
    }

    @Test
    public void testNumericalStrings() {
        assertEquals(5, Warmup.findLongestWordLength(new String[]{"123", "45678", "9"}));
    }

    @Test
    public void testSpecialCharacters() {
        assertEquals(7, Warmup.findLongestWordLength(new String[]{"hello!", "test@", "world#$"}));
    }

    @Test
    public void testAllSameLength() {
        assertEquals(3, Warmup.findLongestWordLength(new String[]{"one", "two", "six"}));
    }

    @Test
    public void testShortAndLongMix() {
        assertEquals(13, Warmup.findLongestWordLength(new String[]{"a", "superlongword", "b"}));
    }

    @Test
    public void testMultipleLongest() {
        assertEquals(4, Warmup.findLongestWordLength(new String[]{"test", "word", "work"}));
    }

    @Test
    public void testWordsWithTrailingSpaces() {
        assertEquals(8, Warmup.findLongestWordLength(new String[]{"hello   ", "world  "}));
    }

    @Test
    public void testHyphenatedWords() {
        assertEquals(9, Warmup.findLongestWordLength(new String[]{"test-word", "hello"}));
    }

    @Test
    public void testSingleVeryLongWord() {
        assertEquals(34, Warmup.findLongestWordLength(new String[]{"supercalifragilisticexpialidocious"}));
    }

    @Test
    public void testWordsWithUnderscores() {
        assertEquals(11, Warmup.findLongestWordLength(new String[]{"hello_world", "test"}));
    }

    @Test
    public void testAlternatingLengths() {
        assertEquals(5, Warmup.findLongestWordLength(new String[]{"a", "bb", "ccc", "dddd", "eeeee"}));
    }

    @Test
    public void testPalindromeWords() {
        assertEquals(7, Warmup.findLongestWordLength(new String[]{"racecar", "level", "radar"}));
    }

    @Test
    public void testThreeWords() {
        assertEquals(5, Warmup.findLongestWordLength(new String[]{"one", "two", "three"}));
    }

    @Test
    public void testWordsWithNumbers() {
        assertEquals(7, Warmup.findLongestWordLength(new String[]{"test1", "test22", "test333"}));
    }

    @Test
    public void testUnicodeCharacters() {
        assertEquals(5, Warmup.findLongestWordLength(new String[]{"café", "hello"}));
    }

    @Test
    public void testQuitAtBeginning() {
        assertEquals(-1, Warmup.findLongestWordLength(new String[]{"quit", "hello", "world"}));
    }

    @Test
    public void testQuitInMiddle() {
        assertEquals(5, Warmup.findLongestWordLength(new String[]{"hello", "quit", "world", "programming"}));
    }

    @Test
    public void testQuitAtEnd() {
        assertEquals(11, Warmup.findLongestWordLength(new String[]{"hello", "world", "programming", "quit"}));
    }

    @Test
    public void testMultipleQuit() {
        assertEquals(5, Warmup.findLongestWordLength(new String[]{"hello", "quit", "world", "quit", "test"}));
    }

    @Test
    public void testQuitOnly() {
        assertEquals(-1, Warmup.findLongestWordLength(new String[]{"quit"}));
    }

    @Test
    public void testQuitCaseSensitive() {
        assertEquals(11, Warmup.findLongestWordLength(new String[]{"hello", "QUIT", "programming"}));
    }
}
