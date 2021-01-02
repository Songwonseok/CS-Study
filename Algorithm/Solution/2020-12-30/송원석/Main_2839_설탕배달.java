package baek;

import java.io.*;

public class Main_2839_설탕배달 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sugar = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		
		for(int largeBag=0;largeBag<=sugar;largeBag+=5) {
			if((sugar-largeBag)%3 == 0) {
				int smallBagCount = (sugar-largeBag)/3;
				int largeBagCount = largeBag/5;
				min = Math.min(min, largeBagCount+ smallBagCount);
			}
		}
		
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

}
