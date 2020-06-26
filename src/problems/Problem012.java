package problems;

import lib.Library;
import runner.ProjectEulerRunner;

public class Problem012 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem012().run());
    }

    @Override
    public String run() {
        int currentTriangleNumber = 0;
        for (int i = 1; ; i++) {
            currentTriangleNumber += i;
            if (Library.numberOfDivisors(currentTriangleNumber) >= 500) {
                return String.valueOf(currentTriangleNumber);
            }
        }
    }
}