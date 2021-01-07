package baek;

import java.io.*;
import java.util.*;

public class Main_1316_그룹단어체커 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int i=0;i<N;i++) {
			String word = br.readLine();
			boolean checker = true;
			HashSet<Character> set = new HashSet();
			char prev = word.charAt(0);
			
			for(int j =1;j<word.length();j++) {
				char curr = word.charAt(j);
				if(set.contains(curr)) {
					checker = false;
					break;
				}
				if(curr != prev) {
					set.add(prev);
					prev = curr;
				}
			}
			if(checker) count++;
		}
		
		System.out.println(count);
	}

}
