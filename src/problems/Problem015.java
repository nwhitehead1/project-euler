package problems;

import runner.ProjectEulerRunner;

import java.math.BigInteger;

public class Problem015 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem015().run());
    }

    @Override
    public String run() {
        BigInteger result = simpleFactorial(40).divide((simpleFactorial(20).multiply(simpleFactorial(40 - 20))));
        return result.toString();
    }

    private BigInteger simpleFactorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}
