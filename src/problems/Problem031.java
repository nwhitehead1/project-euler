package problems;

import runner.ProjectEulerRunner;

public class Problem031 implements ProjectEulerRunner {

    private static final int[] COINS = {1, 2, 5, 10, 20, 50, 100, 200};

    public static void main(String[] args) {
        System.out.println(new Problem031().run());
    }

    @Override
    public String run() {
        int result = coinChange(COINS, COINS.length, 200);
        return Integer.toString(result);
    }

    /*
        Thoughts:
            Use Dynamic Programming approach to count the ways we can sum coins s[0,...,m-1] to get n
     */
    private int coinChange(int[] s, int m, int n) {
        // Initial Condition - F(0)=1
        if (n == 0) {
            return 1;
        }
        // n cannot be less than 0
        if (n < 0) {
            return 0;
        }
        // If there are no coins and n > 0
        if (m < 1) {
            return 0;
        }

        /* Recurrence Relation:
            1. Sum of solutions including coin s[m-1]
            2. Sum of solutions excluding coin s[m-1]
         */
        return coinChange(s, m - 1, n) + coinChange(s, m, n - s[m - 1]);
    }
}
