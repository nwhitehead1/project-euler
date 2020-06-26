package problems;

import lib.helpers.AdditionHelper;
import runner.ProjectEulerRunner;

public class Problem025 implements ProjectEulerRunner {

	public static void main(String[] args) {
		System.out.println(new Problem025().run());
	}

	@Override
	public String run() {
		String result = "";
		result = String.valueOf(fibonacci("1", "1") + 1);
		return result;
	}

	private int fibonacci(String first, String second) {
		if (first.length() == 1000) {
			return 0;
		}
		return 1 + fibonacci(second, new AdditionHelper(second, first).addTwoNumbers());
	}
}
