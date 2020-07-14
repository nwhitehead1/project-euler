package problems;

import lib.Library;
import runner.ProjectEulerRunner;

public class Problem012 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem012().run());
    }

    @Override
    public String run() {
        int result = highlyDevisibleTriangularNumber(500);
        return Integer.toString(result);
    }

    private int highlyDevisibleTriangularNumber(int divisorsLimit) {
        int currentTriangleNumber = 0;
        for (int i = 1; ; i++) {
            currentTriangleNumber += i;
            if (Library.numberOfDivisors(currentTriangleNumber) >= divisorsLimit) {
                return currentTriangleNumber;
            }
        }
    }
}