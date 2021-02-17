package Programmers.kakao;

import java.util.*;

public class KAKAO_2020_키패드누르기 {

	public static void changeLoc(int[] thumb, int row, int column, StringBuilder sb, String dir) {
		thumb[0] = row;
		thumb[1] = column;
		sb.append(dir);
	}

	public static int getDistance(int[] thumb, int row, int column) {
		return Math.abs(thumb[0] - row) + Math.abs(thumb[1] - column);
	}
	
	public static String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();
        int[] row = { 3, 0, 0, 0, 1, 1, 1, 2, 2, 2 }; // 0~9까지 행번호
        int[] left = {3,0};
        int[] right = {3,2};
        
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] != 0 && numbers[i] % 3 == 0){
                changeLoc(right, row[numbers[i]], 2, sb, "R");
            }else if(numbers[i] % 3 == 1){
                changeLoc(left, row[numbers[i]], 0, sb, "L");
            }else{
                int leftDistance = getDistance(left, row[numbers[i]], 1);
                int rightDistance = getDistance(right, row[numbers[i]], 1);
                if(leftDistance < rightDistance){
                    changeLoc(left, row[numbers[i]], 1, sb, "L");
                }else if(rightDistance < leftDistance){
                    changeLoc(right, row[numbers[i]], 1, sb, "R");
                }else{
                    if(hand.equals("right")){
                        changeLoc(right, row[numbers[i]], 1, sb, "R");
                    }else{
                        changeLoc(left, row[numbers[i]], 1, sb, "L"); 
                    }
                }
            }
        }
        
        return sb.toString();
	}

	public static void main(String[] args) {
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
		String hand = "left";
		String answer = solution(numbers, hand);
		System.out.println(answer);
	}

}
