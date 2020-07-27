package problems;

import lib.Library;
import runner.ProjectEulerCallable;

public class Problem006 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem006().call());
    }

    @Override
    public String call() {
        int result = squareOfSum() - Library.sumOfSquares(100);
        printCallableThread();
        return Integer.toString(result);
    }

    /*
        Thoughts:
            Use time-efficient sum calculation without looping
     */
    private int squareOfSum() {
        int sum = Library.increasingSum(100);
        return sum * sum;
    }
}