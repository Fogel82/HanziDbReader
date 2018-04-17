package ca.cam.hanzidbreader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class HanziDbReader {
	public static final String TONE_ONE_GROUP = ".*[āōĀŌēūĒŪīǖĪǕ].*";
	public static final String TONE_TWO_GROUP = ".*[áóÁÓéúÉÚíǘÍǗ].*";
	public static final String TONE_THREE_GROUP = ".*[ǎǒǍǑěǔĚǓǐǚǏǙ].*";
	public static final String TONE_FOUR_GROUP = ".*[àòÀÒèùÈÙìǜÌǛ].*";

	public static void main(String[] args) {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get("C:\\Temp\\hanzidbinput.txt"), Charset.forName("UTF-8"));
			
			for (String line : lines) {
				String[] splitsies = line.split("\\s+");
				
				if (splitsies.length >= 2) {
					System.out.println("Hanzi: "+splitsies[0]+" Pinyin: "+splitsies[1]);
					findToneInPinyin(splitsies[1]);
				}
				else {
					System.out.println("Got bad line: "+line);
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	private static void findToneInPinyin(String string) {
		if (string.matches(TONE_ONE_GROUP)) {
			System.out.println("Tone 1");
		}
		else if (string.matches(TONE_TWO_GROUP)) {
			System.out.println("Tone 2");
		}
		else if (string.matches(TONE_THREE_GROUP)) {
			System.out.println("Tone 3");
		}
		else if (string.matches(TONE_FOUR_GROUP)) {
			System.out.println("Tone 4");
		}
		else {
			System.out.println("No tone");
		}
	}

}
