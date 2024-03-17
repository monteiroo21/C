import java.util.Scanner;
import java.util.Stack;

public class aula1_ex3_suffixCalculator_STACK {
    static Stack<Double> stack = new Stack<Double>();
    static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        while(input.hasNext()){ // This method may block while waiting for input to scan
            // Always a number appear, is pushed to the stack
            if(input.hasNextDouble()) {
                stack.push(input.nextDouble()); 
            } else { // Always a operator appears, the last two numbers are popped and result is pushed to the stack. If don't exist two numbers we have a sintax error.
                double n1, n2, result = 0.0;
                String op = input.next();
    
                n2 = stack.peek();
                stack.pop();
    
                n1 = stack.peek();
                stack.pop();
            
                switch(op) {
                    case "+": result = n1 + n2; break;
                    case "-": result = n1 - n2; break;
                    case "/": result = n1 / n2; break;
                    case "*": result = n1 * n2; break;
                    default:
                        System.err.printf("ERROR: invalid operator \"%s\"\n",op);
                        System.exit(1);                
                }
    
                stack.push(result);
            }
            System.out.print("Stack: " + stack);
            System.out.println();
        }

        
    }

}    

    
