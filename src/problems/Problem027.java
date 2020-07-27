package problems;

import lib.Library;
import runner.ProjectEulerCallable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem027 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem027().call());
    }

    @Override
    public String call() {
        int result = quadraticPrimes();
        System.out.println("Executing " + this.getClass().getSimpleName() + " -> Thread: " + Thread.currentThread().getName());
        return Integer.toString(result);
    }

    /*
        Thoughts:
            n^2 + an + b, |a|<1000, |b|<=1000
            n=0 => b. Therefore b must be prime
            n=1 => 1 + a + b. Since all primes besides 2 are odd, a must be odd
     */
    private int quadraticPrimes() {
        int nMax = 0, aMax = 0, bMax = 0;
        List<Integer> bValues = IntStream.rangeClosed(0, 1000).boxed()
                .filter(Library::isPrime).sorted().collect(Collectors.toList());

        for (int a = -999; a < 1000; a += 2) {
            for (Integer b : bValues) {
                int n = 0;
                while (Library.isPrime(Math.abs(n * n + a * n + b))) {
                    n++;
                }
                if (n > nMax) {
                    nMax = n;
                    aMax = a;
                    bMax = b;
                }
            }
        }
        return aMax * bMax;
    }
}
