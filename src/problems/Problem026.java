package problems;

import runner.ProjectEulerRunner;

import java.util.ArrayList;
import java.util.List;

public class Problem026 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem026().run());
    }

    @Override
    public String run() {
        List<Integer> result = fractionToDecimalList(1, 4, new ArrayList<>());
        return "";
    }

    /*
        Idea: Find the remainder of the division, multiply by 10 to shift digits and divide by the denominator again.
        Repeat until remainder is 0, or if previous remainders repeat.

        denominator DOES NOT CHANGE. Numerator becomes the previous iterations remainder
     */
    private List<Integer> fractionToDecimalList(int num, int denom, List<Integer> result) {
        // Calculate the remainder
        int rem = (10 * (num % denom)) / denom;

        // If remainder is 0 then there will be no future decimal parts
        if (rem == 0) {
            return result;
        }

        // If the calculated remainder equals a previously added remainder then we should stop
        if (!result.isEmpty()) {
            if (result.get(result.size() - 1) == rem) {
                return result;
            }
        }

        // Add the calculated remainder to the existing result list
        result.add(rem);

        // The new numerator will be the remainder of the last division multiplied by 10.
        return fractionToDecimalList(rem, denom, result);
    }
}
