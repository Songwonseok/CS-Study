package baek;

import java.io.*;

public class Main_9342_염색체 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String regex = "^[A-F]?A+F+C+[A-F]?$";
		
		for(int i=0;i<N;i++) {
			String word = br.readLine();
			if(word.matches(regex)) {
				System.out.println("Infected!");
			}else {
				System.out.println("Good");
			}
		}
	}

}
