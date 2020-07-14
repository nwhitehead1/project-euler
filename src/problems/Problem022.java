package problems;

import lib.helpers.AdditionHelper;
import lib.helpers.FileHelper;
import runner.ProjectEulerRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem022 implements ProjectEulerRunner {

    private static final String FILE_PATH = "/files/p022_names.txt";

    public static void main(String[] args) {
        System.out.println(new Problem022().run());
    }

    @Override
    public String run() {
        String result = namesScores();
        return result;
    }

    private String namesScores() {
        FileHelper fileReader = new FileHelper();
        String fileString = "";
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
        for (int i = 0; i < charArr.length; i++) {
            stringTotal += charArr[i] - 64;
        }
        return stringTotal * index;
    }
}
