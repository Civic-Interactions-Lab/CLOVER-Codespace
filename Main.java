import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a date (MM/DD/YYYY): ");
        String date = scanner.nextLine();
        scanner.close();

        // TODO: Implement date validation logic
        // 1. Parse the date string to extract month, day, and year
        // 2. Validate the month (1-12)
        // 3. Validate the day based on the month and leap year rules
        // 4. Print whether the date is valid or why it is invalid

    }

    /**
     * Checks if a given year is a leap year.
     * 
     * Leap year rules:
     * - A year not divisible by 4 is a normal year.
     * - A year divisible by 4 is a leap year except...
     * - A year divisible by 100 is not a leap year except...
     * - A year divisible by 400 is a leap year.
     * 
     * @param year the year to check
     * @return true if the year is a leap year, false otherwise
     */
    public static boolean isLeapYear(int year) {
        // TODO: Implement leap year logic
        return false;
    }

    /**
     * Returns the number of days in a given month.
     * 
     * @param month the month (1-12)
     * @param year the year (used to determine leap year for February)
     * @return the number of days in the month, or -1 if month is invalid
     */
    public static int getDaysInMonth(int month, int year) {
        // TODO: Implement days in month logic
        return -1;
    }

    /**
     * Validates a date string in MM/DD/YYYY format.
     * 
     * @param dateStr the date string to validate
     * @return a message indicating whether the date is valid or why it is invalid
     */
    public static String validateDate(String dateStr) {
        // TODO: Implement date validation logic
        return "Not implemented yet";
    }
}
