package problems;

import runner.ProjectEulerRunner;

public class Problem005 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem005().run());
    }

    @Override
    public String run() {
        int smallest = 2520;
        for (int i = smallest; ; i += 2) {
            if (isDivisibleRange(i, 20)) {
                smallest = i;
                break;
            }
        }
        return String.valueOf(smallest);
    }

    private boolean isDivisibleRange(int n, int range) {
        if ((n & 1) != 0) {
            return false;
        }
        for (int i = 3; i <= range; i++) {
            if (n % i != 0) {
                return false;
            }
        }
        return true;
    }
}
