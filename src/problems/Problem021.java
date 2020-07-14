package problems;

import lib.Library;
import runner.ProjectEulerRunner;

import java.util.stream.IntStream;

public class Problem021 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem021().run());
    }

    @Override
    public String run() {
        int result = amicablePairs(10000);
        return Integer.toString(result);
    }

    private int amicablePairs(int limit) {
        return IntStream.rangeClosed(1, limit).filter(num -> isAmicablePair(num, Library.sumOfProperDivisors(num))).sum();
    }

    private boolean isAmicablePair(int value, int valuesSumOfProperDivisors) {
        if (value == valuesSumOfProperDivisors) {
            return false;
        } else {
            int x = Library.sumOfProperDivisors(valuesSumOfProperDivisors);
            if (x == value) {
                return true;
            } else {
                return false;
            }
        }
    }
}