package problems;

import runner.ProjectEulerCallable;

public class Problem005 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem005().call());
    }

    @Override
    public String call() {
        int result = smallestMultiple();
        printCallableThread();
        return Integer.toString(result);
    }

    private int smallestMultiple() {
        int smallest = 2520;
        for (int i = smallest; ; i += 2) {
            if (isDivisibleRange(i)) {
                smallest = i;
                break;
            }
        }
        return smallest;
    }

    private boolean isDivisibleRange(int n) {
        if ((n & 1) != 0) {
            return false;
        }
        for (int i = 3; i <= 20; i++) {
            if (n % i != 0) {
                return false;
            }
        }
        return true;
    }
}
