package problems;

import runner.ProjectEulerRunner;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Problem009 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem009().run());
    }

    @Override
    public String run() {
        int result = specialPythagoreanTriplet();
        return Integer.toString(result);
    }

    private int specialPythagoreanTriplet() {
        OptionalInt result = IntStream.rangeClosed(1, 1000).boxed()
                .flatMapToInt(a -> IntStream.rangeClosed(a, 1000)
                        .filter(b -> a + b + Math.sqrt(a * a + b * b) == 1000)
                        .map(b -> a * b * (int) Math.sqrt(a * a + b * b)))
                .findFirst();
        return result.isPresent() ? result.getAsInt() : 0;
    }
}
