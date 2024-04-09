import java.util.Iterator;

@SuppressWarnings("CheckReturnValue")
public class Execute extends ConvertToSuffixBaseVisitor<String> {
   
   @Override public String visitProgram(ConvertToSuffixParser.ProgramContext ctx) {
      String res = "";
      Iterator<ConvertToSuffixParser.StatContext> iter = ctx.stat().iterator();
      while(iter.hasNext()){
         res += visit(iter.next());
      }
      return res;
   }

   @Override public String visitStat(ConvertToSuffixParser.StatContext ctx) {
      String res = null;
      if (ctx.expr() != null) {
         res = visit(ctx.expr());
      } else if (ctx.assignment() != null) {
         res = visit(ctx.assignment());
      }
      return res;
   }

   @Override public String visitAssignment(ConvertToSuffixParser.AssignmentContext ctx) {
      
      String res = null;
      
      String id = ctx.ID().getText();

      String expr = visit(ctx.expr());

      if (id != null && expr != null) {
         res = id + " = " + expr;
      }

      return res;
   }

   @Override public String visitExprAddSubMultDivMod(ConvertToSuffixParser.ExprAddSubMultDivModContext ctx) {
      String res = null;
      String e1 = visit(ctx.expr(0));
      String e2 = visit(ctx.expr(1));
      String op = ctx.op.getText();

      if (e1 != null && e2 != null && op != null) {
         res = e1 + " " + e2 + " " + op;
      }

      return res;
   }

   @Override public String visitExprParent(ConvertToSuffixParser.ExprParentContext ctx) {
      String res = visit(ctx.expr());

      if (res != null && ctx.signal != null) {
         res =  res + " !" + ctx.signal.getText();
      }

      return res;
   }

   @Override public String visitExprInteger(ConvertToSuffixParser.ExprIntegerContext ctx) {
      String res = ctx.Integer().getText();

      if (ctx.signal != null) {
         res =  res + " !" + ctx.signal.getText();
      }

      return res;
   }

   @Override public String visitExprID(ConvertToSuffixParser.ExprIDContext ctx) {
      String res = ctx.ID().getText();

      if (ctx.signal != null) {
         res =  res + " !" + ctx.signal.getText();
      }

      return res;
   }
}
