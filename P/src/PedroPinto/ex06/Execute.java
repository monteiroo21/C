import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SuppressWarnings("CheckReturnValue")
public class Execute extends CalculatorBaseVisitor<Long> {

    private final Map<String, Long> symbolTable = new HashMap<>();

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
        Long res = null;
        if (ctx.expr() != null) {
            res = visit(ctx.expr());
        } else if (ctx.assignment() != null) {
            res = visit(ctx.assignment());
        }
        return res;
    }

    @Override public Long visitAssignment(CalculatorParser.AssignmentContext ctx) {
        String id = ctx.ID().getText();

        Long res = visit(ctx.expr());

        if (res != null) {
            symbolTable.put(id,res);
        }

        return res;
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

    @Override public Long visitExprID(CalculatorParser.ExprIDContext ctx) {
        String id = ctx.ID().getText();

        Long value = symbolTable.get(id);

        if (value != null && ctx.signal != null) {
            value = getExprSignal(value, ctx.signal.getText());
        }

        return value;
    }

    @Override public Long visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
        Long res = Long.parseLong(ctx.Integer().getText());

        if (ctx.signal != null) {
            res = getExprSignal(res, ctx.signal.getText());
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

    private Long getExprSignal(Long res, String signal) {
        if (signal.equals("-")) {
            res = -res;
        }
        return res;
    }

}
