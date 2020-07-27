package problems;

import runner.ProjectEulerCallable;

import java.util.stream.IntStream;

public class Problem001 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem001().call());
    }

    @Override
    public String call() {
        int result = divisibleSequential();
        System.out.println("Executing " + this.getClass().getSimpleName() + " -> Thread: " + Thread.currentThread().getName());
        return Integer.toString(result);
    }

    private int divisibleSequential() {
        return IntStream.range(1, 1000)
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .sum();
    }
}