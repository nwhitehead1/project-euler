package problems;

import lib.Library;
import runner.ProjectEulerRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem023 implements ProjectEulerRunner {

    private static final int LIMIT = 28123;

    public static void main(String[] args) {
        System.out.println(new Problem023().run());
    }

    @Override
    public String run() {
        int result = nonAbundantSums();
        return Integer.toString(result);
    }

    /*
        Thoughts:
            If the sum of proper divisors exceeds the value it is abundant
            Collect abundant numbers, and find the sum of each abundant number to another (O(n^2))
            Find abundant sums list buy summing first number with others then dropping that number and repeating
            Find numbers not in set under the limit of 28123
     */
    private int nonAbundantSums() {
        List<Integer> abundantNumbers = IntStream.rangeClosed(1, LIMIT)
                .boxed()
                .parallel()
                .filter(num -> Library.sumOfProperDivisors(num) > num)
                .collect(Collectors.toList());

        Set<Integer> abundantSet = new HashSet<>();
        for (int i = 0; i < abundantNumbers.size(); i++) {
            for (int j = i; j < abundantNumbers.size(); j++) {
                int value = abundantNumbers.get(i) + abundantNumbers.get(j);
                if (value <= LIMIT) {
                    abundantSet.add(value);
                } else {
                    break;
                }
            }
        }

        int abundantSum = abundantSet.stream().mapToInt(Integer::intValue).sum();
        int total = Library.increasingSum(LIMIT);
        return total - abundantSum;
    }
}
