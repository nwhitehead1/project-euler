package problems;

import lib.helpers.AdditionHelper;
import runner.ProjectEulerCallable;

public class Problem016 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem016().call());
    }

    @Override
    public String call() {
        int result = powerDigitSum("2", 1000, new AdditionHelper());
        printCallableThread();
        return Integer.toString(result);
    }

    /*
        Thoughts:
            Multiplication of 2*n is the same as adding 2, n times
            2^1 = 2, first iteration
            2^2 = 2*2 = 2+2, second iteration
            2^3 = 2*(2*2) = (2+2)+(2+2), third iteration
            ...

            Add the previous result to itself (equivalent to multiplying by 2), decrement iteration

     */
    private int powerDigitSum(String sum, int iteration, AdditionHelper helper) {
        if (iteration < 2) {
            return sum.chars().map(Character::getNumericValue).sum();
        }
        helper.setFirst(sum);
        helper.setSecond(sum);
        return powerDigitSum(helper.addTwoNumbers(), iteration - 1, helper);
    }
}
