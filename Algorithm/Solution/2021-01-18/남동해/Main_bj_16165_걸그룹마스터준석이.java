package y2021.m01.d18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
3 5
twice
9
jihyo
dahyeon
mina
momo
chaeyoung
jeongyeon
tzuyu
sana
nayeon
blackpink
4
jisu
lisa
rose
jenny
redvelvet
5
wendy
irene
seulgi
yeri
joy
sana
1
wendy
1
twice
0
rose
1
blackpink
0
*/

class Main_bj_16165_걸그룹마스터준석이 {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	HashMap<String, PriorityQueue<String>> team = new HashMap<>();
    	HashMap<String, String> member = new HashMap<>();
    	
    	for(int i=0;i<N;i++) {
    		String teamname = br.readLine();
    		int count = Integer.parseInt(br.readLine());
    		PriorityQueue<String> temp = new PriorityQueue<>();
    		for(int j=0;j<count;j++) {
    			String membername = br.readLine();
    			temp.add(membername);
    			member.put(membername, teamname);
    		}
    		team.put(teamname, temp);
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<M;i++) {
    		String que = br.readLine();
    		int type = Integer.parseInt(br.readLine());
    		if(type==0) {
    			PriorityQueue<String> printmember = team.get(que);
    			int size = printmember.size();
    			for(int j=0;j<size;j++) {
    				sb.append(printmember.poll()).append("\n");
    			}
    		}else {
    			sb.append(member.get(que)).append("\n");
    		}
    	}
    	System.out.println(sb.toString());
	}
}
