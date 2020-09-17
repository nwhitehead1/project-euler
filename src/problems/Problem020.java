package problems;

import lib.arithmetic.Adder;
import runner.ProjectEulerCallable;

public class Problem020 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem020().call());
    }

    @Override
    public String call() {
        int result = factorialDigitSum("100", 99, new Adder());
        printCallableThread();
        return Integer.toString(result);
    }

    /*
        Thoughts:
            Multiplying n*m is equivalent to adding n+n+...+n, m times.
            10+10+...+10 -> 9 times -> take result
            result+result+...+result -> 8 times
     */
    private int factorialDigitSum(String n, int iteration, Adder helper) {
        if (iteration == 1) {
            return n.chars().map(Character::getNumericValue).sum();
        }
        String sum = n;
        for (int i = 1; i < iteration; i++) {
            helper.setFirst(sum);
            helper.setSecond(n);
            sum = helper.addTwoNumbers();
        }
        return factorialDigitSum(sum, iteration - 1, helper);
    }
}
