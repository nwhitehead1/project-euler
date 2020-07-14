package lib.helpers;

import lib.Library;

import java.util.regex.Pattern;


/**
 * Class for addition, and subtraction of very large numbers
 */
public class AdditionHelper {

    private String first;
    private String second;

    public AdditionHelper(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public AdditionHelper() {
    }

    /**
     * This is a monstrosity of ugliness. I will come back and clean this up later
     *
     * @return sum of the first and second values in the object
     */
    public String addTwoNumbers() {
        boolean firstNeg = false;
        boolean secondNeg = false;
        // Check for 0 is done when signs are XOR
        boolean firstLargerFlag = false;
        boolean resultSignNegative = false;

        String firstValue = this.first;
        String secondValue = this.second;
        int sum, next, carry = 0;
        String revSum = null, revNext = null;
        StringBuilder sumBuilder = new StringBuilder();

        // Check to see if the Strings are actually numbers
        Pattern pattern = Pattern.compile("^-?[0-9]+$");
        if (!pattern.matcher(firstValue).matches()) {
            System.err.println("First value is not a number!");
        }
        if (!pattern.matcher(secondValue).matches()) {
            System.err.println("Second value is not a number!");
        }

        // Flags for negative numbers
        if (first.charAt(0) == '-') {
            firstNeg = true;
            firstValue = firstValue.substring(1);
        }
        if (second.charAt(0) == '-') {
            secondNeg = true;
            secondValue = secondValue.substring(1);
        }

        // Reverses the two strings and pad the smaller value
        if (secondValue.length() > firstValue.length()) {
            revSum = Library.reverseString(secondValue);
            revNext = Library.reverseString(padSmallerValue(secondValue, firstValue));
        } else if (secondValue.length() < firstValue.length()) {
            revSum = Library.reverseString(firstValue);
            revNext = Library.reverseString(padSmallerValue(firstValue, secondValue));
            firstLargerFlag = true;
        } else {
            // Strings are the same length, so just see if the next significant character is larger
            for (int i = 0; i < firstValue.length(); i++) {
                if (firstValue.charAt(i) != secondValue.charAt(i)) {
                    firstLargerFlag =
                            Character.getNumericValue(firstValue.charAt(i)) > Character.getNumericValue(secondValue.charAt(i));
                }
            }
            // Using the check above, put the larger value in the reversed sum, smaller in reversed next
            if (firstLargerFlag) {
                revSum = Library.reverseString(firstValue);
                revNext = Library.reverseString(padSmallerValue(firstValue, secondValue));
            } else {
                revSum = Library.reverseString(secondValue);
                revNext = Library.reverseString(padSmallerValue(secondValue, firstValue));
            }
        }

        // Check to see negative values (if applicable)
        if (firstNeg ^ secondNeg) {
            // Immediate check if the values are the same, result is 0
            if (revSum.equals(revNext)) {
                return "0";
            }

            // Check if the result is going to be negative
            if ((firstLargerFlag && firstNeg) || !(firstLargerFlag || firstNeg)) {
                resultSignNegative = true;
            }

            for (int i = 0; i < revSum.length(); i++) {
                sum = Character.getNumericValue(revSum.charAt(i));
                next = Character.getNumericValue(revNext.charAt(i));
                int result = sum - next - carry;
                if (result < 0) {
                    result = result + 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                sumBuilder.append(result % 10);
            }
        } else {

            // Check if the result is going to be negative
            resultSignNegative = firstNeg;

            for (int i = 0; i < revSum.length(); i++) {
                sum = Character.getNumericValue(revSum.charAt(i));
                next = Character.getNumericValue(revNext.charAt(i));
                int result = sum + next + carry;
                if (result > 9) {
                    carry = result / 10;
                } else {
                    carry = 0;
                }
                sumBuilder.append(result % 10);
            }
        }
        String result = Library.reverseString(carry != 0 ? sumBuilder.append(carry).toString() : sumBuilder.toString()).replaceFirst("^0*(?!$)", "");
        return (resultSignNegative) ? "-" + result : result;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    private String padSmallerValue(String larger, String smaller) {
        StringBuilder zeros = new StringBuilder();
        for (int i = smaller.length(); i < larger.length(); i++) {
            zeros.append("0");
        }
        return zeros.append(smaller).toString();
    }
}
