package problems;

import runner.ProjectEulerCallable;

import java.util.ArrayList;
import java.util.List;

public class Problem030 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem030().call());
    }

    @Override
    public String call() {
        int result = digitFifthPowers();
        System.out.println("Executing " + this.getClass().getSimpleName() + " -> Thread: " + Thread.currentThread().getName());
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
