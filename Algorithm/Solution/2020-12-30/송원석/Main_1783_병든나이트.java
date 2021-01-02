package baek;

import java.io.*;
import java.util.*;

public class Main_1783_병든나이트 {
	
/*
	1) 2칸 위로, 1칸 오른쪽
	2) 1칸 위로, 2칸 오른쪽
	3) 1칸 아래로, 2칸 오른쪽
	4) 2칸 아래로, 1칸 오른쪽
*/
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int result = 0;
		
		// N이 1이면 이동 불가 (시작지점만)
		if(N == 1) {
			result = 1;
		}
		// N이 2일 떈, 2번,3번 방향으로만 움직일 수 있음
		// 절대 4방향 다 움직일 수 없어서 최댓값은 4
		else if(N == 2) {
			result = Math.min((M+1)/2, 4);
		}else if(N>=3){
			// M=7 부터 4방향 다 이동 가능
			// 4방향 다 이동한 후에는 y값이 1씩 증가하는 1번,4번 이동을 반복해야 최대값, 즉 M-2개의 칸을 갈 수 있음
			if(M < 7) {
				result = Math.min(M, 4);
			}else {
				result = M-2;
			}
		}
		
		System.out.println(result);
	}
}
