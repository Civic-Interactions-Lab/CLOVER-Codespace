import java.util.Scanner;

public class Warmup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter revenue: ");
        double revenue = scanner.nextDouble();
        
        System.out.print("Enter expenses: ");
        double expenses = scanner.nextDouble();
        
        // TODO: Write an if/else statement that prints "in the black" if revenue 
        // is the same or higher than expenses, otherwise print out "in the red."
        
        scanner.close();
    }
}
