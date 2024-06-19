package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // variable declaration
        char op; // choice of operation
        int num1, num2;
        int ans = 0;

        System.out.println("          CHOOSE AN OPERATION          ");
        System.out.println("=======================================");
        System.out.println("[a] Addition");
        System.out.println("[b] Subtraction");
        System.out.println("[c] Multiplication");
        System.out.println("[d] Division");
        System.out.println("=======================================");

        Scanner sc = new Scanner(System.in);

        System.out.print("Operation: ");
        op = sc.next().charAt(0);
        System.out.println("=======================================");

        System.out.print("Enter first number: ");
        num1 = sc.nextInt();
        System.out.println("----------------------------------------");

        System.out.print("Enter second number: ");
        num2 = sc.nextInt();
        System.out.println("=========================================");

        switch (op) {
            case 'a':
                ans = addMe(num1,num2);
                break;
            case 'b':
                ans = subtractMe(num1,num2);
                break;
            case 'c':
                ans = multiplyMe(num1,num2);
                break;
            case 'd':
                ans = divideMe(num1);
                break;
            default:
                System.out.println("Invalid input. Please try again.");
        }

        System.out.println("Answer = " + ans);
    }

    public static int addMe(int num1, int num2) {
        int ans;
        ans = num1 + num2;
        return ans;
    }

    public static int subtractMe(int num1, int num2) {
        int ans;
        ans = num1 - num2;
        return ans;
    }

    public static int multiplyMe(int num1, int num2) {
        int ans;
        ans = num1 * num2;
        return ans;
    }

    public static int divideMe(int num1) {
        int ans, num2;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter second number: ");
        num2 = sc.nextInt();
        System.out.println("=========================================");

        if (num2 == 0)
            System.out.println("Undefined. Please enter another number");

        ans = num1 / num2;
        return ans;
    }
}