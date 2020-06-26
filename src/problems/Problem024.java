package problems;

import lib.Library;
import runner.ProjectEulerRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem024 implements ProjectEulerRunner {

	private static final int LIMIT = 1000000;

	public static void main(String[] args) {
		System.out.println(new Problem024().run());
	}

	@Override
	public String run() {
		List<Integer> inputString = IntStream.rangeClosed(0, 9).boxed().collect(Collectors.toList());
		List<Integer> factoradicRep = Library.factoradicRepresentation(LIMIT);
		StringBuilder result = new StringBuilder();
		for (int i = 1; i < 10; i++) {
			int value = factoradicRep.get(0);
			result.append(inputString.get(value));
			inputString.remove(value);
			factoradicRep.remove(0);
		}

		return result.append(inputString.get(0)).toString();
	}
}
