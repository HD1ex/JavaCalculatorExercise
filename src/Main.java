import calculator.Calculator;
import calculator.Operator;
import calculator.token.NumberToken;
import calculator.token.OperatorToken;
import calculator.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * This file belongs to the calculator project
 *
 * @author Alexander Sommer
 * @since 19.12.18
 */
public class Main {
    public static void main(String[] args) {
        /*
        // For testing the second task
        Scanner scanner = new Scanner(System.in);
        String expression;

        expression = "5.0 + (7.0 - 1.0) / 5.0 ^ 4";
        //expression = scanner.nextLine();

        Calculator calculator = new calculator(expression);

        System.out.println(calculator.calculate());
        */

        // For testing the first task
        Calculator calculator = new Calculator("");
        List<Token> tokens = Arrays.asList(
                new NumberToken(5), new NumberToken(3), new OperatorToken(Operator.ADDITION)
                , new NumberToken(2), new OperatorToken(Operator.SUBTRACTION)
        );
        System.out.printf("Result: %.1f\n", calculator.testRPN(tokens));

    }
}
