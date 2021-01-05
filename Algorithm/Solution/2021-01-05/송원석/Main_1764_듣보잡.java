package baek;

import java.io.*;
import java.util.*;

public class Main_1764_듣보잡 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<String> nuguGroup = new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		
		for(int i=0;i<N;i++) {
			String neverHeardBefore = br.readLine();
			set.add(neverHeardBefore);
		}
		
		for(int i=0;i<M;i++) {
			String neverSeenBefore = br.readLine();
			if(set.contains(neverSeenBefore)) {
				nuguGroup.add(neverSeenBefore);
			}
		}
		
		Collections.sort(nuguGroup);
		
		StringBuilder sb = new StringBuilder();
		sb.append(nuguGroup.size()).append("\n");
		
		for(String name : nuguGroup) {
			sb.append(name).append("\n");
		}
		
		System.out.println(sb);
	}

}
