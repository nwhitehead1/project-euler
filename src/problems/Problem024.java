package problems;

import lib.Library;
import runner.ProjectEulerCallable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem024 implements ProjectEulerCallable {

    private static final int LIMIT = 1000000;

    public static void main(String[] args) {
        System.out.println(new Problem024().call());
    }

    @Override
    public String call() {
        String result = lexicographicPermutations(IntStream.rangeClosed(0, 9).boxed().collect(Collectors.toList()));
        printCallableThread();
        return result;
    }

    private String lexicographicPermutations(List<Integer> inputElements) {
        List<Integer> factoradicRepresentation = Library.factoradicRepresentation(LIMIT);
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            int value = factoradicRepresentation.get(0);
            result.append(inputElements.get(value));
            inputElements.remove(value);
            factoradicRepresentation.remove(0);
        }
        return result.append(inputElements.get(0)).toString();
    }
}
