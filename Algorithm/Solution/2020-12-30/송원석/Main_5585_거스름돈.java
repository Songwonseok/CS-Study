package baek;

import java.io.*;

public class Main_5585_거스름돈 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] coins = {500, 100, 50, 10, 5 ,1};
		int price = 1000 - Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int coin : coins) {
			if(price/coin > 0) {
				count += price/coin;
				price %= coin;
			}
		}
		System.out.println(count);
	}

}
