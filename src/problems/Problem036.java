package problems;

import lib.Library;
import runner.ProjectEulerCallable;

import java.util.stream.IntStream;

public class Problem036 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem036().call());
    }

    @Override
    public String call() {
        int result = doubleBasePalindromes();
        printCallableThread();
        return Integer.toString(result);
    }

    private int doubleBasePalindromes() {
        return IntStream.rangeClosed(0, 1000000)
                .boxed()
                .filter(Library::palindrome)
                .filter(d -> palindrome(getBinaryString(d)))
                .reduce(0, Integer::sum);
    }

    // TODO: Could be library method? Make it cleaner to deal with more cases.
    private boolean palindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return palindrome(s.substring(1, s.length() - 1));
        } else {
            return false;
        }
    }

    private String getBinaryString(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        int nextQuotient = n;
        while (nextQuotient > 0) {
            int remainder = nextQuotient % 2;
            builder.append(remainder);
            nextQuotient /= 2;
        }
        return builder.reverse().toString();
    }
}
