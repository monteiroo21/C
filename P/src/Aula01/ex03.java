package Aula01;

import java.util.Stack;
import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Double> stack = new Stack<Double>();
        double num;
        String var;
        double n1, n2;
        double res = 0;

        Scanner sc = new Scanner(scanner.nextLine()); 

        while (sc.hasNext()) {
            if (sc.hasNextDouble()) {
                num = sc.nextDouble();
                stack.push(num);
            } else {
                var = sc.next();
                if (stack.size() >= 2) {
                    n2 = stack.pop();
                    n1 = stack.pop();
                    switch(var) {
                        case "+": res = n1 + n2; break;
                        case "-": res = n1 - n2; break;
                        case "/": res = n1 / n2; break;
                        case "*": res = n1 * n2; break;
                        default:
                            System.err.println("ERROR: Wrong operator!");
                            System.exit(1);
                    }
                    stack.push(res);
                } else {
                    System.err.println("ERROR: Not enough arguments!");
                    System.exit(1);
                }
            }
        }

        if (stack.size() != 1) {
            System.err.println("ERROR: Not all arguments were processed!");
            System.exit(1);
        }

        res = stack.pop();
        scanner.close();
        sc.close();
        System.out.println("Result = " + res);
    }
}
