package Aula02.b2_02;

import java.io.IOException;

import Aula02.b2_01.Execute;

import java.util.*;

public class SuffixCalculatorMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lineText = null;
        int numLine = 1;
        if (sc.hasNextLine())
            lineText = sc.nextLine();
        SuffixCalculatorParser parser = new SuffixCalculatorParser(null);

        Interpreter visitor0 = new Interpreter();
        while(lineText != null) {
            CharStream input = CharStreams.fromString(lineTest + "\n");

            SuffixCalculatorLexer lexer = new SuffixCalculatorLexer(input);
            lexer.setLine(numLine);
            lexer.setCharPositioninLine(0);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser.setInputStream(tokens);

            ParseTree tree = parser.program();
            if (parser.getNumberOfSyntaxErrors() == 0) {
                visitor0.visit(tree);
            }
        }
    }
    
}
