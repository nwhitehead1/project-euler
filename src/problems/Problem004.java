package problems;


import lib.Library;
import runner.ProjectEulerRunner;

public class Problem004 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem004().run());
    }

    @Override
    public String run() {
        int result = largestPalindromeThreeDigitProduct();
        return Integer.toString(result);
    }

    private int largestPalindromeThreeDigitProduct() {
        int largestPalindromeMult = 0;
        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {
                int value = i * j;
                if (Library.palindrome(value) && value > largestPalindromeMult) {
                    largestPalindromeMult = value;
                }
            }
        }
        return largestPalindromeMult;
    }
}
