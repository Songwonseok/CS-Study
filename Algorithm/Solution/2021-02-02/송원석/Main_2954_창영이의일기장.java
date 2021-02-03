package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2954_창영이의일기장 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] regex = {"apa","epe","ipi","opo","upu"};
		String[] origin = {"a","e","i","o","u"};
		
		String diary = br.readLine();
		
		for(int i=0;i<regex.length;i++) {
			diary = diary.replaceAll(regex[i], origin[i]);
		}
		
		System.out.println(diary);
	}
}
