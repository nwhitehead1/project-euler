package problems;

import lib.Library;
import runner.ProjectEulerRunner;

public class Problem006 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem006().run());
    }

    @Override
    public String run() {
        int result = squareOfSum() - Library.sumOfSquares(100);
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