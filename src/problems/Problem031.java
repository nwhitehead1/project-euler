package problems;

import runner.ProjectEulerRunner;

public class Problem031 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem031().run());
    }

    @Override
    public String run() {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        return String.valueOf(coinChange(coins, coins.length, 200));
    }

    /*
        In the United Kingdom the currency is made up of pound (£) and pence (p). There are eight coins in general circulation:
        1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
        It is possible to make £2 in the following way:
        1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
        How many different ways can £2 be made using any number of coins?

        Thoughts:
            Use Dynamic Programming
     */

    /**
     * Dynamic Programming approach to count the ways we can sum coins s[0,...,m-1] to get n
     *
     * @param s array of coin denominations
     * @param m number of coins available
     * @param n sum of coins
     * @return number of ways to make change
     */
    public int coinChange(int[] s, int m, int n) {
        // Initial Condition - F(0)=1
        if (n == 0) {
            return 1;
        }
        // n cannot be less than 0
        if (n < 0) {
            return 0;
        }
        // If there are no coins and n > 0
        if (m < 1 && n > 0) {
            return 0;
        }

        /* Recurrence Relation:
            1. Sum of solutions including coin s[m-1]
            2. Sum of solutions excluding coin s[m-1]
         */
        return coinChange(s, m - 1, n) + coinChange(s, m, n - s[m - 1]);
    }
}
