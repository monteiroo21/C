/**
 * @ Author: Pedro Pinto (pmap@ua.pt)
 * @ Create Time: 2024-02-26
 */

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    
    static final Scanner input = new Scanner(System.in);
    public static final Map<String,Integer> numbers_map = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {

        fillMap("numbers.txt");

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            String parts[] = line.replace("-"," ").split(" ");

            int accumulated = 0;
            int result = 0;

            for (String str : parts) {

                Integer currInteger = numbers_map.get(str);

                if (currInteger == null) continue;

                if (currInteger > accumulated) {
                    if (accumulated == 0) {
                        accumulated = currInteger;
                    } else {
                        accumulated *= currInteger;
                    }
                } else {
                    result += accumulated;
                    accumulated = currInteger;
                }

            }
            result += accumulated;

            System.out.println(line + "-> " + result);
        }
    }

    private static void fillMap(String filename) throws FileNotFoundException {
        try {
            // create a CharStream that reads from standard input:
            CharStream input = CharStreams.fromStream(new FileInputStream(filename));
            // create a lexer that feeds off of input CharStream:
            StoreNumbersLexer lexer = new StoreNumbersLexer(input);
            // create a buffer of tokens pulled from the lexer:
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            // create a parser that feeds off the tokens buffer:
            StoreNumbersParser parser = new StoreNumbersParser(tokens);
            // replace error listener:
            //parser.removeErrorListeners(); // remove ConsoleErrorListener
            //parser.addErrorListener(new ErrorHandlingListener());
            // begin parsing at program rule:
            ParseTree tree = parser.program();
            if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            ParseTreeWalker walker = new ParseTreeWalker();
            ExecuteL listener0 = new ExecuteL();
            walker.walk(listener0, tree);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        catch(RecognitionException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
