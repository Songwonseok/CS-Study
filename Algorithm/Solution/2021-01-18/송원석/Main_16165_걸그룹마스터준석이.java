package baek;

import java.io.*;
import java.util.*;

public class Main_16165_걸그룹마스터준석이 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String,ArrayList<String>> teamToMember = new HashMap();
		HashMap<String,String> memberToTeam = new HashMap();
		
		for(int i=0;i<N;i++) {
			String team = br.readLine();
			int count = Integer.parseInt(br.readLine());
			ArrayList<String> memberList = new ArrayList<String>();
			for(int j=0;j<count;j++) {
				String member = br.readLine();
				memberToTeam.put(member, team);
				memberList.add(member);
			}
			Collections.sort(memberList);
			teamToMember.put(team,memberList);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<M;i++) {
			String question = br.readLine();
			int type = Integer.parseInt(br.readLine());
			
			if(type == 0) {
				ArrayList<String> list = teamToMember.get(question);
				for(String member: list) {
					sb.append(member).append("\n");
				}
			}else {
				sb.append(memberToTeam.get(question)).append("\n");
			}
		}
		System.out.println(sb);
		
	}

}
