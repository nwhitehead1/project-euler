package problems;

import lib.Library;
import runner.ProjectEulerCallable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem047 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem047().call());
    }

    @Override
    public String call() {
        int result = distinctPrimeFactors();
        return Integer.toString(result);
    }

    /*
        Thoughts:
            Smallest 4 distinct primes = 2 x 3 x 5 x 7 = 210
            Generate numbers with distinct prime factorizations

            TODO: Brute force solution was very slow (~8 seconds). Found it to be 134043.
                Cheap way to speed up - use static list of primes under sqrt(150000)
                Can't think of a nicer way to do this beyond brute force at them moment - return to it later!
     */

    private static final int LIMIT = (int) Math.sqrt(150000);
    private static final List<Integer> PRIMES_LIST_OVER_TWO = IntStream.iterate(3, i -> i + 2)
            .boxed()
            .limit(LIMIT)
            .filter(Library::isPrime)
            .collect(Collectors.toList());

    private int distinctPrimeFactors() {
        int result = 210;
        int consecutive = 1;
        while (consecutive < 4) {
            result++;
            if (numberOfPrimeFactors(result) == 4) {
                consecutive++;
            } else {
                consecutive = 0;
            }
        }
        return result - 3;
    }

    private int numberOfPrimeFactors(int n) {
        Set<Integer> factorization = new HashSet<>();
        while (n % 2 == 0) {
            factorization.add(2);
            n /= 2;
        }
        for (Integer prime : PRIMES_LIST_OVER_TWO) {
            while (n % prime == 0) {
                factorization.add(prime);
                n /= prime;
            }
            if (n == 1) {
                return factorization.size();
            }
        }
        return factorization.size();
    }
}
