package calculator.token;

/**
 * This file belongs to the calculator project
 *
 * @author Alexander Sommer
 * @since 19.12.18
 */
public class NumberToken extends Token {
    // Members
    private double number; // The numeric value

    /**
     * Constructs a NumberToken using a number
     *
     * @param number Its numeric value
     */
    public NumberToken(double number) {
        this.number = number;
    }

    /**
     * Gets the numeric value of this Token
     *
     * @return the numeric value of this Token
     */
    public double getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
