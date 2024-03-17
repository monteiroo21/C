import java.util.Iterator;

@SuppressWarnings("CheckReturnValue")
public class Execute extends HelloBaseVisitor<String> {
   
   @Override public String visitMain(HelloParser.MainContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitGreetings(HelloParser.GreetingsContext ctx) {
      // String name = ctx.name().getText();
      String name = visit(ctx.name());
      System.out.println("Olá " + name);
      return name;
   }

   @Override public String visitBye(HelloParser.ByeContext ctx) {
      // String name = ctx.name().getText();
      String name = visit(ctx.name());
      System.out.println("Adeus " + name);
      return name;
   }

   @Override public String visitName(HelloParser.NameContext ctx) {
      String res = "";
      Iterator<HelloParser.WordContext> iterator = ctx.word().iterator();

      // System.out.println("oi v2");
      while(iterator.hasNext()) {
         // if(!res.isEmpty()) System.out.println("oi");

         res += visit(iterator.next()) + (res.isEmpty() ? "" : " ");
      }
      return res;


   }

   @Override public String visitWord(HelloParser.WordContext ctx) {
      return ctx.ID().getText();
      //return res;
   }
}
