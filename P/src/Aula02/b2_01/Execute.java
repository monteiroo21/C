package Aula02.b2_01;

import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings("CheckReturnValue")
public class Execute extends HelloBaseVisitor<String> {

   @Override
   public String visitGreeting(HelloParser.GreetingsContext ctx) {
      System.out.print("Hello,");
      for (TerminalNode name : ctx.ID()) {
         System.out.print(" " + name.getText());
      }
      System.out.println("!");      
      return null;
   }

   @Override
   public String visitBye(HelloParser.ByeContext ctx) {
      System.out.print("Goodbye,");
      for (TerminalNode name : ctx.ID()) {
         System.out.print(" " + name.getText());
      }
      System.out.println("!");  
      return null;
   }   

}