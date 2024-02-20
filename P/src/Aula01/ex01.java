package Aula01;

import java.util.Scanner;

public class ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ans = scanner.nextLine();
        String[] parts = ans.split(" ");
        double num1 = Double.parseDouble(parts[0]);
        String op = parts[1];
        double num2 = Double.parseDouble(parts[2]);
        double result = 0;
        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.err.println("You can't divide by 0!");
                    System.exit(1);
                    break;
                }
                result = num1 / num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            default:
                System.err.println("Invalid operator!");
                System.exit(1);
                break;
        }
        System.out.println(result);
        scanner.close();
    }
}
