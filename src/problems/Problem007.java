package problems;

import lib.Library;
import runner.ProjectEulerCallable;

public class Problem007 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem007().call());
    }

    @Override
    public String call() {
        int result = nthPrime();
        System.out.println("Executing " + this.getClass().getSimpleName() + " -> Thread: " + Thread.currentThread().getName());
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
