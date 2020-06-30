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
        int longest = 0, next = 0, result = 0;
        for (int i = 2; i < 1000; i++)  {
            next = getLongestCycle(i);
            if (next > longest)  {
                longest = next;
                result = i;
            }
        }
        return Integer.toString(result);
    }

    /*
        Get the longest cycle in the unit fraction 1/denom

        Idea: If we see the same remainder in our calculation then we know a cycle must exist
     */
    private int getLongestCycle(int denominator) {
        // Map to store <iteration, remainder>
        Map<Integer, Integer> results = new HashMap<>();
        // First remainder
        int remainder = 1;
        int iteration = 0;
        while (!results.containsValue(remainder))  {
            results.put(iteration, remainder);
            // Find the remainder in the next decimal place
            remainder = (10 * remainder) % denominator;
            if (remainder == 0)  {
                iteration = 0;
                break;
            }
            iteration++;
        }
        return iteration;
    }
}
