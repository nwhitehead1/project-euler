package problems;

import lib.Library;
import runner.ProjectEulerCallable;

public class Problem012 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem012().call());
    }

    @Override
    public String call() {
        int result = highlyDevisibleTriangularNumber();
        printCallableThread();
        return Integer.toString(result);
    }

    private int highlyDevisibleTriangularNumber() {
        int currentTriangleNumber = 0;
        for (int i = 1; ; i++) {
            currentTriangleNumber += i;
            if (Library.numberOfDivisors(currentTriangleNumber) >= 500) {
                return currentTriangleNumber;
            }
        }
    }
}