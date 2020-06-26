package problems;

import runner.ProjectEulerRunner;

public class Problem002 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem002().run());
    }

    @Override
    public String run() {
        int result = fibonacci(1, 2, 4000000);
        return Integer.toString(result);
    }

    /*
        Calculates the sum of even fibonacci values up to a limit
     */
    private int fibonacci(int first, int second, int limit) {
        if (second > limit) {
            return 0;
        } else if ((second & 1) == 0) {
            return second + fibonacci(second, first + second, limit);
        } else {
            return fibonacci(second, first + second, limit);
        }
    }
}
