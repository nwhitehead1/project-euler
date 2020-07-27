package problems;

import lib.Library;
import runner.ProjectEulerCallable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem035 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem035().call());
    }

    @Override
    public String call() {
        int result = circularPrimes();
        printCallableThread();
        return Integer.toString(result);
    }

    /*
        Thoughts:
            Generate primes below 1000000, use parallel stream since isPrime() is expensive and independent
            For each prime, find its circular permutations and check if they are also prime
            ONLY count primes where ALL digit rotations are prime
            Remove primes where a digit is divisible by 2 or 5
     */
    private int circularPrimes() {
        Predicate<Integer> primality = Library::isPrime;
        Predicate<Integer> primeCandidate = this::isPrimeCandidate;

        List<Integer> primes = IntStream.rangeClosed(2, 1000000)
                .boxed()
                .parallel()
                .filter(primality.and(primeCandidate))
                .collect(Collectors.toList());

        Iterator<Integer> primeIterator = primes.iterator();
        List<Integer> removed = new ArrayList<>();
        List<Integer> rotations;
        while (primeIterator.hasNext()) {
            int prime = primeIterator.next();
            rotations = digitRotations(prime);
            if (!primes.containsAll(rotations)) {
                removed.add(prime);
            }
        }
        primes.removeAll(removed);
        return primes.size();
    }

    /*
        Thoughts:
            For speed up, if number contains a 2 or 5 (and length > 1) then it won't be a prime when rotated at some point
     */
    private boolean isPrimeCandidate(int prime) {
        if (prime / 10 == 0)
            return true;
        while (prime > 0) {
            int digit = prime % 10;
            if (digit % 2 == 0 || digit % 5 == 0) {
                return false;
            }
            prime /= 10;
        }
        return true;
    }

    /*
        Thoughts:
            Scenario where prime doesn't contain an even digit, or 5
     */
    private List<Integer> digitRotations(int prime) {
        List<Integer> rotations = new ArrayList<>(Collections.singletonList(prime));
        int length = (int) (Math.log10(prime) + 1);
        int firstDigit, initialValue = prime;
        // Digit rotations, eg. say prime = 430
        for (int i = 0; i < length - 1; i++) {
            firstDigit = prime / (int) Math.pow(10, length - 1); // 4
            prime *= 10;                                         // 4300
            prime += firstDigit;                                 // 4304
            prime -= firstDigit * (int) Math.pow(10, length);    // 304
            if (prime == initialValue) {
                break;
            }
            rotations.add(prime);
        }
        return rotations.stream().distinct().collect(Collectors.toList());
    }
}
