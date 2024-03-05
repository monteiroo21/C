package b2_01;

import java.util.Iterator;

@SuppressWarnings("CheckReturnValue")
public class Execute extends HelloBaseVisitor<String> {
    
    @Override public String visitGreetings(HelloParser.GreetingsContext ctx) {
        System.out.println("Hello World");
        return "null";
    }

    @Override public String visitBye(HelloParser.ByeContext ctx) {
        String res = null;
        return visitChildren(ctx);
    }

    @Override public String visitName(HelloParser.NameContext ctx) {
        String res = "";
        Iterator<HelloParser.WordContext> iterator = ctx.word().iterator();
        while(iterator.hasNext()) {
            res += (res.isEmpty() ? "" : " ") + visit(iterator.next());
        }
        return res;
    }

    @Override public String visitWord(HelloParser.WordContext ctx) {
        return ctx.ID().getText();
    }
}