package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char repeat = 'Y';

        do {
            char op; // choice of operation
            int num1 = 0, num2 = 0; // numbers for the operation
            int ans = 0; // result of operations a-c
            double divAns = 0; // result of operation d

            // operation selection
            System.out.println("=======================================");
            System.out.println("          CHOOSE AN OPERATION          ");
            System.out.println("=======================================");
            System.out.println("[a] Addition");
            System.out.println("[b] Subtraction");
            System.out.println("[c] Multiplication");
            System.out.println("[d] Division");
            System.out.println("=======================================");

            // loop until a valid operation is chosen
            while (true) {
                System.out.print("Operation: ");
                op = Character.toUpperCase(sc.next().charAt(0)); // convert to upper case for uniformity
                if (op == 'A' || op == 'B' || op == 'C' || op == 'D') {
                    break;
                }
                else {
                    System.out.println("Invalid operation. Please choose again.");
                }
            }

            // input first number
            System.out.println("----------------------------------------");
            System.out.print("Enter first number: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.next(); // clear invalid input
                System.out.print("Enter first number: ");
            }
            num1 = sc.nextInt(); // read the first number

            // input second number
            System.out.println("----------------------------------------");
            System.out.print("Enter second number: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.next(); // clear invalid input
                System.out.print("Enter second number: ");
            }
            num2 = sc.nextInt(); // read the second number

            switch (op) {
                case 'A': // Addition
                    ans = addMe(num1, num2);
                    break;
                case 'B': // Subtraction
                    ans = subtractMe(num1, num2);
                    break;
                case 'C': // Multiplication
                    ans = multiplyMe(num1, num2);
                    break;
                case 'D': // Division
                    if (num2 == 0) {
                        // handle division by zero
                        System.out.println("Error: Division by zero is not allowed.");
                        continue; // skip the rest of the loop and go back to the start
                    }
                    divAns = divideMe(num1, num2); // double answer
                    break;
            }

            // Display the result of the operation
            System.out.println("=======================================");
            if (op == 'D') {
                System.out.println("Answer = " + divAns); // print only divAns if division operation is selected
            }
            else {
                System.out.println("Answer = " + ans); // print ans for the rest
            }

            // ask the user if they want to try again
            System.out.print("Do you want to try again? (y/n): ");
            repeat = Character.toUpperCase(sc.next().charAt(0)); // convert to upper case for uniformity
        } while (repeat == 'Y');

        sc.close();
    }

    public static int addMe(int num1, int num2) {
        return num1 + num2;
    }

    public static int subtractMe(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiplyMe(int num1, int num2) {
        return num1 * num2;
    }

    public static double divideMe(int num1, int num2) {
        return (double) num1 / num2; // perform division as double
    }
}
