import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class numbersMain {
   public static void main(String[] args) throws Exception {
      InputStream in_stream = null;
      try{ 
         in_stream = new FileInputStream(new File("numbers.txt")); 
      }
      catch(FileNotFoundException e){ 
         err.println("ERROR: reading number file!"); exit(1); 
      }
      // create a CharStream that reads from in_stream:
      ANTLRInputStream input = new ANTLRInputStream(in_stream);
      // create a lexer that feeds off of input CharStream:
      NumbersLexer lexer = new NumbersLexer(input);
      // create a buffer of tokens pulled from the lexer:
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      // create a parser that feeds off the tokens buffer:
      NumbersParser parser = new NumbersParser(tokens);
      // begin parsing at file rule:
      ParseTree tree = parser.file();
      if(parser.getNumberOfSyntaxErrors() == 0) {
         // print LISP-style tree:
         // System.out.println(tree.toStringTree(parser));
         // listeners:
         ParseTreeWalker walker = new ParseTreeWalker();
         ConstructNumberMappings mappings = new ConstructNumberMappings();


         walker.walk(mappings,tree);
         Scanner in = new Scanner(System.in);
         while(in.hasNextLine()) {
            String line = in.nextLine();
            String[] words = line.replace('-',' ').toLowerCase().split(" ");
            for(int i = 0;i < words.length;i++) {
               if(i != 0) out.print(" ");
               if(mappings.exists(words[i])) out.print(mappings.value(words[i]).toString());
               else out.print(words[i]);
            }
            out.println();
         }
      }
   }
}
