import java.util.Iterator;

@SuppressWarnings("CheckReturnValue")
public class Execute extends CalculatorBaseVisitor<Integer> {

   @Override public Integer visitProgram(CalculatorParser.ProgramContext ctx) {
      // Iterator<?> iterator = ctx.word().iterator();
      Iterator<CalculatorParser.StatContext> iterator = ctx.stat().iterator();
      while(iterator.hasNext()) {
         System.out.println(visit(iterator.next()));
      }
      
      return 0;
   }


   @Override public Integer visitStat(CalculatorParser.StatContext ctx) {
      
      if(ctx.expr() != null) {
         return visit(ctx.expr()); 
      }
      
      return 0;

   }

   @Override public Integer visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      Integer result = null;
      Integer number1 = visit(ctx.expr(0));
      Integer number2 = visit(ctx.expr(1));
      String op = ctx.op.getText();
      System.out.printf("%f %s %f \n", number1,op,number2);

      if(number1 != null && number2 != null) {
         switch (op) {
            case "+": result = number1 + number2; break;
            case "-": result = number1 - number2; break;
            default:
               System.err.printf("ERROR: invalid operator \"%s\"\n",op);
               System.exit(1);        
         }
      }

      return result;
   }

   @Override public Integer visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      Integer result = null;
      Integer number1 = visit(ctx.expr(0));
      Integer number2 = visit(ctx.expr(1));
      String op = ctx.op.getText();
      System.out.printf("%f %s %f \n", number1,op,number2);

      if(number1 != null && number2 != null) {
         switch (op) {
            case "*": result = number1 * number2; break;
            case "/": 
               if(number2 != 0) {
                  result = number1 / number2; break;
               } else {
                  System.err.println("ERROR: can't divide by 0");
                  break;
               }
               
            case "%": 
               if(number2 != 0) {
                  result = number1 % number2; break;
               } else {
                  System.err.println("ERROR: can't divide by 0");
                  break;
               }
            default:
               System.err.printf("ERROR: invalid operator \"%s\"\n",op);
               System.exit(1);        
         }
      }

      return result;
   }


   @Override public Integer visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Integer.parseInt(ctx.Integer().getText());
   }

   
}
