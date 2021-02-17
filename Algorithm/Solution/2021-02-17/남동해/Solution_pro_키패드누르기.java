package y2021.m02.d17;

public class Solution_pro_키패드누르기 {
	public static void main(String[] args) throws Exception {
//		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//		String hand = "right";
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
		
		System.out.println(solution(numbers,hand));
	}
	public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int l=9;
        int r=11;
        for(int i=0;i<numbers.length;i++) {
        	int curr = numbers[i]-1;
        	if(curr==-1) {
        		curr=10;
        	}
        	if(curr==0||curr==3||curr==6) {
        		sb.append("L");
        		l=curr;
        	}else if(curr==2||curr==5||curr==8) {
        		sb.append("R");
        		r=curr;
        	}else {
        		int ldis = Math.abs(l/3-curr/3) + Math.abs(l%3-curr%3);
        		int rdis = Math.abs(r/3-curr/3) + Math.abs(r%3-curr%3);
        		if(ldis<rdis) {
        			sb.append("L");
        			l=curr;
        		}else if(ldis>rdis) {
        			sb.append("R");
        			r=curr;
        		}else {
        			if(hand.equals("left")) {
        				sb.append("L");
        				l=curr;
        			}else {
        				sb.append("R");
        				r=curr;
        			}
        		}
        	}
        }
        String answer = sb.toString();
        return answer;
    }
}
