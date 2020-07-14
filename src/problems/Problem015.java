package problems;

import runner.ProjectEulerRunner;

import java.math.BigInteger;

public class Problem015 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem015().run());
    }

    @Override
    public String run() {
        BigInteger result = latticePaths(20);
        return result.toString();
    }

    /*
        Thoughts:
            Number of lattice paths from (0,0) to (n,k) is (n+k)C(n), in this instance n=k=20
            Therefore, (40)C(20) = 40! / (20! x (40-20)!)
     */
    private BigInteger latticePaths(int gridSize)  {
        BigInteger numerator = factorial(2*gridSize);
        BigInteger denominator = factorial(gridSize).multiply(factorial(gridSize));
        BigInteger result = numerator.divide(denominator);
        return result;
    }

    private BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}
