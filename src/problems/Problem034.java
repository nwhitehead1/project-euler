package problems;

import lib.Library;
import runner.ProjectEulerCallable;

import java.util.ArrayList;
import java.util.List;

public class Problem034 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem034().call());
    }

    @Override
    public String call() {
        int result = digitFactorials();
        System.out.println("Executing " + this.getClass().getSimpleName() + " -> Thread: " + Thread.currentThread().getName());
        return Integer.toString(result);
    }

    /*
        Thoughts:
            Need to find an upper bound. Number of factorials must equal the number of digits in the solution.
            x*9! = x digits long
            x=1: 1*9! = 6 digits long
            x=2: 2*9! = 6 digits long
            x=3: 3*9! = 7 digits long
            x=4: 4*9! = 7 digits long
            ...
            x=7: 7*9! = 7 digits long
            x=8: 8*9! = 7 digits long.

            We can safely assume that as x gets very large, the number of digits will increase at a much slower rate.
            We will bound our solution above by the smallest 8 digit number: 10000000

            As per the question, we will eliminate 1! and 2! as they are not sums of factorials
     */
    private int digitFactorials() {
        int result = 0;
        for (int i = 3; i < 10000000; i++) {
            if (isFactorialEqualToDigitFactorials(i)) {
                result += i;
            }
        }
        return result;
    }

    private boolean isFactorialEqualToDigitFactorials(int factorial) {
        List<Integer> factorialDigits = collectDigits(factorial, new ArrayList<>());
        int test = factorialDigits.stream()
                .mapToInt(Library::factorial).sum();
        return (test == factorial);
    }

    private List<Integer> collectDigits(int value, List<Integer> digits) {
        if (value / 10 == 0) {
            digits.add(value);
            return digits;
        }
        digits.add(value % 10);
        return collectDigits(value / 10, digits);
    }
}
