package problems;

import runner.ProjectEulerRunner;

import java.util.stream.IntStream;

public class Problem039 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem039().run());
    }

    @Override
    public String run() {
        int result = maxIntegerRightTrianglesCount(1000);
        return Integer.toString(result);
    }

    private int maxIntegerRightTrianglesCount(int perimeterLimit) {
        long solutions = 0;
        int perimeterMax = 0;
        for (int i = 1; i <= perimeterLimit; i++) {
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
