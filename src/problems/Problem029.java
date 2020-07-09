package problems;

import runner.ProjectEulerRunner;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Problem029 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem029().run());
    }

    @Override
    public String run() {
        return String.valueOf(distinctPowers(2, 100));
    }

    /*
        a^b, where lower <= a,b <= upper
     */
    public int distinctPowers(int lower, int upper) {
        // Brute force solution... maybe revisit and do something clever to make complexity better than O(n^2)
        Set<Double> powerSet = new HashSet<>();
        for (int a = lower; a <= upper; a++) {
            for (int b = lower; b <= upper; b++) {
                powerSet.add(Math.pow(a, b));
            }
        }
        return powerSet.size();
    }
}
