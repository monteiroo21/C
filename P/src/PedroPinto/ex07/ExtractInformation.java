import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
@SuppressWarnings("CheckReturnValue")

public class ExtractInformation extends Java8ParserBaseListener {

   @Override public void exitNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
      System.out.println("class "+ctx.Identifier().getText());
   }

   @Override public void exitMethodDeclarator(Java8Parser.MethodDeclaratorContext ctx) {
      System.out.println("method "+ctx.Identifier().getText());
   }

}
