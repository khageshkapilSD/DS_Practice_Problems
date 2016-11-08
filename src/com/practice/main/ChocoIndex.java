package problems;

/*import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class WordCount {
	static String text;
	static String word;
	static int count;
	
	static String str = " AA  AAD DSAAA";
	static String subStr = "AA";
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		ArrayList<String> input;
		int[] result;
		try {
			input = new ArrayList<String>();
			String line = "";
			while ((line = s.nextLine()).length() > 0) {
				input.add(line);
			}
			for (int j = 0; j < result.size(); j++) {
				line = result.get(j);
				count = 0;
				text = line.substring(0, line.indexOf(":") - 1);
				word = line.substring(line.indexOf(":") + 2);
				if (text.length() > 0 && word.length() > 0) {
					for (int i = 0; i < text.length(); i++) {
						
						if (text.charAt(i) == word.charAt(0)) {
							String temp = text.substring(i, i + word.length());
							if (temp.equalsIgnoreCase(word)) {
								count++;
							}
								// i = i + word.length() - 1;
						}
					}
					if (count > 0) {
						System.out.println("Yes : " + count);
					} else {
						System.out.println("No");
					}
				} else {
					System.out.println("No");
				}
			}
		}
		finally {
			s.close();
		}
		
		try {
			int boxCount = Integer.parseInt(input.get(0));
			if(boxCount>=1||boxCount<=100000){
				String[] boxArray = input.get(1).split(" ");
				int queryCount = Integer.parseInt(input.get(2));
				if(queryCount>=1||queryCount<=100000){
					result = new int[queryCount];
					for (int i = 0; i < queryCount; i++) {
						int queryIndex = Integer.parseInt(input.get(i + 3));
						if(queryIndex>=1){
							int chocoCount = 0;
							for (int j = 0; j < boxArray.length; j++) {
								chocoCount+=Integer.parseInt(boxArray[j]);
								if(queryIndex>chocoCount){
									continue;
								}
								else{
									result[i] = j+1;
									break;
								}
							}
						}
						else{
							result[i] = -1;
						}
					}
					for (int i = 0; i < result.length; i++) {
						System.out.println(result[i]);
					}
				} else {
					throw new Exception();
				}
			}
			else {
				throw new Exception();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
//		System.out.println((str.length() - str.replace(subStr, "").length()) / subStr.length());
//		System.out.println(">>str"+str);
//		System.out.println(">>subStr"+subStr);
	}
}
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ChocoIndex {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String in = sc.
		int boxCount = 0;
		String[] boxArray = null;
		int[] boxArrayInt = null;
		int queryCount = 0;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			boxCount = Integer.parseInt(br.readLine());
			boxArray = br.readLine().split(" ");
			for (int i = 0; i < boxCount; i++) {
				boxArrayInt[i] = Integer.parseInt(boxArray[i]);
			}
			StringBuilder stringBuilder = new StringBuilder();
			String line = br.readLine();
			int j=0;
			boxArrayInt = new int[boxCount];
			for(int i=0;i<line.length();i++){
				char ch = line.charAt(i);
				if(line.charAt(i)!=' ')
					stringBuilder.append(ch);
				else{
					boxArrayInt[j] = Integer.parseInt(stringBuilder.toString());
					stringBuilder.setLength(0);
					i++;
				}
			}
			boxArrayInt[j] = Integer.parseInt(stringBuilder.toString());
			queryCount = Integer.parseInt(br.readLine());
			
			
			for (int j1 = 0; j1 < queryCount; j1++) {
				int x = Integer.parseInt(br.readLine());
				if (x > 0) {
					int chocoCount = 0;
					for (int i = 0; i < boxCount; i++) {
						chocoCount += boxArrayInt[i];
						if (x <= chocoCount) {
							System.out.println(i + 1);
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}