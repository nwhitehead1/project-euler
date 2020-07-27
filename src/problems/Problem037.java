package problems;

import lib.Library;
import runner.ProjectEulerCallable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem037 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem037().call());
    }

    @Override
    public String call() {
        int result = tcallcatablePrimesSum();
        printCallableThread();
        return Integer.toString(result);
    }

    /*
        Thoughts:
            Given a finite set of right-left tcallcatable primes, we can find the finite set of left-right tcallcatable primes
     */
    private int tcallcatablePrimesSum() {
        List<Integer> singleDigitPrimes = Arrays.asList(2, 3, 5, 7);
        List<Integer> rightTcallcatablePrimes = snowballPrimes(singleDigitPrimes, new ArrayList<>());
        List<Integer> remove = new ArrayList<>();

        for (Integer rightTcallcatablePrime : rightTcallcatablePrimes) {
            int prime = Library.reverseInt(rightTcallcatablePrime);
            while (prime != 0) {
                if (!Library.isPrime(Library.reverseInt(prime))) {
                    remove.add(rightTcallcatablePrime);
                    break;
                }
                prime /= 10;
            }
        }

        rightTcallcatablePrimes.removeAll(remove);
        return rightTcallcatablePrimes.stream().reduce(0, Integer::sum);
    }

    /*
        Thoughts:
            Generate right-left tcallcatable primes by starting with single digit primes 2, 3 ,5, and 7
            then adding digits that are not divisible by 2 and 5 (ie. {1,3,7,9}.
            eg. 21, 23, 27, 29, 31, ...
            Right-left tcallcatable primes with k digits form prefixes for right-left tcallcatable primes of k+1 digits
            Process ends if no tcallcatable primes exist for k digits
     */
    private List<Integer> snowballPrimes(List<Integer> kthDigitTcallcatable, List<Integer> result) {
        List<Integer> validAppends = Arrays.asList(1, 3, 7, 9);
        List<Integer> nextKthDigitTcallcatable = new ArrayList<>();
        for (Integer candidate : kthDigitTcallcatable) {
            candidate *= 10;
            for (Integer append : validAppends) {
                nextKthDigitTcallcatable.add(candidate + append);
            }
        }
        nextKthDigitTcallcatable = nextKthDigitTcallcatable.parallelStream().filter(Library::isPrime).collect(Collectors.toList());
        if (!nextKthDigitTcallcatable.isEmpty()) {
            result.addAll(nextKthDigitTcallcatable);
            return snowballPrimes(nextKthDigitTcallcatable, result);
        } else {
            return result;
        }
    }
}
