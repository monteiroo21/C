import java.util.Iterator;

import .antlr.CalculatorParser;

@SuppressWarnings("CheckReturnValue")
public class Execute extends CalculatorBaseVisitor<Long> {

    @Override public Long visitProgram(CalculatorParser.ProgramContext ctx) {
        // Iterator<?> iterator = ctx.word().iterator();   
        Long res = null;
        Iterator<CalculatorParser.StatContext> iterator = ctx.stat().iterator();
        while(iterator.hasNext()) {
        res = visit(iterator.next());
        if (res != null) System.out.println("Result: "+res);
        }

        return null;
    }

    @Override public Long visitStat(CalculatorParser.StatContext ctx) {
        if (ctx.expr() != null){
            return visit(ctx.expr());
        }
        return null;
    }


    @Override public Long visitExprAddSubMultDivMod(CalculatorParser.ExprAddSubMultDivModContext ctx) {
        Long res = null;
        Long e1 = visit(ctx.expr(0));
        Long e2 = visit(ctx.expr(1));
        if (e1 != null && e2 != null) {
            String op = ctx.op.getText();
            switch(op) {
            case "+":
                res = e1 + e2;
                break; 
            case "-":
                res = e1 - e2;
                break;
            case "*":
                res = e1 * e2;
                break; 
            case "/":
                if (e2 != 0) res = e1 / e2;
                break;
            case "%":
                res = e1 % e2;
                break;
            }
        }
        return res;
    }

    @Override public Long visitExprParent(CalculatorParser.ExprParentContext ctx) {
        Long res = visit(ctx.expr());

        if (res != null && ctx.signal != null) {
            res = getExprSignal(res, ctx.signal.getText());
        }

        return res;
    }


    @Override public Long visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
        Long res = Long.parseLong(ctx.Integer().getText());

        if (ctx.signal != null) {
            res = getExprSignal(res, ctx.signal.getText());
        }

        return res;
    }

    private Long getExprSignal(Long res, String signal) {
        if (signal.equals("-")) {
            res = -res;
        }
        return res;
    }

}
