package calculator;

import calculator.token.ClosingParenthesisToken;
import calculator.token.FuncArgSeparatorToken;
import calculator.token.NumberToken;
import calculator.token.OpeningParenthesisToken;
import calculator.token.OperatorToken;
import calculator.token.SyntaxToken;
import calculator.token.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This file belongs to the calculator project
 *
 * @author Alexander Sommer
 * @since 19.12.18
 */
public class Calculator {
    private String expression;
    private List<Token> tokens;

    public Calculator(String expression) {
        this.expression = expression;
        if (expression.isEmpty()) {
            return;
        }
        parseExpression();
        printTokens("Infix  : "); // Be verbose
        doShuntingYard();
        printTokens("Postfix: "); // Be verbose
    }

    private void parseExpression() {
        // Create the resulting list
        tokens = new ArrayList<>(expression.length());
        // Remove all whitespaces from the expression
        String expression = this.expression.replace(" ", "");

        // Group all syntax tokens for easy iteration
        SyntaxToken[] syntaxTokens = {new OpeningParenthesisToken(), new ClosingParenthesisToken(), new FuncArgSeparatorToken()};

        // Create string-buffers for multi-character tokens
        StringBuilder number = new StringBuilder();
        StringBuilder token = new StringBuilder();

        // Iterate over every character
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                // If the character belongs to a number, then buffer it
                number.append(c);
            } else {
                // If the character belongs to something else, then buffer it
                token.append(c);
                // but first check if a number has been buffered
                if (number.length() > 0) {
                    // and add it to the output
                    tokens.add(new NumberToken(Double.parseDouble(number.toString())));
                    // and clear the number buffer
                    number.setLength(0);
                }

                // Check if the buffered token is an Operator
                for (Operator operator : Operator.values()) {
                    if (token.toString().equals(String.valueOf(operator))) {
                        tokens.add(new OperatorToken(operator));
                        token.setLength(0);
                        break;
                    }
                }

                // or if it's a syntax element '( or ) or ,'
                for (SyntaxToken syntaxToken : syntaxTokens) {
                    if (token.toString().equals(String.valueOf(syntaxToken))) {
                        tokens.add(syntaxToken);
                        token.setLength(0);
                        break;
                    }
                }
            }
        }
        // Ensure, that nothing is still buffered
        if (number.length() > 0) {
            tokens.add(new NumberToken(Double.parseDouble(number.toString())));
        }
    }

    private void printTokens(String text) {
        System.out.print(text);
        StringBuilder output = new StringBuilder(tokens.size());
        for (Token token : tokens) {
            output.append(token + " ");
        }
        System.out.println(output.substring(0, output.length() - 1));
    }

    private void doShuntingYard() {
        // TODO 2: Add Shunting yard algorithm, to convert the 'this.tokens' from infix to postfix aka reverse polish notation
        // https://en.wikipedia.org/wiki/Shunting-yard_algorithm
        // -- add code here --
    }

    public double calculate() {
        // TODO 1: Calculate the result based on the 'this.tokens' List, which should be in reverse polish notation
        // Declare a stack for storing the operands (numbers)
        Stack<Double> operandStack = new Stack<>(); // The stack has three important methods: push, pop, peek
        // Iterate over each token in the token-list
        // -- add code here --
        // Return the result
        return 0; // <-- alter the return value
    }

    // A function to test the calculate functionality
    public double testRPN(List<Token> tokens) {
        this.tokens = tokens;
        printTokens("Postfix: "); // Be verbose
        return calculate();
    }
}
