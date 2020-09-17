package problems;

import lib.arithmetic.Adder;
import runner.ProjectEulerCallable;

public class Problem025 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem025().call());
    }

    @Override
    public String call() {
        int result = nthDigitFibonacci("1", "1", 1000, new Adder());
        printCallableThread();
        return Integer.toString(result);
    }

    private int nthDigitFibonacci(String first, String second, int limit, Adder adder) {
        if (first.length() == limit) {
            return 1;
        }
        adder.setFirst(first);
        adder.setSecond(second);
        return 1 + nthDigitFibonacci(second, adder.addTwoNumbers(), limit, adder);
    }
}
