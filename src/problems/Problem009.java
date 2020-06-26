package problems;

import runner.ProjectEulerRunner;

public class Problem009 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem009().run());
    }

    @Override
    public String run() {
        return String.valueOf(findTriple());
    }

    private int findTriple() {
        for (int i = 1; i < 333; i++) {
            for (int j = i + 1; j < 666; j++) {
                for (int k = j + 1; k < 1000; k++) {
                    if (isPythagoreanTriple(i, j, k) && i + j + k == 1000) {
                        return i * j * k;
                    }
                }
            }
        }
        return 0;
    }

    private boolean isPythagoreanTriple(int a, int b, int c) {
		return a * a + b * b == c * c;
    }
}
