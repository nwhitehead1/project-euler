package problems;

import runner.ProjectEulerRunner;

import java.util.HashMap;
import java.util.Map;

public class Problem026 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem026().run());
    }

    @Override
    public String run() {
        int result = reciprocalCycles(1000);
        return Integer.toString(result);
    }

    private int reciprocalCycles(int limit) {
        int longest = 0, next = 0, result = 0;
        for (int i = 2; i < 1000; i++) {
            next = getLongestCycle(i);
            if (next > longest) {
                longest = next;
                result = i;
            }
        }
        return result;
    }

    /*
        Thoughts:
            If we see the same remainder in our calculation then we know a cycle must exist
     */
    private int getLongestCycle(int denominator) {
        Map<Integer, Integer> results = new HashMap<>();
        int remainder = 1;
        int iteration = 0;
        while (!results.containsValue(remainder)) {
            results.put(iteration, remainder);
            remainder = (10 * remainder) % denominator;
            if (remainder == 0) {
                iteration = 0;
                break;
            }
            iteration++;
        }
        return iteration;
    }
}
