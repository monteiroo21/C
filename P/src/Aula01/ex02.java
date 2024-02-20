package Aula01;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class ex02 {
    static final Scanner input = new Scanner(System.in);
    private static Map<String, Double> vars = new HashMap<String, Double>();
    public static void main(String[] args) {
        while (input.hasNextLine()) {
            Scanner sc = new Scanner(input.nextLine());
            if (sc.hasNext()) {
                System.out.println("result = " + processLine(sc));
            }
            sc.close();
        }
    }

    public static boolean isNumber(String token) {
        Scanner sc = new Scanner(token);
        boolean res = sc.hasNextDouble();
        sc.close();
        return res;
    }

    public static boolean isVar(String token) {
        boolean res = token.length() > 0 && Character.isLetter(token.charAt(0));
        for (int i = 1; res && i < token.length(); i++) {
            res = Character.isLetterOrDigit(token.charAt(i));
        }
        return res;
    }

    public static double processLine(Scanner sc) {
        double res = 0;
        String inp = null;
        double num = 0;

        inp = sc.next();

        if (isVar(inp)) {
            if (vars.containsKey(inp)) {
                num = vars.get(inp);
            }
        } else if (isNumber(inp)) {
            num = Double.parseDouble(inp);
        } else {
            System.err.println("ERROR\n");
            System.exit(1);
        }

        if (sc.hasNext()) {
            String op;
            op = sc.next();
            if (op.equals("=")) {
                if (!isVar(inp)) {
                    System.err.printf("ERROR\n");
                    System.exit(1);
                }
                res = processLine(sc);
                vars.put(inp, res);
            } else {
                double n2 = processLine(sc);
                switch(op) {
                    case "+": res = num + n2; break;
                    case "-": res = num - n2; break;
                    case "/": res = num / n2; break;
                    case "*": res = num * n2; break;
                    default:
                        System.err.println("ERROR\n");
                        System.exit(1);
                }
            }
        } else {
            res = num;
        }

        return res;
    }
}
