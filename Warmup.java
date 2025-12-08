// Warmup Assignment: Longest Word Finder
// 
// Write a few lines of code that prompts the user to enter a series of words,
// stopping when the user has entered the word "quit". The program should then
// print the length of the longest word entered or "no words entered" if no
// words other than "quit" were entered.
//
// Example:
// Input: hello world programming quit
// Output: 11
//
// Example:
// Input: quit
// Output: no words entered

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

public class Warmup {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUpStreams() {
        outContent.reset();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    private String getLastLine(String output) {
        String[] lines = output.trim().split("\n");
        if (lines.length == 0 || lines[0].isEmpty()) return "";
        return lines[lines.length - 1].trim();
    }

    private void runWithInput(String input) {
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        main(new String[]{});
    }

    @Test
    public void testNoWordsEntered() {
        runWithInput("quit\n");
        assertEquals("no words entered", getLastLine(outContent.toString()));
    }

    @Test
    public void testSingleWord() {
        runWithInput("hello\nquit\n");
        assertEquals("5", getLastLine(outContent.toString()));
    }

    @Test
    public void testMultipleWords() {
        runWithInput("cat\ndog\nelephant\nquit\n");
        assertEquals("8", getLastLine(outContent.toString()));
    }

    @Test
    public void testSameLengthWords() {
        runWithInput("cat\ndog\nbat\nquit\n");
        assertEquals("3", getLastLine(outContent.toString()));
    }

    @Test
    public void testLongestAtBeginning() {
        runWithInput("elephant\ncat\ndog\nquit\n");
        assertEquals("8", getLastLine(outContent.toString()));
    }

    @Test
    public void testLongestAtEnd() {
        runWithInput("cat\ndog\nelephant\nquit\n");
        assertEquals("8", getLastLine(outContent.toString()));
    }

    @Test
    public void testSingleCharacter() {
        runWithInput("a\nb\nc\nquit\n");
        assertEquals("1", getLastLine(outContent.toString()));
    }

    @Test
    public void testVeryLongWord() {
        runWithInput("hi\nsupercalifragilisticexpialidocious\nbye\nquit\n");
        assertEquals("34", getLastLine(outContent.toString()));
    }

    @Test
    public void testTwoWords() {
        runWithInput("cat\nelephant\nquit\n");
        assertEquals("8", getLastLine(outContent.toString()));
    }

    @Test
    public void testMixedCase() {
        runWithInput("Hello\nWORLD\ntest\nquit\n");
        assertEquals("5", getLastLine(outContent.toString()));
    }

    @Test
    public void testEmptyWordInMiddle() {
        runWithInput("cat\n\ndog\nquit\n");
        assertEquals("3", getLastLine(outContent.toString()));
    }

    @Test
    public void testWordsWithSpaces() {
        runWithInput("hello world\ntest\nquit\n");
        assertEquals("11", getLastLine(outContent.toString()));
    }

    @Test
    public void testNumericalStrings() {
        runWithInput("123\n45678\n9\nquit\n");
        assertEquals("5", getLastLine(outContent.toString()));
    }

    @Test
    public void testSpecialCharacters() {
        runWithInput("hello!\ntest@\nworld#$\nquit\n");
        assertEquals("7", getLastLine(outContent.toString()));
    }

    @Test
    public void testAllSameLength() {
        runWithInput("one\ntwo\nsix\nquit\n");
        assertEquals("3", getLastLine(outContent.toString()));
    }

    @Test
    public void testShortAndLongMix() {
        runWithInput("a\nsuperlongword\nb\nquit\n");
        assertEquals("13", getLastLine(outContent.toString()));
    }

    @Test
    public void testMultipleLongest() {
        runWithInput("test\nword\nwork\nquit\n");
        assertEquals("4", getLastLine(outContent.toString()));
    }

    @Test
    public void testWordsWithTrailingSpaces() {
        runWithInput("hello   \nworld  \nquit\n");
        assertEquals("8", getLastLine(outContent.toString()));
    }

    @Test
    public void testHyphenatedWords() {
        runWithInput("test-word\nhello\nquit\n");
        assertEquals("9", getLastLine(outContent.toString()));
    }

    @Test
    public void testSingleVeryLongWord() {
        runWithInput("supercalifragilisticexpialidocious\nquit\n");
        assertEquals("34", getLastLine(outContent.toString()));
    }

    @Test
    public void testWordsWithUnderscores() {
        runWithInput("hello_world\ntest\nquit\n");
        assertEquals("11", getLastLine(outContent.toString()));
    }

    @Test
    public void testAlternatingLengths() {
        runWithInput("a\nbb\nccc\ndddd\neeeee\nquit\n");
        assertEquals("5", getLastLine(outContent.toString()));
    }

    @Test
    public void testPalindromeWords() {
        runWithInput("racecar\nlevel\nradar\nquit\n");
        assertEquals("7", getLastLine(outContent.toString()));
    }

    @Test
    public void testThreeWords() {
        runWithInput("one\ntwo\nthree\nquit\n");
        assertEquals("5", getLastLine(outContent.toString()));
    }

    @Test
    public void testWordsWithNumbers() {
        runWithInput("test1\ntest22\ntest333\nquit\n");
        assertEquals("7", getLastLine(outContent.toString()));
    }

    @Test
    public void testUnicodeCharacters() {
        runWithInput("café\nhello\nquit\n");
        assertEquals("5", getLastLine(outContent.toString()));
    }

    public static void main(String[] args) {
        // TODO: Implement the program here
        
    }
}
