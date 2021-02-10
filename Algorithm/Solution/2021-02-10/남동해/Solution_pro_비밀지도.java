package y2021.m02.d10;

import java.util.Arrays;

public class Solution_pro_비밀지도 {
	public static void main(String[] args) throws Exception {
//		int n = 5;
//		int[] arr1 = {9, 20, 28, 18, 11};
//		int[] arr2 = {30, 1, 21, 17, 28};
//		int n = 1;
//		int[] arr1 = {0};
//		int[] arr2 = {0};
		int n = 16;
		int[] arr1 = {90000, 20, 28, 18, 11,9, 20, 28, 18, 11,9, 20, 28, 18, 11,60};
		int[] arr2 = {30, 1, 21, 17, 28,30, 1, 21, 17, 28,30, 1, 21, 17, 28,200};
		
		System.out.println(Arrays.toString(solution(n,arr1,arr2)));
	}
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for(int i=0;i<n;i++){
			answer[i]="";
//			String temp=String.format("%0"+n+"d", Integer.parseInt(Integer.toBinaryString(arr1[i]|arr2[i])));
			String temp=Integer.toBinaryString(arr1[i]|arr2[i]);
			for(int j=0;j<n;j++) {
				if(temp.length()<=j) {
					answer[i]=" "+answer[i];
					continue;
				}
				if(temp.charAt(j)=='0') {
					answer[i]+=" ";
				}else {
					answer[i]+="#";
				}
			}
		}
		return answer;
	}
}
