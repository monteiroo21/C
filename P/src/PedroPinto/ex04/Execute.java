import java.util.Iterator;

@SuppressWarnings("CheckReturnValue")
public class Execute extends PrefixCalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(PrefixCalculatorParser.ProgramContext ctx) {
      Double res = null;
      Iterator<PrefixCalculatorParser.StatContext> iterator = ctx.stat().iterator();
      while(iterator.hasNext()) {
         res = visit(iterator.next());
         if (res != null) System.out.println("Result: "+res);
      }

      return res;
   }

   @Override public Double visitStat(PrefixCalculatorParser.StatContext ctx) {
      if (ctx.expr() != null){
         return visit(ctx.expr());
      }
      return null;
   }

   @Override public Double visitExprPrefix(PrefixCalculatorParser.ExprPrefixContext ctx) {
      Double res = null;
      Double e1 = visit(ctx.expr(0));
      Double e2 = visit(ctx.expr(1));
      if (e1 != null && e2 != null) {
         String op = ctx.op.getText();
         switch(op) {
         case "*":
            res = e1 * e2;
            break;
         case "/":
            if (e2 != 0) res = e1 / e2;
            break;
         case "+":
            res = e1 + e2;
            break;
         case "-":
            res = e1 - e2;
            break;
         }      
      }
      
      return res;
      
   }

   @Override public Double visitExprNumber(PrefixCalculatorParser.ExprNumberContext ctx) {
      return Double.parseDouble(ctx.Number().getText());
   }
}
