package problems;

import runner.ProjectEulerRunner;

import java.util.HashSet;
import java.util.Set;

public class Problem029 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem029().run());
    }

    @Override
    public String run() {
        int result = distinctPowers(2, 100);
        return Integer.toString(result);
    }

    /*
        Thoughts:
            a^b, where lower <= a,b <= upper
            Brute force the solution... maybe revisit and do something clever to make complexity better than O(n^2)
     */
    private int distinctPowers(int lower, int upper) {
        Set<Double> powerSet = new HashSet<>();
        for (int a = lower; a <= upper; a++) {
            for (int b = lower; b <= upper; b++) {
                powerSet.add(Math.pow(a, b));
            }
        }
        return powerSet.size();
    }
}
