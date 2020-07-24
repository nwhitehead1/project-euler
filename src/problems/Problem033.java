package problems;

import lib.Library;
import lib.models.Fraction;
import runner.ProjectEulerRunner;

import java.util.ArrayList;
import java.util.List;

public class Problem033 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem033().run());
    }

    @Override
    public String run() {
        int result = digitCancellingFractions();
        return Integer.toString(result);
    }

    /*
        Thoughts:
            Skip trivial examples
            If both num/denom contain 1...9, remove that digit and check equivalence
            fractions must be less than 1 in value, so denom > num
     */
    private int digitCancellingFractions() {
        List<Fraction> nonTrivialExamples = new ArrayList<>();

        for (int n = 10; n < 100; n++) {
            if (n % 10 == 0) {
                continue;
            }
            for (int d = n + 1; d < 100; d++) {
                if (d % 10 == 0) {
                    continue;
                }
                Fraction frac = new Fraction(n, d);
                List<Fraction> candidates = digitCancellingCandidates(frac);
                for (Fraction f : candidates) {
                    if (areEquivalentFractions(f, frac)) {
                        nonTrivialExamples.add(f);
                    }
                }
            }
        }

        Fraction result = multiplyFractions(nonTrivialExamples);

        return result.getDenominator();
    }

    /*
        Thoughts:
            Check if fraction num/denom both contains 1...9, remove it
     */
    private List<Fraction> digitCancellingCandidates(Fraction fraction) {
        List<Fraction> candidates = new ArrayList<>();
        String numStr = Integer.toString(fraction.getNumerator());
        String denomStr = Integer.toString(fraction.getDenominator());
        for (int i = 1; i < 10; i++) {
            if (numStr.contains(Integer.toString(i)) && denomStr.contains(Integer.toString(i))) {
                candidates.add(new Fraction(Integer.parseInt(numStr.replaceFirst(Integer.toString(i), "")), Integer.parseInt(denomStr.replaceFirst(Integer.toString(i), ""))));
            }
        }
        return candidates;
    }

    /*
        Thoughts:
            Fractions are equivalent in the following way:
            a/b = c/d <=> a*d = c*b
     */
    private boolean areEquivalentFractions(Fraction a, Fraction b) {
        return a.getNumerator() * b.getDenominator() == b.getNumerator() * a.getDenominator();
    }

    private Fraction multiplyFractions(List<Fraction> fractions) {
        int denom = fractions.stream().map(Fraction::getDenominator).reduce(1, (a, b) -> a * b);
        int num = fractions.stream().map(Fraction::getNumerator).reduce(1, (a, b) -> a * b);
        int greatestCommonDivisor = Library.gcd(num, denom);
        return new Fraction(num / greatestCommonDivisor, denom / greatestCommonDivisor);
    }

}

