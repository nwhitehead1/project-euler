package problems;

import lib.Library;
import runner.ProjectEulerRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem037 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem037().run());
    }

    @Override
    public String run() {
        int result = truncatablePrimesSum();
        return Integer.toString(result);
    }

    /*
        Thoughts:
            Given a finite set of right-left truncatable primes, we can find the finite set of left-right truncatable primes
     */
    private int truncatablePrimesSum() {
        List<Integer> singleDigitPrimes = Arrays.asList(2, 3, 5, 7);
        List<Integer> rightTruncatablePrimes = snowballPrimes(singleDigitPrimes, new ArrayList<>());
        List<Integer> remove = new ArrayList<>();

        for (Integer rightTruncatablePrime : rightTruncatablePrimes) {
            int prime = Library.reverseInt(rightTruncatablePrime);
            while (prime != 0) {
                if (!Library.isPrime(Library.reverseInt(prime))) {
                    remove.add(rightTruncatablePrime);
                    break;
                }
                prime /= 10;
            }
        }

        rightTruncatablePrimes.removeAll(remove);
        return rightTruncatablePrimes.stream().reduce(0, (a, b) -> a + b);
    }

    /*
        Thoughts:
            Generate right-left truncatable primes by starting with single digit primes 2, 3 ,5, and 7
            then adding digits that are not divisible by 2 and 5 (ie. {1,3,7,9}.
            eg. 21, 23, 27, 29, 31, ...
            Right-left truncatable primes with k digits form prefixes for right-left truncatable primes of k+1 digits
            Process ends if no truncatable primes exist for k digits
     */
    private List<Integer> snowballPrimes(List<Integer> kthDigitTruncatable, List<Integer> result) {
        List<Integer> validAppends = Arrays.asList(1, 3, 7, 9);
        List<Integer> nextKthDigitTruncatable = new ArrayList<>();
        for (Integer candidate : kthDigitTruncatable) {
            candidate *= 10;
            for (Integer append : validAppends) {
                nextKthDigitTruncatable.add(candidate + append);
            }
        }
        nextKthDigitTruncatable = nextKthDigitTruncatable.parallelStream().filter(num -> Library.isPrime(num)).collect(Collectors.toList());
        if (!nextKthDigitTruncatable.isEmpty()) {
            result.addAll(nextKthDigitTruncatable);
            return snowballPrimes(nextKthDigitTruncatable, result);
        } else {
            return result;
        }
    }
}
