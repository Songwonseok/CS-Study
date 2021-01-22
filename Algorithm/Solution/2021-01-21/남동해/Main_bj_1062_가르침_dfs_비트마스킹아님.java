package y2021.m01.d21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
/*
3 6
antarctica
antahellotica
antacartica
 */


class Main_bj_1062_가르침_dfs_비트마스킹아님 {
	public static boolean visit[];
	public static int answer,co[];
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	//-97
		visit = new boolean[26];
		String[] input = new String[N];
		includeAlready();
		if(K<5) {
			answer=0;
		}else {
			//입력
			HashSet<Integer> set = new HashSet<>();
			for(int i=0;i<N;i++) {
				input[i] = br.readLine();
				input[i]=input[i].substring(4,input[i].length()-4);
				for(int j=0;j<input[i].length();j++) {
					int curr = input[i].charAt(j)-97;
					if(!visit[curr]) {
						set.add(curr);
					}
				}
			}
			//input[]:단어 3개
			//set:17,4,7,11,14
			int[] inclword = new int[set.size()];
			int index = 0;
			Iterator<Integer> ite = set.iterator();
			while(ite.hasNext()) {
				inclword[index] = ite.next();
				index++;
			}
			
//!!!!!!!inclword의 크기가 K-5보다 작은경우 반례 꼭 생각
/*
1 7
antabbtica
 */
			if(inclword.length<K-5) {
				for(int i=0;i<inclword.length;i++) {
					visit[inclword[i]]=true;
					answer = checkTar(input);
				}
				
			}else {
				co = new int[K-5];
				comb(input,inclword,inclword.length,K-5,0,0);
			}
		}
		System.out.println(answer);
	}
	
	
	private static void comb(String[] input, int[] inclword, int len, int esc, int count, int start) {
		if(count==esc) {
			int cnt = checkTar(input);
			if(cnt>answer) {
				answer = cnt;
			}
			return;
		}
		for(int i=start;i<len;i++) {
			visit[inclword[i]]=true;
			comb(input,inclword,len,esc,count+1,i+1);
			visit[inclword[i]]=false;
		}
	}

	private static int checkTar(String[] input) {
		int cnt = 0;
		for(int i=0;i<input.length;i++) {
			boolean flag = false;
			for(int j=0;j<input[i].length();j++) {
				int check = input[i].charAt(j)-97;
				if(!visit[check]) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				cnt++;
			}
		}
		return cnt;
	}


	private static void includeAlready() {
		visit['a'-97]=true;
    	visit['n'-97]=true;
    	visit['t'-97]=true;
    	visit['i'-97]=true;
    	visit['c'-97]=true;
	}
}
