import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Rainfall class rainfall calculation methods.
 * These tests verify student implementation of rainfall total,
 * average calculation, and input validation.
 */
public class RainfallTest {

    // ==================== Input Validation Tests ====================

    @Test
    @DisplayName("Positive rainfall values should be valid")
    public void testPositiveRainfallIsValid() {
        assertTrue(Rainfall.isValidRainfall(10), "10 should be valid rainfall");
        assertTrue(Rainfall.isValidRainfall(0.5), "0.5 should be valid rainfall");
        assertTrue(Rainfall.isValidRainfall(100), "100 should be valid rainfall");
    }

    @Test
    @DisplayName("Zero rainfall should be valid")
    public void testZeroRainfallIsValid() {
        assertTrue(Rainfall.isValidRainfall(0), "0 should be valid rainfall");
    }

    @Test
    @DisplayName("Negative rainfall values should be invalid")
    public void testNegativeRainfallIsInvalid() {
        assertFalse(Rainfall.isValidRainfall(-1), "-1 should be invalid rainfall");
        assertFalse(Rainfall.isValidRainfall(-999), "-999 should be invalid rainfall");
        assertFalse(Rainfall.isValidRainfall(-0.5), "-0.5 should be invalid rainfall");
    }

    // ==================== Total Calculation Tests ====================

    @Test
    @DisplayName("Total of basic rainfall values")
    public void testBasicTotal() {
        double[] values = {10, 20, 0, 15};
        assertEquals(45.0, Rainfall.calculateTotal(values), 0.001, 
            "Total of [10, 20, 0, 15] should be 45.0");
    }

    @Test
    @DisplayName("Total of single value")
    public void testSingleValueTotal() {
        double[] values = {25};
        assertEquals(25.0, Rainfall.calculateTotal(values), 0.001, 
            "Total of [25] should be 25.0");
    }

    @Test
    @DisplayName("Total of empty array should be zero")
    public void testEmptyArrayTotal() {
        double[] values = {};
        assertEquals(0.0, Rainfall.calculateTotal(values), 0.001, 
            "Total of empty array should be 0.0");
    }

    @Test
    @DisplayName("Total with decimal values")
    public void testDecimalTotal() {
        double[] values = {1.5, 2.5, 3.0};
        assertEquals(7.0, Rainfall.calculateTotal(values), 0.001, 
            "Total of [1.5, 2.5, 3.0] should be 7.0");
    }

    @Test
    @DisplayName("Total with all zeros")
    public void testAllZerosTotal() {
        double[] values = {0, 0, 0, 0};
        assertEquals(0.0, Rainfall.calculateTotal(values), 0.001, 
            "Total of all zeros should be 0.0");
    }

    // ==================== Average Calculation Tests ====================

    @Test
    @DisplayName("Average of basic rainfall values")
    public void testBasicAverage() {
        double[] values = {10, 20, 0, 15};
        assertEquals(11.25, Rainfall.calculateAverage(values), 0.001, 
            "Average of [10, 20, 0, 15] should be 11.25");
    }

    @Test
    @DisplayName("Average of single value")
    public void testSingleValueAverage() {
        double[] values = {25};
        assertEquals(25.0, Rainfall.calculateAverage(values), 0.001, 
            "Average of [25] should be 25.0");
    }

    @Test
    @DisplayName("Average of empty array should be zero")
    public void testEmptyArrayAverage() {
        double[] values = {};
        assertEquals(0.0, Rainfall.calculateAverage(values), 0.001, 
            "Average of empty array should be 0.0");
    }

    @Test
    @DisplayName("Average with decimal values")
    public void testDecimalAverage() {
        double[] values = {1.5, 2.5, 3.0};
        assertEquals(2.333, Rainfall.calculateAverage(values), 0.01, 
            "Average of [1.5, 2.5, 3.0] should be approximately 2.333");
    }

    @Test
    @DisplayName("Average with all zeros")
    public void testAllZerosAverage() {
        double[] values = {0, 0, 0, 0};
        assertEquals(0.0, Rainfall.calculateAverage(values), 0.001, 
            "Average of all zeros should be 0.0");
    }

    @Test
    @DisplayName("Average with large dataset")
    public void testLargeDatasetAverage() {
        double[] values = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        assertEquals(55.0, Rainfall.calculateAverage(values), 0.001, 
            "Average of [10, 20, 30, ..., 100] should be 55.0");
    }

    // ==================== Edge Cases ====================

    @Test
    @DisplayName("Large rainfall values")
    public void testLargeValues() {
        double[] values = {1000, 2000, 3000};
        assertEquals(6000.0, Rainfall.calculateTotal(values), 0.001);
        assertEquals(2000.0, Rainfall.calculateAverage(values), 0.001);
    }

    @Test
    @DisplayName("Very small rainfall values")
    public void testSmallValues() {
        double[] values = {0.1, 0.2, 0.3};
        assertEquals(0.6, Rainfall.calculateTotal(values), 0.001);
        assertEquals(0.2, Rainfall.calculateAverage(values), 0.001);
    }

    // ==================== Heavy Rain Day Counting Tests ====================

    @Test
    @DisplayName("Count heavy rain days with basic values")
    public void testBasicHeavyRainDays() {
        double[] values = {10, 20, 0, 15};
        assertEquals(3, Rainfall.countHeavyRainDays(values), 
            "Should count 3 heavy rain days (10, 20, 15)");
    }

    @Test
    @DisplayName("Count heavy rain days with no heavy rain")
    public void testNoHeavyRainDays() {
        double[] values = {5, 2, 0, 9, 9.9};
        assertEquals(0, Rainfall.countHeavyRainDays(values), 
            "Should count 0 heavy rain days when all values < 10");
    }

    @Test
    @DisplayName("Count heavy rain days with all heavy rain")
    public void testAllHeavyRainDays() {
        double[] values = {10, 15, 20, 100};
        assertEquals(4, Rainfall.countHeavyRainDays(values), 
            "Should count 4 heavy rain days when all values >= 10");
    }

    @Test
    @DisplayName("Count heavy rain days with exactly 10 mm")
    public void testExactlyTenMmIsHeavy() {
        double[] values = {10, 10.0, 9.9, 10.1};
        assertEquals(3, Rainfall.countHeavyRainDays(values), 
            "Should count exactly 10 mm as heavy rain");
    }

    @Test
    @DisplayName("Count heavy rain days with empty array")
    public void testEmptyArrayHeavyRain() {
        double[] values = {};
        assertEquals(0, Rainfall.countHeavyRainDays(values), 
            "Empty array should have 0 heavy rain days");
    }

    @Test
    @DisplayName("Count heavy rain days with single heavy rain day")
    public void testSingleHeavyRainDay() {
        double[] values = {25};
        assertEquals(1, Rainfall.countHeavyRainDays(values), 
            "Single value >= 10 should count as 1 heavy rain day");
    }

    @Test
    @DisplayName("Count heavy rain days with single light rain day")
    public void testSingleLightRainDay() {
        double[] values = {5};
        assertEquals(0, Rainfall.countHeavyRainDays(values), 
            "Single value < 10 should count as 0 heavy rain days");
    }

    @Test
    @DisplayName("Count heavy rain days with mixed values")
    public void testMixedHeavyRainDays() {
        double[] values = {0, 5, 10, 15, 9.9, 10.1, 100, 0.5};
        assertEquals(4, Rainfall.countHeavyRainDays(values), 
            "Should count 4 heavy rain days (10, 15, 10.1, 100)");
    }

    @Test
    @DisplayName("Count heavy rain days with large values")
    public void testLargeValuesHeavyRain() {
        double[] values = {1000, 2000, 3000};
        assertEquals(3, Rainfall.countHeavyRainDays(values), 
            "All large values should be counted as heavy rain days");
    }

    @Test
    @DisplayName("Count heavy rain days with small values below threshold")
    public void testSmallValuesNoHeavyRain() {
        double[] values = {0.1, 0.2, 0.3, 1.5, 2.5, 3.0};
        assertEquals(0, Rainfall.countHeavyRainDays(values), 
            "All small values below 10 should result in 0 heavy rain days");
    }
}
