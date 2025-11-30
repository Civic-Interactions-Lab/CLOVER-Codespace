import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Main class rainfall calculation methods.
 * These tests verify student implementation of rainfall total,
 * average calculation, and input validation.
 */
public class MainTest {

    // ==================== Input Validation Tests ====================

    @Test
    @DisplayName("Positive rainfall values should be valid")
    public void testPositiveRainfallIsValid() {
        assertTrue(Main.isValidRainfall(10), "10 should be valid rainfall");
        assertTrue(Main.isValidRainfall(0.5), "0.5 should be valid rainfall");
        assertTrue(Main.isValidRainfall(100), "100 should be valid rainfall");
    }

    @Test
    @DisplayName("Zero rainfall should be valid")
    public void testZeroRainfallIsValid() {
        assertTrue(Main.isValidRainfall(0), "0 should be valid rainfall");
    }

    @Test
    @DisplayName("Negative rainfall values should be invalid")
    public void testNegativeRainfallIsInvalid() {
        assertFalse(Main.isValidRainfall(-1), "-1 should be invalid rainfall");
        assertFalse(Main.isValidRainfall(-999), "-999 should be invalid rainfall");
        assertFalse(Main.isValidRainfall(-0.5), "-0.5 should be invalid rainfall");
    }

    // ==================== Total Calculation Tests ====================

    @Test
    @DisplayName("Total of basic rainfall values")
    public void testBasicTotal() {
        double[] values = {10, 20, 0, 15};
        assertEquals(45.0, Main.calculateTotal(values), 0.001, 
            "Total of [10, 20, 0, 15] should be 45.0");
    }

    @Test
    @DisplayName("Total of single value")
    public void testSingleValueTotal() {
        double[] values = {25};
        assertEquals(25.0, Main.calculateTotal(values), 0.001, 
            "Total of [25] should be 25.0");
    }

    @Test
    @DisplayName("Total of empty array should be zero")
    public void testEmptyArrayTotal() {
        double[] values = {};
        assertEquals(0.0, Main.calculateTotal(values), 0.001, 
            "Total of empty array should be 0.0");
    }

    @Test
    @DisplayName("Total with decimal values")
    public void testDecimalTotal() {
        double[] values = {1.5, 2.5, 3.0};
        assertEquals(7.0, Main.calculateTotal(values), 0.001, 
            "Total of [1.5, 2.5, 3.0] should be 7.0");
    }

    @Test
    @DisplayName("Total with all zeros")
    public void testAllZerosTotal() {
        double[] values = {0, 0, 0, 0};
        assertEquals(0.0, Main.calculateTotal(values), 0.001, 
            "Total of all zeros should be 0.0");
    }

    // ==================== Average Calculation Tests ====================

    @Test
    @DisplayName("Average of basic rainfall values")
    public void testBasicAverage() {
        double[] values = {10, 20, 0, 15};
        assertEquals(11.25, Main.calculateAverage(values), 0.001, 
            "Average of [10, 20, 0, 15] should be 11.25");
    }

    @Test
    @DisplayName("Average of single value")
    public void testSingleValueAverage() {
        double[] values = {25};
        assertEquals(25.0, Main.calculateAverage(values), 0.001, 
            "Average of [25] should be 25.0");
    }

    @Test
    @DisplayName("Average of empty array should be zero")
    public void testEmptyArrayAverage() {
        double[] values = {};
        assertEquals(0.0, Main.calculateAverage(values), 0.001, 
            "Average of empty array should be 0.0");
    }

    @Test
    @DisplayName("Average with decimal values")
    public void testDecimalAverage() {
        double[] values = {1.5, 2.5, 3.0};
        assertEquals(2.333, Main.calculateAverage(values), 0.01, 
            "Average of [1.5, 2.5, 3.0] should be approximately 2.333");
    }

    @Test
    @DisplayName("Average with all zeros")
    public void testAllZerosAverage() {
        double[] values = {0, 0, 0, 0};
        assertEquals(0.0, Main.calculateAverage(values), 0.001, 
            "Average of all zeros should be 0.0");
    }

    @Test
    @DisplayName("Average with large dataset")
    public void testLargeDatasetAverage() {
        double[] values = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        assertEquals(55.0, Main.calculateAverage(values), 0.001, 
            "Average of [10, 20, 30, ..., 100] should be 55.0");
    }

    // ==================== Edge Cases ====================

    @Test
    @DisplayName("Large rainfall values")
    public void testLargeValues() {
        double[] values = {1000, 2000, 3000};
        assertEquals(6000.0, Main.calculateTotal(values), 0.001);
        assertEquals(2000.0, Main.calculateAverage(values), 0.001);
    }

    @Test
    @DisplayName("Very small rainfall values")
    public void testSmallValues() {
        double[] values = {0.1, 0.2, 0.3};
        assertEquals(0.6, Main.calculateTotal(values), 0.001);
        assertEquals(0.2, Main.calculateAverage(values), 0.001);
    }
}
