package problems;

import lib.Library;
import runner.ProjectEulerRunner;

public class Problem006 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem006().run());
    }

    @Override
    public String run() {
        return String.valueOf(squareOfSums(100) - Library.sumOfSquares(100));
    }

    private long squareOfSums(int n) {
        long sum = Library.increasingSum(n);
        return sum * sum;
    }

}