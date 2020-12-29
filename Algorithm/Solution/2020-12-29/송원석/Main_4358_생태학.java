package baek;

import java.io.*;
import java.util.*;

public class Main_4358_생태학 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		int total = 0;
		String name = null;
		while(true) {
			name = br.readLine();
			if(name == null || name.length() == 0)
				break;
			total++;
			map.put(name, map.getOrDefault(name, 0) + 1);
		}
		
		// 정렬을 위해 toArray()
		Object[] keys = map.keySet().toArray();
		Arrays.sort(keys);
		StringBuilder sb = new StringBuilder();
		
		for(Object key: keys) {
			double percentage = ((double)map.get(key) / total);
			percentage = Math.round((percentage*10000.0 * 100.0))/ 10000.0;
			sb.append(key+" " +String.format("%.4f", percentage)).append("\n");
		}
		
		System.out.println(sb);
	}

}
