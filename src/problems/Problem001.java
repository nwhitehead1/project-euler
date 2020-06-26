package problems;

import runner.ProjectEulerRunner;

import java.util.stream.IntStream;

public class Problem001 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem001().run());
    }

    @Override
    public String run() {
        // Straightforward - filter values that are divisible by 3 or 5 between [0,100] and collect into sum
        int result = IntStream.range(1, 1000).filter(n -> n % 3 == 0 || n % 5 == 0).sum();
        return Integer.toString(result);
    }
}