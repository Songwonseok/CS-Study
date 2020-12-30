package algo_study;

import java.util.*;
import java.io.*;

public class Main_5585_거스름돈 {
	// 500 , 100, 50, 10, 5, 1
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int money = 1000 - sc.nextInt();
		int change = 0;
		
		change += money / 500;
		money %= 500;
		change += money / 100;
		money %= 100;
		change += money / 50;
		money %= 50;
		change += money / 10;
		money %= 10;
		change += money / 5;
		money %= 5;
		change += money / 1;
		money %= 1;
		
		System.out.println(change);
		
	}

}
