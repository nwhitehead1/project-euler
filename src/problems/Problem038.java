package problems;

import lib.Library;
import runner.ProjectEulerCallable;

public class Problem038 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem038().call());
    }

    @Override
    public String call() {
        String result = largestPandigitalMultiple();
        printCallableThread();
        return result;
    }

    /*
        Thoughts:
            First, since n >= 2 the fixed integer multiplier must have less than 5 digits.
            Second, Since the candidate example starts with a 9 (and we know it isn't the largest), the first digit
                must be a 9.
            Third, let the fixed integer multiple be x
                1. If x is 2 digits,
                    n=3 can at best be 99*1, 99*2, 99*3 = 8 digits
                    n=4 can at worst be 91*1, 91*2, 91*3, 91*4 = 11 digits
                2. If x is 3 digits,
                    n=2 can at best be 999*1, 999*2 = 7 digits
                    n=3 can at worst be 901*1, 901*2, 901*3 = 11 digits
                3. If x is 4 digits (only possible solution),
                    n=2 can at best be 9999*1, 9999*2 = 9 digits
            Fourth, we can further reduce the search space by considering 9123 and 9876 as the bounds for pandigital
            multiples
     */
    private String largestPandigitalMultiple() {
        String result = "";
        for (int i = 9876; i > 9123; i--) {
            String s = "" + i + (2 * i);
            if (Library.isPandigital(s, 1, 9)) {
                result = s;
                break;
            }
        }
        return result;
    }
}
