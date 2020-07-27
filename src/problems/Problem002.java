package problems;

import runner.ProjectEulerCallable;

public class Problem002 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem002().call());
    }

    @Override
    public String call() {
        int result = fibonacciToLimit(1, 2, 4000000);
        printCallableThread();
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
