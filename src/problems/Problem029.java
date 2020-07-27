package problems;

import runner.ProjectEulerCallable;

import java.util.HashSet;
import java.util.Set;

public class Problem029 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem029().call());
    }

    @Override
    public String call() {
        int result = distinctPowers(2);
        printCallableThread();
        return Integer.toString(result);
    }

    /*
        Thoughts:
            a^b, where lower <= a,b <= upper
            Brute force the solution... maybe revisit and do something clever to make complexity better than O(n^2)
     */
    private int distinctPowers(int lower) {
        Set<Double> powerSet = new HashSet<>();
        for (int a = lower; a <= 100; a++) {
            for (int b = lower; b <= 100; b++) {
                powerSet.add(Math.pow(a, b));
            }
        }
        return powerSet.size();
    }
}
