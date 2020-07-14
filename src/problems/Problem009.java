package problems;

import runner.ProjectEulerRunner;

import java.util.stream.IntStream;

public class Problem009 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem009().run());
    }

    @Override
    public String run() {
        int result = specialPythagoreanTriplet(1000);
        return Integer.toString(result);
    }

    private int specialPythagoreanTriplet(int n) {
        return IntStream.rangeClosed(1, n).boxed()
                .flatMapToInt(a -> IntStream.rangeClosed(a, n)
                        .filter(b -> a + b + Math.sqrt(a * a + b * b) == n)
                        .map(b -> a * b * (int) Math.sqrt(a * a + b * b)))
                .findFirst()
                .getAsInt();

    }
}
