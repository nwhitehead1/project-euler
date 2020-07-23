package problems;

import lib.helpers.FileHelper;
import runner.ProjectEulerRunner;

import java.util.Arrays;
import java.util.List;

public class Problem042 implements ProjectEulerRunner {

    private static final String FILE_PATH = "/files/p042_words.txt";

    public static void main(String[] args) {
        System.out.println(new Problem042().run());
    }

    @Override
    public String run() {
        int result = countTriangleWords(new FileHelper().readFile(FILE_PATH));
        return Integer.toString(result);
    }

    private int countTriangleWords(String file) {
        List<String> words = Arrays.asList(file.replace("\"", "").split(","));
        int count = 0;
        for (String word : words) {
            if (isTriangleWord(word)) {
                count++;
            }
        }
        return count;
    }

    /*
        Thoughts:
            Find alphabetical word value, equate it to t_n.
            Calculate sequential triangle numbers until it is leq t_n
            if equal to t_n, return true else return false.
            Assumption made based on file all letters are capital, so we can perform character arithmetic.
     */
    private boolean isTriangleWord(String word) {
        int alphabeticalValue = 0;
        double triangleNumber = 1;
        char[] wordArray = word.toCharArray();
        for (Character character : wordArray) {
            alphabeticalValue += character - 64;
        }
        for (int n = 1; triangleNumber < alphabeticalValue; n++) {
            triangleNumber = (1.0 / 2.0) * n * (n + 1);
        }
        return triangleNumber == alphabeticalValue;
    }
}
