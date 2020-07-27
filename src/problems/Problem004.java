package problems;


import lib.Library;
import runner.ProjectEulerCallable;

public class Problem004 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem004().call());
    }

    @Override
    public String call() {
        int result = largestPalindromeThreeDigitProduct();
        System.out.println("Executing " + this.getClass().getSimpleName() + " -> Thread: " + Thread.currentThread().getName());
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
