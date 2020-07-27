package problems;

import lib.Library;
import runner.ProjectEulerCallable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem046 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem046().call());
    }

    @Override
    public String call() {
        int result = goldbachsOtherConjecture();
        printCallableThread();
        return Integer.toString(result);
    }

    /*
        Thoughts:
            Odd composite numbers:
                Let N be an odd composite number.
                Let I = (2i + 1) be odd
                Let J = (2j + 1) be odd
                Then N = IJ = (2i+1)*(2j+1) = 4ij + 2i + 2j + 1 = 2ij + i + j, 1<=j<=i
           For any odd composite number, we must consider primes less than that number, and squares less than that number
           Additionally, we can see if any composite minus a smaller prime, divided by 2 is a square number
           Let M be this derivation -> M = (C - P)/2, where C is composite, P is prime, and C > P.
           We can easily show square numbers less than this as sqrt(M). If a number exists then it is satisfied, else it
           fails and that is the solution.
           To find odd composite numbers:
                We can find the gcd of that number, if it is odd and > 1 then it satisfies this condition.
     */
    private int goldbachsOtherConjecture() {
        boolean found = false;
        int compositeNumber = 33;
        while (!found) {
            compositeNumber += 2;
            if (largestDivisor(compositeNumber) != 1) {
                List<Integer> primes = IntStream.range(1, compositeNumber).boxed().filter(Library::isPrime).collect(Collectors.toList());
                int finalCompositeNumber = compositeNumber;
                found = primes.stream().noneMatch(prime -> isSquareDiv2((finalCompositeNumber - prime)));
            }
        }
        return compositeNumber;
    }

    private int largestDivisor(int n) {
        for (int i = n / 2; i >= 2; i--) {
            if (n % i == 0) {
                return i;
            }
        }
        return 1;
    }

    private boolean isSquareDiv2(int n) {
        double square = Math.sqrt(n / 2);
        return square == ((int) square);
    }
}
