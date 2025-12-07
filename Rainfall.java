import java.util.Scanner;

public class Rainfall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter daily rainfall amounts (enter -999 to stop):");

        // TODO: Implement rainfall calculation logic
        // 1. Read rainfall values until -999 is entered
        // 2. Only count non-negative values (ignore negative values except -999)
        // 3. Calculate and print the total rainfall
        // 4. Calculate and print the average rainfall
        // 5. Calculate and print the number of heavy rain days (>= 10 mm)

        scanner.close();
    }

    /**
     * Calculates the total rainfall from an array of daily measurements.
     * Only non-negative values should be counted.
     * 
     * @param rainfallValues array of rainfall measurements
     * @return the total rainfall
     */
    public static double calculateTotal(double[] rainfallValues) {
        // TODO: Implement total calculation
        return 0.0;
    }

    /**
     * Calculates the average rainfall from an array of daily measurements.
     * Only non-negative values should be counted as valid measurements.
     * 
     * @param rainfallValues array of rainfall measurements
     * @return the average rainfall, or 0.0 if no valid (non-negative) measurements
     */
    public static double calculateAverage(double[] rainfallValues) {
        // TODO: Implement average calculation
        return 0.0;
    }

    /**
     * Checks if a rainfall value is valid (non-negative).
     * 
     * @param value the rainfall value to check
     * @return true if the value is valid (>= 0), false otherwise
     */
    public static boolean isValidRainfall(double value) {
        // TODO: Implement validation
        return false;
    }

    /**
     * Counts the number of days with heavy rainfall (>= 10 mm).
     * Only non-negative values should be counted as valid measurements.
     * 
     * @param rainfallValues array of rainfall measurements
     * @return the number of days with heavy rainfall (>= 10 mm)
     */
    public static int countHeavyRainDays(double[] rainfallValues) {
        // TODO: Implement heavy rain day counting
        return 0;
    }
}
