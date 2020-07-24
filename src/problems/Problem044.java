package problems;

import runner.ProjectEulerRunner;

public class Problem044 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem044().run());
    }

    @Override
    public String run() {
        int result = smallestPentagonalNumberDifference();
        return Integer.toString(result);
    }

    /*
        Thoughts:
            Given a number n, check if it is pentagonal.
            Find potential pentagonal numbers less than n, if n-m and n+m are both pentagonal, return n-m
     */
    private int smallestPentagonalNumberDifference() {
        boolean found = false;
        int result = 0;
        // No point starting at 1, since not pentagonal numbers exist below i=1
        int i = 1;
        while (!found) {
            ++i;
            int firstPentagonal = (i * (3 * i - 1)) / 2;
            for (int j = i - 1; j > 0; j--) {
                int secondPentagonal = (j * (3 * j - 1)) / 2;
                if (isPentagonal(firstPentagonal - secondPentagonal) && isPentagonal(firstPentagonal + secondPentagonal)) {
                    found = true;
                    result = firstPentagonal - secondPentagonal;
                    break;
                }
            }

        }
        return result;
    }

    /*
        Thoughts:
            Generate pentagonal numbers less than n
            Check if last generated pentagonal is equal to n
            Even better -> check if inverse function yields an integer. Used Wikipedia entry
     */
    private boolean isPentagonal(int n) {
        double test = (Math.sqrt(1 + 24 * n) + 1.0) / 6.0;
        return test == ((int) test);
    }
}
