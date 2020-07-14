package problems;

import runner.ProjectEulerRunner;

import java.util.stream.IntStream;

public class Problem001 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem001().run());
    }

    @Override
    public String run() {
        return Integer.toString(divisibleSequential(1000));
    }

    private int divisibleSequential(int range) {
        return IntStream.range(1, range)
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .sum();
    }
}