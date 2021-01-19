package a2021;

import java.util.*;
import java.io.*;

public class Main_16165_걸그룹마스터준석이 {
	static HashMap<String, String[]> girlGroup;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		girlGroup = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			String teamName = br.readLine();
			int teamCount = Integer.parseInt(br.readLine());
			String [] team = new String [teamCount];
			for(int j=0;j<teamCount;j++) {
				String member = br.readLine();
				team[j] = member;
				girlGroup.put(member, new String[] {teamName});
			}
			girlGroup.put(teamName, team);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<Q;i++) {
			String quiz = br.readLine();
			int whatQuiz = Integer.parseInt(br.readLine());
			
			if(whatQuiz==0) { // 팀의 이름이 주어지며, 팀원이름 모두 출력
				String [] tmp = girlGroup.get(quiz);
				Arrays.sort(tmp);
				for(int j=0;j<tmp.length;j++)
					sb.append(tmp[j]+"\n");
			} else { // 팀원이름 주어지며, 팀의 이름 출력
				String [] tmp = girlGroup.get(quiz);
				sb.append(tmp[0]+"\n");
			}
		}
		
		System.out.println(sb);
	}

}
