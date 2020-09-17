package problems;

import lib.arithmetic.Adder;
import lib.arithmetic.Multiplier;
import runner.ProjectEulerCallable;

public class Problem048 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem048().call());
    }

    @Override
    public String call() {
        String result = selfPowers();
        return result;
    }

    /*
        Thoughts:
            Use String-based addition to multiply powers.
            1^1 = 1
            2^2 = (2*2)
            3^3 = (3*3)*3, (9*3)
            4^4 = (4*4)*4*4, (16*4)*4, (64*4)
            ...
            Only need to consider last 10 digits of any given addition. For any result + power string just add the last
            10 digits.

            NOT MY IDEA:
                Since we only need the last 10 digits of any addition or multiplication, take advantage of:
                1. (a*b) % c = ((a % c) * (b % c) )% c
                2. (a+b) % c = ((a % c) + (b % c) )% c
                Where c is 10000000000.
                Since we are using Strings, just take the last 10 string values
     */
    private String selfPowers() {
        Multiplier multiplier = new Multiplier();
        Adder adder = new Adder();
        String result = "0";

        for (int p = 1; p <= 10; p++) {
            String power = Integer.toString(p);
            String tempPowerResult = power;
            for (int i = 1; i < p; i++) {
                // power*power*...*power, i times.
                tempPowerResult = multiplier.multiply(tempPowerResult, power);
                if (tempPowerResult.length() > 10) {
                    tempPowerResult.substring(tempPowerResult.length() - 10);
                }
            }
            result = adder.add(result, tempPowerResult);
            if (result.length() > 10) {
                result = result.substring(result.length() - 10);
            }
        }
        return result;
    }
}
