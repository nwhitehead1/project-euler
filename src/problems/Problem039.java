package problems;

import runner.ProjectEulerCallable;

import java.util.stream.IntStream;

public class Problem039 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem039().call());
    }

    @Override
    public String call() {
        int result = maxIntegerRightTrianglesCount();
        System.out.println("Executing " + this.getClass().getSimpleName() + " -> Thread: " + Thread.currentThread().getName());
        return Integer.toString(result);
    }

    private int maxIntegerRightTrianglesCount() {
        long solutions = 0;
        int perimeterMax = 0;
        for (int i = 1; i <= 1000; i++) {
            long maxSolutions = integerRightTrianglesCount(i);
            if (maxSolutions > solutions) {
                perimeterMax = i;
                solutions = maxSolutions;
            }
        }
        return perimeterMax;
    }

    /*
        Thoughts:
            p = a+b+sqrt(a^2 + b^2) is the perimeter of a right triangle with sides of length a,b.
            a,b must be less than p
     */
    private long integerRightTrianglesCount(int p) {
        return IntStream.rangeClosed(1, p)
                .parallel()
                .flatMap(a -> IntStream.rangeClosed(a, p)
                        .filter(b -> a + b + Math.sqrt(a * a + b * b) == p)
                ).count();
    }
}
