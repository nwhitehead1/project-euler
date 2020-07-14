package problems;

import lib.Library;
import lib.helpers.AdditionHelper;
import runner.ProjectEulerRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem010 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem010().run());
    }

    @Override
    public String run() {
        String result = summationOfPrimes(2000000);
        return result;
    }

    private String summationOfPrimes(int limit) {
        AdditionHelper helper = new AdditionHelper();
        String sum = "";
        List<Integer> primes = IntStream.rangeClosed(2, limit).boxed().parallel()
                .filter(num -> Library.isPrime(num)).collect(Collectors.toList());
        helper.setFirst(Integer.toString(primes.get(0)));
        for (int i = 1; i < primes.size(); i++) {
            helper.setSecond(Integer.toString(primes.get(i)));
            sum = helper.addTwoNumbers();
            helper.setFirst(sum);
        }
        return sum;
    }
}
