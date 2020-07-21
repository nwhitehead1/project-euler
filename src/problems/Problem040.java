package problems;

import runner.ProjectEulerRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem040 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem040().run());
    }

    @Override
    public String run() {
        int result = champernownesConstant(100, 1000, 10000, 100000, 1000000);
        return Integer.toString(result);
    }

    /*
        Thoughts:
            Try to find a closed form, rather than brute forcing
            first 9 digits are single digit length, hence 1*9 = 9 digits. RANGE 1-9
            next 90 digits are two digit length, hence 2*90 = 180 digits. RANGE 10-99
            next 900 digits are three digit length, hence 3*900 = 2700 digits. RANGE 100-999
                ...
            Generally, n*9*10^(n-1), for n digit numbers.
            1, and 10 are trivial, since they are both 1 they will not affect the product.
     */
    // TODO: This is sloppy and pretty poorly done, revisit later
    private int champernownesConstant(int... n) {
        List<Integer> champernownesDigits = new ArrayList();
        for (Integer value : n) {
            int indexLength = (int) Math.log10(value);
            double previousDecadeSum = IntStream.rangeClosed(1, indexLength).map(num -> num * 9 * (int) Math.pow(10, num - 1)).filter(d -> d < value).sum();
            double termInDecade = value - previousDecadeSum;
            double actualValue = (termInDecade / indexLength + Math.pow(10, indexLength - 1) - 1);
            long round = Math.round((actualValue % indexLength) * indexLength);
            int termIndex = (actualValue % indexLength > 1) ? (int) round - indexLength
                    : (int) round;
            int integerActualValue = (int) actualValue;
            char constant = Integer.toString(integerActualValue).toCharArray()[termIndex - 1];
            champernownesDigits.add(Character.getNumericValue(constant));
        }
        return champernownesDigits.stream().reduce(1, (a, b) -> a * b);
    }
}
