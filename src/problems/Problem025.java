package problems;

import lib.helpers.AdditionHelper;
import runner.ProjectEulerCallable;

public class Problem025 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem025().call());
    }

    @Override
    public String call() {
        int result = nthDigitFibonacci("1", "1", 1000, new AdditionHelper());
        System.out.println("Executing " + this.getClass().getSimpleName() + " -> Thread: " + Thread.currentThread().getName());
        return Integer.toString(result);
    }

    private int nthDigitFibonacci(String first, String second, int limit, AdditionHelper helper) {
        if (first.length() == limit) {
            return 1;
        }
        helper.setFirst(first);
        helper.setSecond(second);
        return 1 + nthDigitFibonacci(second, helper.addTwoNumbers(), limit, helper);
    }
}
