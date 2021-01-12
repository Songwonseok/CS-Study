package algo_study;

import java.util.*;
import java.io.*;

public class Main_1316_그룹단어체커 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int groupCount = 0;
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			HashSet<Character> set = new HashSet<>();
			boolean isGroup = true;
			char prevWord = 0;
			for(int j=0;j<str.length();j++) {
				char currWord = str.charAt(j);
				if(j==0) {
					set.add(currWord);
					prevWord = currWord;
				} else if(set.contains(currWord)) {
					if(prevWord != currWord) {
						isGroup = false;
						break;
					} else 
						continue;
				} else if(!set.contains(currWord)) {
					set.add(currWord);
					prevWord = currWord;
				}
				
			} // end of for j
			if(isGroup) groupCount++;
		}// end of for i
		System.out.println(groupCount);
	}
}
