package problems;

import runner.ProjectEulerCallable;

import java.math.BigInteger;

public class Problem015 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem015().call());
    }

    @Override
    public String call() {
        BigInteger result = latticePaths();
        System.out.println("Executing " + this.getClass().getSimpleName() + " -> Thread: " + Thread.currentThread().getName());
        return result.toString();
    }

    /*
        Thoughts:
            Number of lattice paths from (0,0) to (n,k) is (n+k)C(n), in this instance n=k=20
            Therefore, (40)C(20) = 40! / (20! x (40-20)!)
     */
    private BigInteger latticePaths()  {
        BigInteger numerator = factorial(2* 20);
        BigInteger denominator = factorial(20).multiply(factorial(20));
        return numerator.divide(denominator);
    }

    private BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}
