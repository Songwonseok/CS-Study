package algo_study;

import java.util.*;

public class Main_2839_설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int total = sc.nextInt();
		int result = 0;
		
		while(true) {
			if(total % 5 == 0) {
				total /= 5;
				System.out.println(total + result);
				break;
			} else if(total == 0) {
				System.out.println(result);
				break;
			} else if(total < 0) {
				System.out.println(-1);
				break;
			}
			
			total -= 3;
			result++;
		}
	}

}
