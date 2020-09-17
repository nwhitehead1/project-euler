package problems;

import lib.Library;
import lib.arithmetic.Adder;
import runner.ProjectEulerCallable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem010 implements ProjectEulerCallable {

    public static void main(String[] args) {
        System.out.println(new Problem010().call());
    }

    @Override
    public String call() {
        String result = summationOfPrimes();
        printCallableThread();
        return result;
    }

    private String summationOfPrimes() {
        Adder adder = new Adder();
        String sum = "";
        List<Integer> primes = IntStream.rangeClosed(2, 2000000).boxed().parallel()
                .filter(Library::isPrime).collect(Collectors.toList());
        adder.setFirst(Integer.toString(primes.get(0)));
        for (int i = 1; i < primes.size(); i++) {
            adder.setSecond(Integer.toString(primes.get(i)));
            sum = adder.addTwoNumbers();
            adder.setFirst(sum);
        }
        return sum;
    }
}
