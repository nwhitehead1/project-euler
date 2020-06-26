package problems;

import lib.helpers.AdditionHelper;
import runner.ProjectEulerRunner;

public class Problem020 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem020().run());
    }

    @Override
    public String run() {
        int result = 0;
        String sum = "100";
        int next = 100;

        sum = factorial(sum, next-1);
		char[] charSum = sum.toCharArray();
		for (Character c : charSum) {
			result += Character.getNumericValue(c);
		}
		return String.valueOf(result);
    }

    /*
        Multiplying n*m is equivalent to adding n+n+...+n, m times.
        10+10+...+10 -> 9 times -> take result
        result+result+...+result -> 8 times
     */
    private String factorial(String result, int next) {
        if (next == 1) {
            return result;
        } else {
            String newResult = "0";
            for (int i = 0; i < next; i++) {
                newResult = new AdditionHelper(newResult, result).addTwoNumbers();
            }
            return factorial(newResult, next - 1);
        }

    }
}
