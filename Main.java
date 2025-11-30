import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter daily rainfall amounts (enter -999 to stop):");

        ArrayList<Double> rainfallList = new ArrayList<>();
        int heavyRainDays = 0;

        while (true) {
            int value = scanner.nextInt();

            if (value == -999) {
                break;
            }

            if (value < 0) {
                System.out.println("Invalid rainfall, please enter a non-negative value or -999 to finish.");
                continue;
            }

            rainfallList.add((double) value);
            if (value >= 10) {
                heavyRainDays++;
            }
        }

        scanner.close();

        if (rainfallList.isEmpty()) {
            System.out.println("No rainfall data entered.");
        } else {
            double[] rainfallValues = new double[rainfallList.size()];
            for (int i = 0; i < rainfallList.size(); i++) {
                rainfallValues[i] = rainfallList.get(i);
            }

            double total = calculateTotal(rainfallValues);
            double average = calculateAverage(rainfallValues);

            System.out.println("Total rainfall: " + total);
            System.out.println("Average rainfall: " + average);
            System.out.println("Number of heavy rain days (>= 10 mm): " + heavyRainDays);
        }
    }

    /**
     * Calculates the total rainfall from an array of daily measurements.
     * Only non-negative values should be counted.
     * 
     * @param rainfallValues array of rainfall measurements
     * @return the total rainfall
     */
    public static double calculateTotal(double[] rainfallValues) {
        double total = 0.0;
        for (double value : rainfallValues) {
            if (isValidRainfall(value)) {
                total += value;
            }
        }
        return total;
    }

    /**
     * Calculates the average rainfall from an array of daily measurements.
     * Only non-negative values should be counted as valid measurements.
     * 
     * @param rainfallValues array of rainfall measurements
     * @return the average rainfall, or 0.0 if no valid (non-negative) measurements
     */
    public static double calculateAverage(double[] rainfallValues) {
        int count = 0;
        double total = 0.0;
        for (double value : rainfallValues) {
            if (isValidRainfall(value)) {
                total += value;
                count++;
            }
        }
        if (count == 0) {
            return 0.0;
        }
        return total / count;
    }

    /**
     * Checks if a rainfall value is valid (non-negative).
     * 
     * @param value the rainfall value to check
     * @return true if the value is valid (>= 0), false otherwise
     */
    public static boolean isValidRainfall(double value) {
        return value >= 0;
    }
}
