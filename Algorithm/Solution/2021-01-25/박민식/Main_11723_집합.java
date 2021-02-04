package a2021;

import java.util.*;
import java.io.*;

public class Main_11723_집합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int bit = 0;
		
		for(int i=0;i<N;i++) {
			String [] order = br.readLine().split(" ");
			int num = 0;
			switch(order[0]) { 
				case "add":
					num = Integer.parseInt(order[1]);
					bit = bit | (1 << (num-1));
					break;
				case "check":
					num = Integer.parseInt(order[1]);
					if((bit & 1<<(num-1)) == 1<<(num-1)) {
						sb.append(1+"\n");
					} else {
						sb.append(0+"\n");
					}
					break;
				case "remove":
					num = Integer.parseInt(order[1]);
					bit = bit | ~(1 << (num-1));
					break;
				case "toggle":
					num = Integer.parseInt(order[1]);
					bit = bit ^ 1 << (num-1);
					break;
				case "all":
					bit = (1 << 21) - 1;
					break;
				case "empty":
					bit = 0;
					break;
			}
		} // end of for
		
		System.out.println(sb);
	}

}
