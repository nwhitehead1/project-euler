package problems;

import lib.Library;
import runner.ProjectEulerRunner;

public class Problem010 implements ProjectEulerRunner {

    private static final int LIMIT = 2000000;

    public static void main(String[] args) {
        System.out.println(new Problem010().run());
    }

    @Override
    public String run() {
        long primes = 2;
        for (int i = 3; i < LIMIT; i++) {
            if (Library.isPrime(i)) {
                primes += i;
            }
        }
        return String.valueOf(primes);
    }
}
