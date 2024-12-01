
import impl.GenericFunction;

import java.util.InputMismatchException;
import java.util.Scanner;

    public class ApplicationRunner {
        public static void main(String[] args) {

            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Enter 1 to reverse a string or 2 to calculate the factorial of a number:");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    System.out.println("Enter a string to reverse:");
                    String inputString = scanner.nextLine();

                    GenericFunction<String> reverseString = s -> new StringBuilder(s).reverse().toString();
                    System.out.println("Reversed string: " + reverseString.apply(inputString));

                } else if (choice == 2) {
                    System.out.println("Enter a number to calculate its factorial:");
                    int inputNumber = scanner.nextInt();

                    if (inputNumber < 0) {
                        throw new IllegalArgumentException("Number must not be negative.");
                    }

                    GenericFunction<Integer> factorial = n -> {
                        int result = 1;
                        for (int i = 1; i <= n; i++) {
                            result *= i;
                        }
                        return result;
                    };
                    System.out.println("Factorial of the number: " + factorial.apply(inputNumber));
                } else {
                    System.out.println("Invalid input. Please enter 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input error: Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());

            }
        }
    }


