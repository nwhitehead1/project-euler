package problems;

import lib.Library;
import runner.ProjectEulerRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem023 implements ProjectEulerRunner {

	private static final int LIMIT = 28123;

	public static void main(String[] args) {
		System.out.println(new Problem023().run());
	}

	@Override
	public String run() {
		List<Integer> abundantNumbers = new ArrayList<>();
		for (int i = 1; i < LIMIT; i++) {
			if (Library.sumOfProperDivisors(i) > i) {
				abundantNumbers.add(i);
			}
		}

		int total = (int) Library.increasingSum(LIMIT);
		Set<Integer> abundantSet = new HashSet<>();
		int abundantTotal = 0;
		for (int i = 0; i < abundantNumbers.size(); i++) {
			for (int j = i; j < abundantNumbers.size(); j++) {
				int value = abundantNumbers.get(i) + abundantNumbers.get(j);
				if (value <= LIMIT) {
					abundantSet.add(value);
				} else {
					break;
				}
			}
		}

		for (Integer i : abundantSet) {
			abundantTotal += i;
		}

		return String.valueOf(total - abundantTotal);
	}
}
