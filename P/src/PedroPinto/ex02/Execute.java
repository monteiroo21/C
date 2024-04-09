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
      if (ctx.expr() != null) {
        return visit(ctx.expr());
      }
      
      return 0.0;
   }

   @Override public Double visitExprSuffix(SuffixCalculatorParser.ExprSuffixContext ctx) {
      Double res = null;
      Double e1 = visit(ctx.expr(0));
      Double e2 = visit(ctx.expr(1));
      String op = ctx.op.getText();
      switch(op) {
        case "*":
          res = e1 * e2;
          break;
        case "/":
          res = e1 / e2;
          break;
        case "+":
          res = e1 + e2;
          break;
        case "-":
          res = e1 - e2;
          break;
      }      
      return res;
      
   }


   @Override public Double visitExprNumber(SuffixCalculatorParser.ExprNumberContext ctx) {
      return Double.parseDouble(ctx.Number().getText());
   }

}
