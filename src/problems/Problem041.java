package problems;

import lib.Library;
import runner.ProjectEulerRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Problem041 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem041().run());
    }

    @Override
    public String run() {
        int result = largestPandigitalPrimeFaster();
        return Integer.toString(result);
    }

    /*
        Thoughts:
            Fermat's Little Theorem - p is prime, for integer a, a^p - a is an integer multiple of p.
                ie. a^p = a (mod p)
            Background:
                Modulo Congruence: if b-a is integrally divisible by a number m (ie. (b-a)/m is an integer) then
                    b and a are "congruent modulo m" -> b = a (mod m)
            How?
                Any power of 10 is congruent to 1 (mod 3), ie. 10^k = 1 (mod 3)
                Integer n can be broken into:
                    n = a_k + (a_{k-1} * 10^1) + ... + a_0 * 10^k) = a_k + a_{k-1} + ... + a_0 (mod 3)
                    ie. Dividing n by 3 is the same as dividing the sum of its digits by 3
                Given pandigital numbers, we can easily find the digit sums, and find which are divisible by 3
                If these digit sums are divisible by 3 then they cannot be prime.
     */
    private int largestPandigitalPrimeFaster() {
        List<Integer> pandigitalCongruenceLength = new ArrayList<>();
        IntPredicate pandigital = num -> Library.isPandigital(num);
        IntPredicate prime = num -> Library.isPrime(num);
        for (int i = 1; i < 9; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += j;
            }
            if (sum % 3 != 0) {
                pandigitalCongruenceLength.add(i);
            }
        }
        Collections.sort(pandigitalCongruenceLength, Collections.reverseOrder());
        for (Integer digitLength : pandigitalCongruenceLength) {
            int upperBound = 0;
            for (int i = 1; i <= digitLength; i++) {
                upperBound += i * (int) Math.pow(10, i - 1);
            }
            int lowerBound = Library.reverseInt(upperBound);
            int finalUpperBound = upperBound;
            return IntStream.rangeClosed(lowerBound, upperBound)
                    .map(num -> finalUpperBound - num + lowerBound - 1)
                    .parallel()
                    .filter(pandigital.and(prime))
                    .findFirst().getAsInt();
        }
        return 0;
    }

    /*
        Thoughts:
            Largest pandigital prime must be at most less than 987654321
            Predicate to check pandigital
            Predicate to check primality
            Find first occurrence
            Brute force approach - can be improved
     */
    private int largestPandigitalPrime() {
        int limit = 987654321;
        int start = 0;

        IntPredicate pandigital = num -> Library.isPandigital(num);
        IntPredicate prime = num -> Library.isPrime(num);

        OptionalInt result = IntStream.rangeClosed(start, limit)
                .parallel()
                .map(num -> limit - num + start - 1)
                .filter(pandigital.and(prime))
                .findFirst();

        return result.getAsInt();
    }
}