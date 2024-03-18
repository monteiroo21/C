@SuppressWarnings("CheckReturnValue")
public class Execute extends CalculatorBaseVisitor<Long> {

   @Override public Long visitProgram(CalculatorParser.ProgramContext ctx) {
      Long res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Long visitStat(CalculatorParser.StatContext ctx) {
      Long res = null;

      if (ctx.expr() == null) {
         return null;
      }
      res = visit(ctx.expr());
      System.out.println(res);
      //return visitChildren(ctx);
      return res;
   }

   @Override public Long visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      Long res = null;
      Long a = visit(ctx.expr(0));
      Long b = visit(ctx.expr(1));
      String op = ctx.op.getText();

      switch (op) {
         case "+":
            res = a+b;
            break;
         case "-":
            res = a-b;
            break;
         default:
            System.out.println("Invalid operand");
            break;
      }
      return res;
   }

   @Override public Long visitExprParent(CalculatorParser.ExprParentContext ctx) {
      Long res = null;
      
      res = visit(ctx.expr());

      return res;
   }

   @Override public Long visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      // Long res = null;
      return Long.parseLong(ctx.Integer().getText());
      //return res;
   }

   @Override public Long visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      Long res = null;
      Long a = visit(ctx.expr(0));
      Long b = visit(ctx.expr(1));
      String op = ctx.op.getText();

      switch (op) {
         case "*":
            res = a*b;
            break;
         case "/":
            res = a/b;
            break;
         case "%":
            res = a%b;
            break;
         default:
            System.out.println("Invalid operand");
            break;
      }
      return res;
   }
}
