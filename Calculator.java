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

    // --- Scientific Operations ---
    static double sin(double a)  { return Math.sin(Math.toRadians(a)); }
    static double cos(double a)  { return Math.cos(Math.toRadians(a)); }
    static double tan(double a) {
        if (Math.abs(Math.cos(Math.toRadians(a))) < 1e-10)
            throw new ArithmeticException("tan is undefined at " + a + "°");
        return Math.tan(Math.toRadians(a));
    }
    static double log10(double a) {
        if (a <= 0) throw new ArithmeticException("log10 requires a positive number");
        return Math.log10(a);
    }
    static double ln(double a) {
        if (a <= 0) throw new ArithmeticException("ln requires a positive number");
        return Math.log(a);
    }
    static double factorial(double a) {
        if (a < 0 || a != Math.floor(a))
            throw new ArithmeticException("Factorial requires a non-negative integer");
        long result = 1;
        for (int i = 2; i <= (int) a; i++) result *= i;
        return result;
    }
    static double abs(double a) { return Math.abs(a); }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============================");
        System.out.println("       Java Calculator       ");
        System.out.println("============================");

        while (true) {
            System.out.println("\n--- Basic ---");
            System.out.println("  1. Addition        (+)");
            System.out.println("  2. Subtraction     (-)");
            System.out.println("  3. Multiplication  (*)");
            System.out.println("  4. Division        (/)");
            System.out.println("  5. Modulo          (%)");
            System.out.println("  6. Power           (^)");
            System.out.println("  7. Square Root     (√)");
            System.out.println("\n--- Scientific ---");
            System.out.println("  8. Sine            sin(°)");
            System.out.println("  9. Cosine          cos(°)");
            System.out.println(" 10. Tangent         tan(°)");
            System.out.println(" 11. Log base 10     log10");
            System.out.println(" 12. Natural Log     ln");
            System.out.println(" 13. Factorial       n!");
            System.out.println(" 14. Absolute Value  |n|");
            System.out.println("\n  0. Exit");
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
                // One-operand operations
                if (choice == 7 || (choice >= 8 && choice <= 14)) {
                    System.out.print("Enter number: ");
                    double a = Double.parseDouble(scanner.nextLine().trim());
                    double result;
                    String label;
                    switch (choice) {
                        case  7: result = sqrt(a);      label = "√"       ; break;
                        case  8: result = sin(a);       label = "sin"     ; break;
                        case  9: result = cos(a);       label = "cos"     ; break;
                        case 10: result = tan(a);       label = "tan"     ; break;
                        case 11: result = log10(a);     label = "log10"   ; break;
                        case 12: result = ln(a);        label = "ln"      ; break;
                        case 13: result = factorial(a); label = "!"       ; break;
                        case 14: result = abs(a);       label = "abs"     ; break;
                        default: throw new IllegalStateException();
                    }
                    if (choice == 13)
                        System.out.printf("%.0f! = %.0f%n", a, result);
                    else
                        System.out.printf("%s(%.4f) = %.4f%n", label, a, result);

                // Two-operand operations
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
                    System.out.println("Invalid choice. Please select 0-14.");
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
