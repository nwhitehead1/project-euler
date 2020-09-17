package problems;

import lib.Library;
import lib.arithmetic.Adder;
import runner.ProjectEulerCallable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem043 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem043().call());
    }

    @Override
    public String call() {
        String result = subStringDivisibility();
        printCallableThread();
        return result;
    }

    private String subStringDivisibility() {
        LinkedList<Integer> primeDivisors = new LinkedList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17));
        Collections.reverse(primeDivisors);

        // 3 digit numbers divisible by 17
        List<String> candidatePandigitals = IntStream.range(1, 1000)
                .boxed()
                .filter(i -> i % primeDivisors.getFirst() == 0)
                .map(String::valueOf)
                .map(str -> {
                    if (str.length() < 3) {
                        return "0" + str;
                    }
                    return str;
                })
                .collect(Collectors.toList());
        primeDivisors.pop();

        while (!primeDivisors.isEmpty()) {
            candidatePandigitals = nextDivisible(primeDivisors.getFirst(), candidatePandigitals);
            primeDivisors.pop();
        }

        List<String> candidateCheck = new ArrayList<>();
        for (String s : candidatePandigitals) {
            s = Arrays.stream(s.split(""))
                    .distinct()
                    .collect(Collectors.joining());
            candidateCheck.add(s);
        }

        // TODO: Revisit later, not the right way to do this
        candidateCheck = candidateCheck.stream().filter(num -> num.length() == 9).collect(Collectors.toList());

        // Since remaining are potential 0-9 pandigitals with our special property, just need to find the missing digit.
        // Missing digit is a_k, then Sum(1...9) - Sum(1...a_k...9) where a_k is missing is a_k
        int fullSum = Library.increasingSum(9);
        for (int i = 0; i < candidateCheck.size(); i++) {
            String temp = candidateCheck.get(i);
            int stringSum = Arrays.stream(temp.split("")).mapToInt(Integer::parseInt).sum();
            candidateCheck.set(i, "" + (fullSum - stringSum) + temp);
        }

        return candidateCheck.stream()
                .reduce("0", (a, b) -> new Adder(a, b).addTwoNumbers());
    }

    /*
        Thoughts:
            Extract first two digits of the previous set of values
            Prepend a new value (1-9) to make the 3-digit integer divisible by the new divisor
     */
    private List<String> nextDivisible(int divisibleBy, List<String> values) {
        List<String> candidates = new ArrayList<>();
        for (String value : values) {
            String sub = value.substring(0, 2);
            for (int i = 0; i < 10; i++) {
                int v = Integer.parseInt("" + i + sub);
                if (v == 0) {
                    continue;
                }
                if (v % divisibleBy == 0) {
                    candidates.add("" + i + value);
                }
            }
        }
        return candidates;
    }
}
