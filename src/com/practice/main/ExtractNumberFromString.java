package problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractNumberFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern intsOnly = Pattern.compile("\\d+");
		Matcher makeMatch = intsOnly.matcher("1213124 dadsad 14 dssaf jfdkasl;fj 12345");
		makeMatch.find();
		String inputInt = makeMatch.group();
		System.out.println(inputInt);
	}

}
