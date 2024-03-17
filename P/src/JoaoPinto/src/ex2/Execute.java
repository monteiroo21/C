import java.util.Iterator;

@SuppressWarnings("CheckReturnValue")
public class Execute extends SuffixCalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(SuffixCalculatorParser.ProgramContext ctx) {
      // Iterator<?> iterator = ctx.word().iterator();
      Iterator<SuffixCalculatorParser.StatContext> iterator = ctx.stat().iterator();
      while(iterator.hasNext()) {
         System.out.println(visit(iterator.next()));
      }
      
      return 0.0;
   }

   @Override public Double visitStat(SuffixCalculatorParser.StatContext ctx) {
      
      if(ctx.expr() != null) {
         return visit(ctx.expr()); 
      }
      
      return 0.0;
      
   }

   @Override public Double visitExprSuffix(SuffixCalculatorParser.ExprSuffixContext ctx) {
      Double result = null;
      Double number1 = visit(ctx.expr(0));
      Double number2 = visit(ctx.expr(1));
      String op = ctx.op.getText();
      System.out.printf("%f %s %f \n", number1,op,number2);

      if(number1 != null && number2 != null) {
         switch (op) {
            case "+": result = number1 + number2; break;
            case "-": result = number1 - number2; break;
            case "/": result = number1 / number2; break;
            case "*": result = number1 * number2; break;
            default:
               System.err.printf("ERROR: invalid operator \"%s\"\n",op);
               System.exit(1);        
         }
      }

      return result;
   }

   
   @Override public Double visitExprNumber(SuffixCalculatorParser.ExprNumberContext ctx) {
      return Double.parseDouble(ctx.Number().getText());
   }

  


}
