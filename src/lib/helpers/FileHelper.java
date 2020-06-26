package lib.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class FileHelper {

	public String readFile(String path) {
		try (InputStream stream = FileHelper.class.getResourceAsStream(path)) {
			return new BufferedReader(new InputStreamReader(stream)).lines().collect(Collectors.joining("\n"));
		} catch (IOException | NullPointerException e) {
			System.err.println("Exception caught: " + e);
		}
		return null;
	}
}
