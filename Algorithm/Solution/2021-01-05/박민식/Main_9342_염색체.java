package algo_study;

import java.io.*;
import java.util.*;

public class Main_9342_염색체 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			int len = str.length() - 1;
			int A = str.indexOf("A");
			int F = str.indexOf("F");
			int C = str.indexOf("C");
			int Aend = str.lastIndexOf("A");
			int Fend = str.lastIndexOf("F");
			
			boolean complite = false;
			if(str.charAt(len)=='A' || str.charAt(len)=='B' || str.charAt(len)=='C' || str.charAt(len)=='D' || str.charAt(len)=='E' || str.charAt(len)=='F') { 
				if(A<F && F<C && A<C) {
					if(Aend == F-1 && Fend == C-1) {
						complite = true;
					}
				}
			}
			
			if(complite) sb.append("Infected!"+"\n");
			else sb.append("Good"+"\n");
		}
		
		System.out.println(sb);
	}

}
