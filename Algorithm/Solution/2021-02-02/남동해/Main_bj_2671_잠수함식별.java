package y2021.m02.d02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
100000000001101
 */


class Main_bj_2671_잠수함식별 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sentence = br.readLine();
		sentence = sentence.replaceAll("^(100+1+|01)+$", "");
		if(sentence.length()==0) {
			System.out.println("SUBMARINE");
		}else {
			System.out.println("NOISE");
		}
	}
}