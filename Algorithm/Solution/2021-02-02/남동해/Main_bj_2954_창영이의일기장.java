package y2021.m02.d02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
zepelepenapa papapripikapa
 */


class Main_bj_2954_창영이의일기장 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sentence = br.readLine();
		sentence=sentence.replaceAll("apa", "a");
		sentence=sentence.replaceAll("epe", "e");
		sentence=sentence.replaceAll("ipi", "i");
		sentence=sentence.replaceAll("opo", "o");
		sentence=sentence.replaceAll("upu", "u");
		System.out.println(sentence);
	}
}