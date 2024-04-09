import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

@SuppressWarnings("CheckReturnValue")
public class ExecuteV extends FractionsCalculatorBaseVisitor<Fraction> {

   private final Map<String, Fraction> symbolTable = new HashMap<>();

   @Override public Fraction visitProgram(FractionsCalculatorParser.ProgramContext ctx) {
      Fraction res = null;
      Iterator<FractionsCalculatorParser.StatContext>
      Iterator<FractionsCalculatorParser.StatContext> iterator = ctx.stat().iterator();
      while(iterator.hasNext()) {
         res = visit(iterator.next());
         if (res == null) break;
      }

      return res;
   }

   @Override public Fraction visitStat(FractionsCalculatorParser.StatContext ctx) {
      Fraction res = null;
      if (ctx.print() != null) {
         res = visit(ctx.print());
         if (res != null) System.out.println(res);
      } else if (ctx.assignment() != null) {
         res = visit(ctx.assignment());
      } else if (ctx.expr() != null) {
         res = visit(ctx.expr());
      }
      return res;
   }

   @Override public Fraction visitPrint(FractionsCalculatorParser.PrintContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Fraction visitAssignment(FractionsCalculatorParser.AssignmentContext ctx) {
      String id = ctx.ID().getText();
      Fraction res = visit(ctx.expr());
      
      if (res != null) {
         symbolTable.put(id,res);
      }

      return res;
   }

   @Override public Fraction visitExprAddSubMultDivMod(FractionsCalculatorParser.ExprAddSubMultDivModContext ctx) {
      Fraction res = null;
      Fraction f1 = visit(ctx.expr(0));
      Fraction f2 = visit(ctx.expr(1));

      if (f1 != null && f2 != null) {
         switch (ctx.op.getText()) {
            case "+":
               res = Fraction.sum(f1, f2);
               break;
            case "-":
               res = Fraction.minus(f1, f2);
               break;
            case "*":
               res = Fraction.multiplication(f1, f2);
               break;
            case ":":
               res = Fraction.division(f1, f2);
               if (!res.isValid()) {
                  res = null; // 0-division
                  System.err.println("Invalid division operation!");
               }
               break;   
         }
      }

      return res;
   }

   @Override public Fraction visitExprParent(FractionsCalculatorParser.ExprParentContext ctx) {
      Fraction res = visit(ctx.expr());

      if (res != null && ctx.signal != null && ctx.signal.getText().equals("-")) {
         res.invert();
      }

      return res;
   }

   @Override public Fraction visitExprExp(FractionsCalculatorParser.ExprExpContext ctx) {
      int numerator = Integer.parseInt(ctx.num().getText());
      Fraction res = visit(ctx.expr());

      if (res != null) {
         res = Fraction.exponential(res, numerator);
      }

      return res;
   }

   @Override public Fraction visitExprInteger(FractionsCalculatorParser.ExprIntegerContext ctx) {
      return new Fraction(Integer.parseInt(ctx.num().getText()), 1);
   }

   @Override public Fraction visitExprDiv(FractionsCalculatorParser.ExprDivContext ctx) {
      Fraction res = new Fraction(Integer.parseInt(ctx.num().getText()), Integer.parseInt(ctx.Integer().getText()));
      
      if (!res.isValid()) {
         res = null;
         System.err.println("Invalid attribution!");
      }

      return res;
   }

   @Override public Fraction visitExprID(FractionsCalculatorParser.ExprIDContext ctx) {
      String id = ctx.ID().getText();

      Fraction res = symbolTable.get(id);

      if (res != null && ctx.signal != null && ctx.signal.getText().equals("-")) {
         res.invert();
      }

      if (res == null) System.err.println("Invalid variable!");

      return res;
   }

   @Override public Fraction visitExprRead(FractionsCalculatorParser.ExprReadContext ctx) {
      Fraction res = null;

      System.out.print(ctx.Sentence() + ": ");

      Scanner sc = new Scanner(System.in);
      String line = sc.nextLine() + ";";

      CharStream input = CharStreams.fromString(line);
      FractionsCalculatorLexer lexer = new FractionsCalculatorLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      FractionsCalculatorParser parser = new FractionsCalculatorParser(tokens);

      ParseTree tree = parser.program();
      if (parser.getNumberOfSyntaxErrors() == 0) {
         ExecuteV visitor0 = new ExecuteV();
         res = visitor0.visit(tree);
      }
      
      return res;
   }

   @Override public Fraction visitExprReduce(FractionsCalculatorParser.ExprReduceContext ctx) {
      Fraction res = visit(ctx.expr());

      if (res != null) {
         res = res.reduce();
      }

      return res;
   }
}
