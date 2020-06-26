package problems;

import lib.Library;
import runner.ProjectEulerRunner;

public class Problem016 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem016().run());
    }

    @Override
    public String run() {
        String result = calculate("2", 1000);
        int sumTotal = 0;
        for (char c : result.toCharArray()) {
            sumTotal += Character.getNumericValue(c);
        }
        return String.valueOf(sumTotal);
    }

    private String calculate(String sum, int iteration) {
        StringBuilder sumBuilder = new StringBuilder();
        String reverseSum = Library.reverseString(sum);
        int integerSum, carry = 0;

        if (iteration < 2) {
            return sum;
        }

        for (int i = 0; i < sum.length(); i++) {
            integerSum = Character.getNumericValue(reverseSum.charAt(i));
            int result = integerSum + integerSum + carry;
            if (result > 9) {
                carry = result / 10;
            } else {
                carry = 0;
            }
            sumBuilder.append(result % 10);
        }

        return calculate(
                Library.reverseString(carry != 0 ? sumBuilder.append(carry).toString() : sumBuilder.toString()),
                iteration - 1);
    }
}
