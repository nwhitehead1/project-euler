package problems;

import runner.ProjectEulerRunner;

public class Problem028 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem028().run());
    }

    @Override
    public String run() {
        return String.valueOf(sumOfDiagonals(1001));
    }

    public int sumOfDiagonals(int shape) {
        // 1, center
        // diagonals = 3, 5, 7, 9, cornerDiff = 2, shape=3x3
        // diagonals = 13, 17, 21, 25, cornerDiff = 4, shape=5x5
        // diagonals = 31, 37, 43, 49, cornerDiff = 6, shape=7x7

        int diagonal = 1, sum = 1, cornerDiff = 2;
        for (int i = 3; i <= shape; i += 2) {
            // 4 corners each iterated box
            for (int j = 0; j < 4; j++) {
                diagonal += cornerDiff;
                sum += diagonal;
            }
            // Increase the cornerDiff to account for larger box
            cornerDiff += 2;
        }
        return sum;
    }
}
