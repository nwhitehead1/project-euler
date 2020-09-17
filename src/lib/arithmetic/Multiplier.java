package lib.arithmetic;

public class Multiplier extends Adder {

    public Multiplier() {
        super();
    }

    public Multiplier(String first, String second) {
        super(first, second);
    }

    @Override
    public String operation(String a, String b) {
        return multiply(a, b);
    }

    /**
     * Multiplying a number by another number is equivalent to adding a to a, b times.
     *
     * @param a first
     * @param b second
     * @return Multiplication of two string values.
     */
    public String multiply(String a, String b) {
        if (Integer.parseInt(b) == 1) {
            return a;
        }
        return add(a, multiply(a, add(b, "-1")));
    }

    public String multiplyTwoNumbers() {
        return multiply(super.first, super.second);
    }
}
