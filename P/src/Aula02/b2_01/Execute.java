@SuppressWarnings("CheckReturnValue")
public class Execute extends HelloBaseVisitor<String> {

   @Override public String visitMain(HelloParser.MainContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitGreetings(HelloParser.GreetingsContext ctx) {
      System.out.print("Hello,");
      for (TerminalNode name : ctx.ID()) {
         System.out.print(" " + name.getText());
      }
      System.out.println();
      return null;
   }

   @Override public String visitBye(HelloParser.ByeContext ctx) {
      System.out.print("Bye,");
      for (TerminalNode name : ctx.ID()) {
         System.out.print(" " + name.getText());
      }
      System.out.println();
      return null;
   }

   @Override public String visitName(HelloParser.NameContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitWords(HelloParser.WordsContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }
}
