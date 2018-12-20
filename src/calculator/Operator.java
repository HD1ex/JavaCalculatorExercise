package calculator;

/**
 * This file belongs to the calculator project
 *
 * @author Alexander Sommer
 * @since 19.12.18
 */

// TODO 1: Implement compute methods
// TODO 2: Alter Associativities

public enum Operator {
    ADDITION(Associativity.None, "+") {
        @Override
        public double compute(double left, double right) {
            return 0;
        }
    }, SUBTRACTION(Associativity.None, "-") {
        @Override
        public double compute(double left, double right) {
            return 0;
        }
    }, MULTIPLICATION(Associativity.None, "*") {
        @Override
        public double compute(double left, double right) {
            return 0;
        }
    }, DIVISION(Associativity.None, "/") {
        @Override
        public double compute(double left, double right) {
            return 0;
        }
    }, EXPONENTIATION(Associativity.None, "^") {
        @Override
        public double compute(double left, double right) {
            return 0;
        }
    };

    // Members
    private int precedence;
    private Associativity associativity;
    private String representation;

    /**
     * Constructs an Operator and using the precedence specified by the order above
     */
    Operator(Associativity associativity, String representation) {
        this.precedence = this.ordinal();
        this.associativity = associativity;
        this.representation = representation;
    }

    /**
     * Computes the result based on this operator and the given operands
     * If # is this operator for example then 'left # right' is computed
     *
     * @param left  is the left operand
     * @param right is the right operand
     * @return the result of the computation
     */
    public abstract double compute(double left, double right);

    /**
     * Gets the precedence for this operator
     *
     * @return the precedence for this operator
     */
    public int getPrecedence() {
        return precedence;
    }

    /**
     * Gets the operators associativity
     *
     * @return the operators associativity
     */
    public Associativity getAssociativity() {
        return associativity;
    }

    @Override
    public String toString() {
        return representation;
    }}


