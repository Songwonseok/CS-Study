import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static ArrayList<Integer> list;
	static StringBuilder sb;
	public static void perm(int count) {
		if(count == M) {
			for(int i=0;i<list.size();i++) 
				sb.append(list.get(i)).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(list.size() == 0) {
				list.add(i);
				perm(count+1);
				list.remove(list.size()-1);
			} else {
				if(i < list.get(list.size()-1)) continue;
				else {
					list.add(i);
					perm(count+1);
					list.remove(list.size()-1);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		perm(0);
		System.out.println(sb.toString());
	}

}
