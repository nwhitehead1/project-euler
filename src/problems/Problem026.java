package problems;

import runner.ProjectEulerCallable;

import java.util.HashMap;
import java.util.Map;

public class Problem026 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem026().call());
    }

    @Override
    public String call() {
        int result = reciprocalCycles();
        System.out.println("Executing " + this.getClass().getSimpleName() + " -> Thread: " + Thread.currentThread().getName());
        return Integer.toString(result);
    }

    private int reciprocalCycles() {
        int longest = 0, next, result = 0;
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
