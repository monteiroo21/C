import java.util.Iterator;

@SuppressWarnings("CheckReturnValue")
public class Execute extends PrefixCalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(PrefixCalculatorParser.ProgramContext ctx) {
      Double res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Double visitStat(PrefixCalculatorParser.StatContext ctx) {
      Double res = 0.0;

      if(ctx.expr() == null){
         return null;
      }
      res = visit(ctx.expr());

      if(res == null){
         System.out.println("Expressão inválida");
         
      }else{
         System.out.println(res);
      }
      
      return res;
   }

   @Override public Double visitExprPrefix(PrefixCalculatorParser.ExprPrefixContext ctx) {
      Double result = null;
      Double number1 = visit(ctx.expr(0));
      Double number2 = visit(ctx.expr(1));
      String op = ctx.op.getText();

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

   @Override public Double visitExprNumber(PrefixCalculatorParser.ExprNumberContext ctx) {
      return Double.parseDouble(ctx.Number().getText());
   }
}
