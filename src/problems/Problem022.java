package problems;

import lib.helpers.AdditionHelper;
import lib.helpers.FileHelper;
import runner.ProjectEulerCallable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem022 implements ProjectEulerCallable {

    private static final String FILE_PATH = "/files/p022_names.txt";

    public static void main(String[] args) {
        System.out.println(new Problem022().call());
    }

    @Override
    public String call() {
        String result = namesScores();
        System.out.println("Executing " + this.getClass().getSimpleName() + " -> Thread: " + Thread.currentThread().getName());
        return result;
    }

    private String namesScores() {
        FileHelper fileReader = new FileHelper();
        String fileString;
        String nameScoreTotal = "0";
        fileString = fileReader.readFile(FILE_PATH);
        List<String> cleanFileArray = Arrays.asList(fileString.replace("\"", "").split(","));
        Collections.sort(cleanFileArray);

        AdditionHelper addition = new AdditionHelper();
        for (int i = 0; i < cleanFileArray.size(); i++) {
            addition.setFirst(nameScoreTotal);
            addition.setSecond(String.valueOf(getAlphabeticalValue(cleanFileArray.get(i), i + 1)));
            nameScoreTotal = addition.addTwoNumbers();
        }
        return nameScoreTotal;
    }

    private int getAlphabeticalValue(String n, int index) {
        int stringTotal = 0;
        char[] charArr = n.toCharArray();
        for (char c : charArr) {
            stringTotal += c - 64;
        }
        return stringTotal * index;
    }
}
