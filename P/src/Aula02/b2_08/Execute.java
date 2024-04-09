import java.util.Iterator;

@SuppressWarnings("CheckReturnValue")
public class Execute extends CalculatorBaseVisitor<String> {

   @Override public String visitProgram(CalculatorParser.ProgramContext ctx) {
      Iterator<CalculatorParser.StatContext> iter = ctx.stat().iterator();
      while (iter.hasNext()) {
         System.out.println(visit(iter.next()));
      }

      return null;
   }

   @Override public String visitStatEmpty(CalculatorParser.StatEmptyContext ctx) {
      return null;
   }

   @Override public String visitStatExpr(CalculatorParser.StatExprContext ctx) {
      return visit(ctx.expr());
   }

   @Override public String visitStatAssignment(CalculatorParser.StatAssignmentContext ctx) {
      return visit(ctx.assignment());
   }

   @Override public String visitAssignment(CalculatorParser.AssignmentContext ctx) {
      return ctx.ID().getText() + " " + visit(ctx.expr()) + " = ";
   }

   @Override public String visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      return visit(ctx.expr(0)) + " " + visit(ctx.expr(1)) + " " + ctx.op.getText();
   }

   @Override public String visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public String visitExprUnary(CalculatorParser.ExprUnaryContext ctx) {
      return visit(ctx.expr()) + " !";
   }

   @Override public String visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return ctx.Integer().getText();
   }

   @Override public String visitExprID(CalculatorParser.ExprIDContext ctx) {
      return ctx.ID().getText();
   }

   @Override public String visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      return visit(ctx.expr(0)) + " " + visit(ctx.expr(1)) + " " + ctx.op.getText();
   }
}