package Programmers.kakao;

import java.util.*;

public class KAKAO_2020_괄호변환 {

	public static String getBalancedStr(String str) {
		int open = 0;
		int close = 0;

		for (int i = 0; i < str.length(); i++) {
			if (open > 0 && close > 0 && open == close) {
				break;
			}
			if (str.charAt(i) == '(') {
				open++;
			} else {
				close++;
			}
		}
		return str.substring(0, open + close);
	}

	public static boolean checkCorrect(String u) {
		Stack<Character> stack = new Stack();

		for (int i = 0; i < u.length(); i++) {
			if (u.charAt(i) == '(') {
				stack.push(u.charAt(i));
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					stack.pop();
				}
			}
		}

		if (!stack.isEmpty())
			return false;

		return true;
	}

	public static String reverseBracket(String u) {
		char[] arr = u.toCharArray();
		for (int i = 0; i< arr.length; i++) {
			arr[i] = (arr[i] == '(') ? ')' : '(';
		}
		return String.valueOf(arr);
	}

	public static String solution(String p) {
		
		if (p.length() == 0) {
			return "";
		}

		String u = getBalancedStr(p);
		String v = (p.length() == u.length()) ? "" : solution(p.substring(u.length()));

		if (!checkCorrect(u)) {
			return "(" + v + ")" + reverseBracket(u.substring(1, u.length() - 1));
		}

		return u + v;
	}

	public static void main(String[] args) {
		String a = "1233334";
		char[] c = a.toCharArray();
		String b = String.valueOf(c);
		System.out.println(b);

	}

}
