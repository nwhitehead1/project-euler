package problems;


import runner.ProjectEulerCallable;

public class Problem045 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem045().call());
    }

    @Override
    public String call() {
        long test = nextHexagonalNumber();
        printCallableThread();
        return Long.toString(test);
    }

    /*
        Thoughts:
            (From Wikipedia reading about these sequences)
            We already know how to check if a number is pentagonal, so we find a relationship between trianglular
                and hexagonal numbers.
            From Wikipedia (https://en.wikipedia.org/wiki/Polygonal_number#Every_hexagonal_number_is_also_a_triangular_number)
            It follows every Hexagonal number is an odd numbered triangular number.
            Using the logic from Problem 44, we can check if odd triangular numbers are also pentagonal.
     */
    private long nextHexagonalNumber() {
        long result;
        int i = 143;
        do {
            i++;
            result = i * (2 * i - 1);
        } while (!isPentagonal(result));
        return result;
    }

    private boolean isPentagonal(long n) {
        double test = (Math.sqrt(1 + 24 * n) + 1.0) / 6.0;
        return test == ((long) test);
    }
}
