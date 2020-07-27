package problems;

import runner.ProjectEulerCallable;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Problem009 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem009().call());
    }

    @Override
    public String call() {
        int result = specialPythagoreanTriplet();
        System.out.println("Executing " + this.getClass().getSimpleName() + " -> Thread: " + Thread.currentThread().getName());
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
