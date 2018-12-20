package calculator.token;

import calculator.Operator;

/**
 * This file belongs to the calculator project
 *
 * @author Alexander Sommer
 * @since 19.12.18
 */
public class OperatorToken extends Token {
    //Members
    private Operator operator;

    /**
     * Constructs an OperatorToken using an {@link Operator}
     *
     * @param operator the {@link Operator} of this OperatorToken
     */
    public OperatorToken(Operator operator) {
        this.operator = operator;
    }

    /**
     * Gets the number of arguments an operator requires
     *
     * @return the number of arguments an operator requires
     */
    public int getNumArgs() {
        return 2;
    }

    @Override
    public String toString() {
        return operator.toString();
    }

    public Operator getOperator() {
        return operator;
    }
}
