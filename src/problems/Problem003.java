package problems;

import lib.Library;
import runner.ProjectEulerRunner;

import java.math.BigInteger;

public class Problem003 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem003().run());
    }

    @Override
    public String run() {
        int result = largestPrimeFactor(new BigInteger("600851475143"));
        return Integer.toString(result);
    }

    private int largestPrimeFactor(BigInteger value) {
        int largestPrime = 2;
        int max = generateSqrt(value);
        for (int i = 2; i < max; i++) {
            if ((i & 1) == 0) {
                continue;
            } else {
                if (value.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
                    if (Library.isPrime(i) && i > largestPrime) {
                        largestPrime = i;
                    }
                }
            }
        }
        return largestPrime;
    }

    /*
        Thoughts:
		    Prime factors cannot be larger than the square root of the value tested
     */
    private int generateSqrt(BigInteger limit) {
        BigInteger index = BigInteger.ONE;
        for (; ; ) {
            if (!(index.multiply(index).compareTo(limit) == -1)) {
                return index.intValue() - 1;
            } else {
                index = index.add(BigInteger.ONE);
            }
        }
    }
}
