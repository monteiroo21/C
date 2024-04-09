 import java.util.Iterator;

@SuppressWarnings("CheckReturnValue")
public class Execute extends HelloBaseVisitor<String> {

   @Override public String visitGreetings(HelloParser.GreetingsContext ctx) {
      String name = visit(ctx.name());
      System.out.println("Olá"+name);
      return null;
   }
	
   @Override public String visitHi(HelloParser.HiContext ctx) {
      String name = visit(ctx.name());
      System.out.println("Olá"+name);
      return null;
   }

   @Override public String visitBye(HelloParser.ByeContext ctx) {
      String name = visit(ctx.name());
      System.out.println("Adeus"+name);
      return null;
   }

   @Override public String visitName(HelloParser.NameContext ctx) {
      String res = " ";
      // Iterator<?> iterator = ctx.word().iterator();   
      Iterator<HelloParser.WordContext> iterator = ctx.word().iterator();
      while(iterator.hasNext()) {
         res += visit(iterator.next())+(res.isEmpty() ? "" : " ");
      }
      
      return res;
   }

   @Override public String visitWord(HelloParser.WordContext ctx) {
      return ctx.ID().getText();
   }
}

