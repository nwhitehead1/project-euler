package problems;

import lib.Library;
import runner.ProjectEulerRunner;

public class Problem032 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem032().run());
    }

    @Override
    public String run() {
        int result = pandigitalProducts();
        return Integer.toString(result);
    }

    /*
        Thoughts:
            1) The multiplier, multiplicand, product lengths must equal 9
            2) multiplication is commutative - collect products in a Set, sum result
            let 9999 be an upper bound, since any 5 digit number multiplied by 1 is 5 digits, which combine to > 9
            Thus a candidate product has at most 4 digits
     */
    private int pandigitalProducts() {
        int sum = 0;
        for (int i = 1; i < 10000; i++) {
            if (productIsPandigital(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private boolean productIsPandigital(int prod) {
        for (int i = 1; i <= prod; i++) {
            if (prod % i == 0 && Library.isPandigital("" + prod + i + prod / i, 1, 9)) {
                return true;
            }
        }
        return false;
    }
}