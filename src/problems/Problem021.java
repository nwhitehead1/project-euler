package problems;

import runner.ProjectEulerRunner;

public class Problem021 implements ProjectEulerRunner {

	public static void main(String[] args) {
		System.out.println(new Problem021().run());
	}

	@Override
	public String run() {
		int sumOfAmicableNumbers = 0;
		for (int i=1; i<10000; i++)  {
			if (isAmicablePair(i, sumOfProperDivisors(i)))  {
				sumOfAmicableNumbers += i;
			}
		}
		return String.valueOf(sumOfAmicableNumbers);
	}

	private boolean isAmicablePair(int value, int valuesSumOfProperDivisors)  {
		if (value == valuesSumOfProperDivisors)  {
			return false;
		} else  {
			int x = sumOfProperDivisors(valuesSumOfProperDivisors);
			if (x == value)  {
				return true;
			} else  {
				return false;
			}
		}
	}

	private int sumOfProperDivisors(int value)  {
		int sum = 1;
		for (int i=2; i<=value/2; i++)  {
			if (value%i == 0)  {
				sum += i;
			}
		}
		return sum;
	}
}