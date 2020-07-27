package problems;

import lib.Library;
import runner.ProjectEulerCallable;

import java.util.stream.IntStream;

public class Problem021 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem021().call());
    }

    @Override
    public String call() {
        int result = amicablePairs();
        printCallableThread();
        return Integer.toString(result);
    }

    private int amicablePairs() {
        return IntStream.rangeClosed(1, 10000).filter(num -> isAmicablePair(num, Library.sumOfProperDivisors(num))).sum();
    }

    private boolean isAmicablePair(int value, int valuesSumOfProperDivisors) {
        if (value == valuesSumOfProperDivisors) {
            return false;
        } else {
            int x = Library.sumOfProperDivisors(valuesSumOfProperDivisors);
            return x == value;
        }
    }
}