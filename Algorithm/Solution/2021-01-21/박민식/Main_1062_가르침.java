package a2021;

import java.util.*;
import java.io.*;

public class Main_1062_가르침 {
	static int N,K,max;
	static ArrayList<String> list;
	static boolean [] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visit = new boolean [26];
		visit['a'-'a'] = true;
		visit['n'-'a'] = true;
		visit['t'-'a'] = true;
		visit['i'-'a'] = true;
		visit['c'-'a'] = true;
		
		if(K==26) System.out.println(N);
		else if(K<5) System.out.println(0);
		else {
			K -= 5;
			max = -1;
			list = new ArrayList<>();
			for(int i=0;i<N;i++) {
				String lang = br.readLine();
				list.add(lang.substring(4, lang.length()-4));
			}
			comb(0,0);
			System.out.println(max);
		}
	}
	
	public static void comb(int start, int count) {
		if(count == K) {
			int answer = 0;
			for(int i=0;i<list.size();i++) {
				boolean notLearn = false;
				String tmp = list.get(i);
				for(int j=0;j<tmp.length();j++) {
					if(!visit[tmp.charAt(j)-'a']) { // 가르치지 않은 단어
						notLearn = true;
						break;
					}
				}
				if(!notLearn) answer++;
			}
			max = Math.max(max, answer);
			return;
		}
		
		for(int i=start;i<26;i++) {
			if(!visit[i]) {
				visit[i] = true;
				comb(i, count+1);
				visit[i] = false;
			}
		}
	}
	
}
