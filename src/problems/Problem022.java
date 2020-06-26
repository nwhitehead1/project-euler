package problems;

import lib.helpers.AdditionHelper;
import lib.helpers.FileHelper;
import runner.ProjectEulerRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem022 implements ProjectEulerRunner {

	private static final String FILE_PATH = "/net/projecteuler/files/p022_names.txt";

	@Override
	public String run() {
		FileHelper fileReader = new FileHelper();
		String fileString = "";
		String nameScoreTotal = "0";
		List<String> cleanFileArray = new ArrayList<>();
		fileString = fileReader.readFile(FILE_PATH);
		cleanFileArray = Arrays.asList(fileString.replace("\"", "").split(","));
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

	public static void main(String[] args) {
		System.out.println(new Problem022().run());
	}
}
