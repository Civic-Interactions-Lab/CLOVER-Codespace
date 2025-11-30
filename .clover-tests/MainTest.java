import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Main class date validation methods.
 * These tests verify student implementation of leap year logic,
 * days in month calculation, and date validation.
 */
public class MainTest {

    // ==================== Leap Year Tests ====================

    @Test
    @DisplayName("Regular years not divisible by 4 should not be leap years")
    public void testRegularYearNotLeap() {
        assertFalse(Main.isLeapYear(2001), "2001 should not be a leap year");
        assertFalse(Main.isLeapYear(2019), "2019 should not be a leap year");
        assertFalse(Main.isLeapYear(1645), "1645 should not be a leap year");
    }

    @Test
    @DisplayName("Years divisible by 4 but not by 100 should be leap years")
    public void testDivisibleBy4IsLeap() {
        assertTrue(Main.isLeapYear(2004), "2004 should be a leap year");
        assertTrue(Main.isLeapYear(2020), "2020 should be a leap year");
        assertTrue(Main.isLeapYear(1644), "1644 should be a leap year");
        assertTrue(Main.isLeapYear(2024), "2024 should be a leap year");
    }

    @Test
    @DisplayName("Years divisible by 100 but not by 400 should not be leap years")
    public void testDivisibleBy100NotLeap() {
        assertFalse(Main.isLeapYear(1700), "1700 should not be a leap year");
        assertFalse(Main.isLeapYear(1800), "1800 should not be a leap year");
        assertFalse(Main.isLeapYear(1900), "1900 should not be a leap year");
        assertFalse(Main.isLeapYear(2100), "2100 should not be a leap year");
    }

    @Test
    @DisplayName("Years divisible by 400 should be leap years")
    public void testDivisibleBy400IsLeap() {
        assertTrue(Main.isLeapYear(1600), "1600 should be a leap year");
        assertTrue(Main.isLeapYear(2000), "2000 should be a leap year");
        assertTrue(Main.isLeapYear(2400), "2400 should be a leap year");
    }

    // ==================== Days in Month Tests ====================

    @Test
    @DisplayName("January, March, May, July, August, October, December should have 31 days")
    public void testMonthsWith31Days() {
        assertEquals(31, Main.getDaysInMonth(1, 2023), "January should have 31 days");
        assertEquals(31, Main.getDaysInMonth(3, 2023), "March should have 31 days");
        assertEquals(31, Main.getDaysInMonth(5, 2023), "May should have 31 days");
        assertEquals(31, Main.getDaysInMonth(7, 2023), "July should have 31 days");
        assertEquals(31, Main.getDaysInMonth(8, 2023), "August should have 31 days");
        assertEquals(31, Main.getDaysInMonth(10, 2023), "October should have 31 days");
        assertEquals(31, Main.getDaysInMonth(12, 2023), "December should have 31 days");
    }

    @Test
    @DisplayName("April, June, September, November should have 30 days")
    public void testMonthsWith30Days() {
        assertEquals(30, Main.getDaysInMonth(4, 2023), "April should have 30 days");
        assertEquals(30, Main.getDaysInMonth(6, 2023), "June should have 30 days");
        assertEquals(30, Main.getDaysInMonth(9, 2023), "September should have 30 days");
        assertEquals(30, Main.getDaysInMonth(11, 2023), "November should have 30 days");
    }

    @Test
    @DisplayName("February should have 28 days in non-leap years")
    public void testFebruaryNonLeapYear() {
        assertEquals(28, Main.getDaysInMonth(2, 2023), "February 2023 should have 28 days");
        assertEquals(28, Main.getDaysInMonth(2, 1900), "February 1900 should have 28 days");
        assertEquals(28, Main.getDaysInMonth(2, 2019), "February 2019 should have 28 days");
    }

    @Test
    @DisplayName("February should have 29 days in leap years")
    public void testFebruaryLeapYear() {
        assertEquals(29, Main.getDaysInMonth(2, 2024), "February 2024 should have 29 days");
        assertEquals(29, Main.getDaysInMonth(2, 2000), "February 2000 should have 29 days");
        assertEquals(29, Main.getDaysInMonth(2, 2020), "February 2020 should have 29 days");
    }

    @Test
    @DisplayName("Invalid months should return -1")
    public void testInvalidMonth() {
        assertEquals(-1, Main.getDaysInMonth(0, 2023), "Month 0 is invalid");
        assertEquals(-1, Main.getDaysInMonth(13, 2023), "Month 13 is invalid");
        assertEquals(-1, Main.getDaysInMonth(-1, 2023), "Month -1 is invalid");
    }

    // ==================== Date Validation Tests ====================

    @Test
    @DisplayName("Valid dates should be accepted")
    public void testValidDates() {
        String result1 = Main.validateDate("01/15/2023");
        assertTrue(result1.toLowerCase().contains("valid") && !result1.toLowerCase().contains("invalid"),
                "01/15/2023 should be valid");

        String result2 = Main.validateDate("12/31/2023");
        assertTrue(result2.toLowerCase().contains("valid") && !result2.toLowerCase().contains("invalid"),
                "12/31/2023 should be valid");

        String result3 = Main.validateDate("06/30/2023");
        assertTrue(result3.toLowerCase().contains("valid") && !result3.toLowerCase().contains("invalid"),
                "06/30/2023 should be valid");
    }

    @Test
    @DisplayName("Invalid month should be rejected")
    public void testInvalidMonthInDate() {
        String result1 = Main.validateDate("13/15/2023");
        assertTrue(result1.toLowerCase().contains("invalid") || result1.toLowerCase().contains("month"),
                "Month 13 should be invalid");

        String result2 = Main.validateDate("00/15/2023");
        assertTrue(result2.toLowerCase().contains("invalid") || result2.toLowerCase().contains("month"),
                "Month 0 should be invalid");
    }

    @Test
    @DisplayName("Invalid day should be rejected")
    public void testInvalidDayInDate() {
        String result1 = Main.validateDate("01/32/2023");
        assertTrue(result1.toLowerCase().contains("invalid") || result1.toLowerCase().contains("day"),
                "Day 32 in January should be invalid");

        String result2 = Main.validateDate("04/31/2023");
        assertTrue(result2.toLowerCase().contains("invalid") || result2.toLowerCase().contains("day"),
                "Day 31 in April should be invalid");

        String result3 = Main.validateDate("06/00/2023");
        assertTrue(result3.toLowerCase().contains("invalid") || result3.toLowerCase().contains("day"),
                "Day 0 should be invalid");
    }

    @Test
    @DisplayName("February 29 should be valid on leap years")
    public void testFeb29LeapYear() {
        String result1 = Main.validateDate("02/29/2024");
        assertTrue(result1.toLowerCase().contains("valid") && !result1.toLowerCase().contains("invalid"),
                "02/29/2024 should be valid (leap year)");

        String result2 = Main.validateDate("02/29/2000");
        assertTrue(result2.toLowerCase().contains("valid") && !result2.toLowerCase().contains("invalid"),
                "02/29/2000 should be valid (leap year)");
    }

    @Test
    @DisplayName("February 29 should be invalid on non-leap years")
    public void testFeb29NonLeapYear() {
        String result1 = Main.validateDate("02/29/2023");
        assertTrue(result1.toLowerCase().contains("invalid") || result1.toLowerCase().contains("day"),
                "02/29/2023 should be invalid (not a leap year)");

        String result2 = Main.validateDate("02/29/1900");
        assertTrue(result2.toLowerCase().contains("invalid") || result2.toLowerCase().contains("day"),
                "02/29/1900 should be invalid (not a leap year)");
    }

    @Test
    @DisplayName("Edge case: last day of each month")
    public void testLastDayOfMonth() {
        // Test last valid day of each month in non-leap year
        assertTrue(Main.validateDate("01/31/2023").toLowerCase().contains("valid"));
        assertTrue(Main.validateDate("02/28/2023").toLowerCase().contains("valid"));
        assertTrue(Main.validateDate("03/31/2023").toLowerCase().contains("valid"));
        assertTrue(Main.validateDate("04/30/2023").toLowerCase().contains("valid"));
        assertTrue(Main.validateDate("05/31/2023").toLowerCase().contains("valid"));
        assertTrue(Main.validateDate("06/30/2023").toLowerCase().contains("valid"));
        assertTrue(Main.validateDate("07/31/2023").toLowerCase().contains("valid"));
        assertTrue(Main.validateDate("08/31/2023").toLowerCase().contains("valid"));
        assertTrue(Main.validateDate("09/30/2023").toLowerCase().contains("valid"));
        assertTrue(Main.validateDate("10/31/2023").toLowerCase().contains("valid"));
        assertTrue(Main.validateDate("11/30/2023").toLowerCase().contains("valid"));
        assertTrue(Main.validateDate("12/31/2023").toLowerCase().contains("valid"));
    }
}
