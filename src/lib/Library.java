package lib;

import lib.models.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Library {

    /**
     * @param n number
     * @return sum from 1^2 to n^2
     */
    public static int sumOfSquares(int n) {
        return (n * (n + 1) * (2 * n + 1)) / 6;
    }

    /**
     * @param n number
     * @return sum from 1 to n
     */
    public static int increasingSum(int n) {
        return (n * (n + 1)) / 2;
    }

    /**
     * @param n number
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
            if (!intArr.get(i).equals(intArr.get(intArr.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param n string
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
     * @param root Node object
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
     * @param n number
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
     * @param n number
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
     * @param k check factoradic candidate
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

    /**
     * Check if a string is pandigital (ie. contains digits 1-9)
     *
     * @param s     value to check
     * @param start start...end pandigital number
     * @param end   start...end pandigital number
     * @return true if pandigital, false otherwise
     */
    public static boolean isPandigital(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.length() != (end - start + 1)) {
            return false;
        }
        char[] c = s.toCharArray();
        Arrays.sort(c);
        String sortedCheck = IntStream.rangeClosed(start, end).boxed().sorted().map(String::valueOf).collect(Collectors.joining());
        return new String(c).equals(sortedCheck);
    }

    /**
     * Based on Wikipedia definition for verifying pandigital digits efficiently
     *
     * @param n value to check
     * @return true if pandigital, false otherwise
     */
    public static boolean isPandigital(int n) {
        int digits = 0;
        int count = 0;
        for (; n > 0; n /= 10, ++count) {
            if (digits == (digits |= 1 << (n - ((n / 10) * 10) - 1)))
                return false;
        }
        return digits == (1 << count) - 1;
    }

    /**
     * Iterative algorithm for generating permutations. Insert nth element into (n-1)! remaining permutations
     *
     * @param array to permutate
     * @param n     permutation size, remaining elements (array.size())
     * @return permutations of array in O(n!)
     */
    public static List<List<Integer>> permutations(List<Integer> array, int n) {
        List<List<Integer>> generated = new ArrayList<>();
        if (n == 1) {
            List<Integer> permutation = new ArrayList<>();
            permutation.add(array.get(n - 1));
            generated.add(permutation);
        } else {
            for (List<Integer> permutation : permutations(array, n - 1)) {
                for (int i = 0; i <= permutation.size(); i++) {
                    ArrayList<Integer> new_permutation = new ArrayList<>(permutation);
                    new_permutation.add(i, array.get(n - 1));
                    generated.add(new_permutation);
                }
            }
        }
        return generated;
    }
}