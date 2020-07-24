package problems;

import lib.Library;
import runner.ProjectEulerRunner;

public class Problem007 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem007().run());
    }

    @Override
    public String run() {
        int result = nthPrime();
        return Integer.toString(result);
    }

    private int nthPrime() {
        int primeCount = 1;
        int i = 3;
        while (primeCount < 10001) {
            if ((i & 1) == 0) {
                continue;
            } else {
                if (Library.isPrime(i)) {
                    primeCount++;
                }
            }
            i += 2;
        }
        return i - 2;
    }
}
