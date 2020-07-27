package problems;

import runner.ProjectEulerCallable;

public class Problem017 implements ProjectEulerCallable {

    private static final String[] ONES = new String[] {"", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"};
    private static final String[] TENS = new String[] {"twenty", "thirty", "forty", "fifty", "sixty", "seventy",
            "eighty", "ninety"};

    public static void main(String[] args) {
        System.out.println(new Problem017().call());
    }

    @Override
    public String call() {
        int result = numberLetterCountsToOneThousand();
        printCallableThread();
        return Integer.toString(result);
    }

    private int numberLetterCountsToOneThousand() {
        int total = 0;
        String nextValue;
        for (int i = 1; i < 20; i++) {
            total += ONES[i].length();
        }
        for (int i = 20; i < 100; i++) {
            nextValue = TENS[i / 10 - 2] + ((i % 10 == 0) ? "" : ONES[i % 10]);
            total += nextValue.length();
        }
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 100; j++) {
                nextValue = ONES[i] + "hundred";
                if (j == 0) {
                    // do nothing
                } else if (j < 20) {
                    nextValue += "and" + ONES[j];
                } else {
                    nextValue += "and" + TENS[j / 10 - 2] + ((j % 10 == 0) ? "" : ONES[j % 10]);
                }
                total += nextValue.length();
            }
        }
        total += "onethousand".length();
        return total;
    }
}
