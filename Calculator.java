import java.util.Scanner;

public class Calculator {

    static double add(double a, double b) { return a + b; }
    static double subtract(double a, double b) { return a - b; }
    static double multiply(double a, double b) { return a * b; }
    static double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }
    static double modulo(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot modulo by zero");
        return a % b;
    }
    static double power(double base, double exp) { return Math.pow(base, exp); }
    static double sqrt(double a) {
        if (a < 0) throw new ArithmeticException("Cannot take square root of a negative number");
        return Math.sqrt(a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============================");
        System.out.println("       Java Calculator       ");
        System.out.println("============================");

        while (true) {
            System.out.println("\nSelect an operation:");
            System.out.println("  1. Addition        (+)");
            System.out.println("  2. Subtraction     (-)");
            System.out.println("  3. Multiplication  (*)");
            System.out.println("  4. Division        (/)");
            System.out.println("  5. Modulo          (%)");
            System.out.println("  6. Power           (^)");
            System.out.println("  7. Square Root     (√)");
            System.out.println("  0. Exit");
            System.out.print("\nEnter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                if (choice == 7) {
                    System.out.print("Enter number: ");
                    double a = Double.parseDouble(scanner.nextLine().trim());
                    double result = sqrt(a);
                    System.out.printf("√%.4f = %.4f%n", a, result);
                } else if (choice >= 1 && choice <= 6) {
                    System.out.print("Enter first number:  ");
                    double a = Double.parseDouble(scanner.nextLine().trim());
                    System.out.print("Enter second number: ");
                    double b = Double.parseDouble(scanner.nextLine().trim());

                    double result;
                    String op;

                    switch (choice) {
                        case 1: result = add(a, b);      op = "+"; break;
                        case 2: result = subtract(a, b); op = "-"; break;
                        case 3: result = multiply(a, b); op = "*"; break;
                        case 4: result = divide(a, b);   op = "/"; break;
                        case 5: result = modulo(a, b);   op = "%"; break;
                        case 6: result = power(a, b);    op = "^"; break;
                        default: throw new IllegalStateException();
                    }

                    System.out.printf("%.4f %s %.4f = %.4f%n", a, op, b, result);
                } else {
                    System.out.println("Invalid choice. Please select 0-7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number entered.");
            } catch (ArithmeticException e) {
                System.out.println("Math error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
