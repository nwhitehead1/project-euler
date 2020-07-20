package lib;

import lib.models.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class Library {

    /**
     * @param n
     * @return sum from 1^2 to n^2
     */
    public static int sumOfSquares(int n) {
        return (n * (n + 1) * (2 * n + 1)) / 6;
    }

    /**
     * @param n
     * @return sum from 1 to n
     */
    public static int increasingSum(int n) {
        return (n * (n + 1)) / 2;
    }

    /**
     * @param n
     * @return if true - prime, else not prime
     */
    public static boolean isPrime(int n) {
        return (n > 1) && IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(num -> n % num == 0);
    }

    /**
     * @param n integer
     * @return true if a palindrome, false otherwise
     */
    public static boolean palindrome(int n) {
        ArrayList<Integer> intArr = new ArrayList<>();
        while (n >= 10) {
            intArr.add(n % 10);
            n /= 10;
        }
        intArr.add(n);

        for (int i = 0; i < intArr.size(); i++) {
            if (intArr.get(i) != intArr.get(intArr.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param n
     * @return reversed value of input string
     */
    public static String reverseString(String n) {
        char[] k = n.toCharArray();
        for (int i = 0; i < k.length / 2; i++) {
            char temp = k[i];
            k[i] = k[k.length - i - 1];
            k[k.length - i - 1] = temp;
        }
        return String.valueOf(k);
    }

    public static int reverseInt(int n) {
        int reversed = 0;
        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        return reversed;
    }

    /**
     * @param root
     * @return longest path from root to leaf
     */
    public static Integer getHeaviestPath(Node root) {
        if (root == null) {
            return 0;
        } else {
            return root.getWeight() + Math.max(getHeaviestPath(root.getLeft()), getHeaviestPath(root.getRight()));
        }
    }

    /**
     * @param n
     * @return sum of the proper divisors of n (O(sqrt(n) time)
     */
    public static int sumOfProperDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= (Math.sqrt(n)); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    sum += i;
                } else {
                    sum += i;
                    sum += (n / i);
                }

            }
        }
        return sum - n;
    }

    /**
     * @param n
     * @return number of proper divisors of n
     */
    public static int numberOfDivisors(int n) {
        int numberOfDivisors = 0;
        for (int i = 1; i <= (Math.sqrt(n)); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    // only choose one proper divisor
                    numberOfDivisors++;
                } else {
                    // choose both proper divisors, ie. divisors(100) => i=2, n/i=50 both divisors.
                    numberOfDivisors += 2;
                }
            }
        }
        return numberOfDivisors;
    }

    /**
     * @param k
     * @return factoradic representation of a number k. k = q(n!) + r
     */
    public static List<Integer> factoradicRepresentation(int k) {
        List<Integer> factoradics = new ArrayList<>();
        int index, n, q, r;
        while (k > 2) {
            for (int i = 1; ; i++) {
                if (factorial(i) > k) {
                    index = i - 1;
                    break;
                }
            }
            n = factorial(index);
            q = (k % n == 0) ? k / n - 1 : k / n;
            r = k - q * n;
            factoradics.add(q);
            k = r;
        }
        factoradics.add(1);
        return factoradics;
    }

    /**
     * @param n (integer)
     * @return n!, for small n
     */
    public static int factorial(int n) {
        if (n < 2) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * Euclidean method for finding the greatest common denominator
     *
     * @param a first value > b
     * @param b second value
     * @return greatest common denominator
     */
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}