package baek;

import java.io.*;
import java.util.regex.*;

public class Main_2941_크로아티아알파벳 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String regex = "c=|c-|dz=|d-|lj|nj|s=|z=";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		int length = str.length();
		while(matcher.find()) {
			length -= matcher.group().length()-1;
		}
		System.out.println(length);
	}

}
