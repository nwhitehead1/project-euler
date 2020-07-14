package problems;

import runner.ProjectEulerRunner;

import java.util.ArrayList;
import java.util.List;

public class Problem030 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem030().run());
    }

    @Override
    public String run() {
        int result = digitFifthPowers();
        return Integer.toString(result);
    }

    /*
        Thoughts:
            Establish (estimated) upper bound -> x*9^5 giving an x digit number.
            x=5 gives a 6 digit number
            x=6 gives a 6 digit number
                ...
            x=16 gives a 6 digit number
            We can see as x gets very large (number of digits) the result does not get large. We can then create
            a reasonable upper bound above 6*9^5 = 354294 ~ 355000
     */
    private int digitFifthPowers() {
        int result = 0;
        List<Integer> arr = new ArrayList<>();
        for (int i = 2; i < 355000; i++) {
            int temp = i;
            do {
                arr.add(temp % 10);
                temp /= 10;
            } while (temp > 0);
            if (fifthPowerSum(arr) == i) {
                result += i;
            }
            arr.clear();
        }
        return result;
    }

    private int fifthPowerSum(List<Integer> arr) {
        return arr.stream().mapToInt(i -> (int) Math.pow(i, 5)).sum();
    }

}
