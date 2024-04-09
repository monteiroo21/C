import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
@SuppressWarnings("CheckReturnValue")

public class ExecuteL extends StoreNumbersBaseListener {

   @Override public void exitLine(StoreNumbersParser.LineContext ctx) {
      Main.numbers_map.put(ctx.Name().getText(), Integer.parseInt(ctx.Number().getText()));
   }

}
