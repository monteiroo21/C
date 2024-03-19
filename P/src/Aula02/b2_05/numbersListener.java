// Generated from numbers.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link numbersParser}.
 */
public interface numbersListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link numbersParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(numbersParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link numbersParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(numbersParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link numbersParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(numbersParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link numbersParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(numbersParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link numbersParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(numbersParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link numbersParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(numbersParser.ExprContext ctx);
}