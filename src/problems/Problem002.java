package problems;

import runner.ProjectEulerRunner;

public class Problem002 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem002().run());
    }

    @Override
    public String run() {
        int result = fibonacciToLimit(1, 2, 4000000);
        return Integer.toString(result);
    }

    private int fibonacciToLimit(int first, int second, int limit) {
        if (second > limit) {
            return 0;
        } else if ((second & 1) == 0) {
            return second + fibonacciToLimit(second, first + second, limit);
        } else {
            return fibonacciToLimit(second, first + second, limit);
        }
    }
}
