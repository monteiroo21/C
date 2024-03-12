package Aula02.b2_03;

public class Interpreter extends CalculatorBaseVisitor<Long> {
    @Override public Long visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
        Long res = null;

        Long e1 = visit(ctx.expr(0));

        Long e2 = visit(ctx.expr(1));
  
        String op = ctx.op.getText();

        if (e1 != null && e2 != null) {
            switch(op) {
                case "-":
                    res = e1-e2;
                    break;
                case "+":
                    res = e1+e2;
                    break;
                default:
                    System.out.println("Wrong operator!");
                    break;
            }

        }

        return res;
    }

    @Override public Long visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
        Long res = null;
  
        Long e1 = visit(ctx.expr(0));
        
        Long e2 = visit(ctx.expr(1));
  
        String op = ctx.op.getText();
  
        switch (op) {
           case "*":
              res = e1 * e2;
              break;
           case "/":
              res = e1 / e2;
              break;
           case "%":
              res = e1 % e2;
              break;
           default:
              System.out.println("Operador inválido");
        }
  
        return res;
     }

    @Override public Long visitExprParent(CalculatorParser.ExprParentContext ctx) {
        return visit(ctx.expr());
    }

    @Override public Long visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
        return Long.parseLong(ctx.Integer().getText());
    }
    
}
