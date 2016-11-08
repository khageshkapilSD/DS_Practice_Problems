package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputWay {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running*/
    	String line;
    	ArrayList<String> input = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((line = br.readLine()).length() > 0) {
			input.add(line);
		}
        
        
        System.out.println("Hello World!");
        for (String string : input) {
			System.out.println(string);
		}
    }
}
