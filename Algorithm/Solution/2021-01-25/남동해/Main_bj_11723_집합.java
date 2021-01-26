package y2021.m01.d25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
26
add 1
add 2
check 1
check 2
check 3
remove 2
check 1
check 2
toggle 3
check 1
check 2
check 3
check 4
all
check 10
check 20
toggle 10
remove 20
check 10
check 20
empty
check 1
toggle 1
check 1
toggle 1
check 1
 */


class Main_bj_11723_집합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int result = 0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if(command.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				result|=(1<<(num-1));
			}else if(command.equals("remove")) {
				int num = Integer.parseInt(st.nextToken());
				result&=~(1<<(num-1));
			}else if(command.equals("check")) {
				int num = Integer.parseInt(st.nextToken());
				if((result&(1<<(num-1)))==0) {
					sb.append(0).append("\n");
				}else {
					sb.append(1).append("\n");
				}
			}else if(command.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				result^=(1<<(num-1));
			}else if(command.equals("all")) {
				result|=(~0);
			}else if(command.equals("empty")) {
				result&=0;
			}
		}
		System.out.println(sb.toString());
	}
}
