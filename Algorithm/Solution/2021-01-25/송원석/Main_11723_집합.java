package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11723_집합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int bit = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int num = 0;
			if(!command.equals("all") && !command.equals("empty"))
				num = Integer.parseInt(st.nextToken());
			
			switch (command) {
		      case "add":
		        bit |= 1 << num;
		        break;
		      case "remove":
		        bit &= ~(1 << num);
		        break;
		      case "check":
		        if ((bit & (1<<num)) > 0) {
		        	sb.append("1\n");
		        } else {
		        	sb.append("0\n");
		        }
		        break;
		      case "toggle":
		        bit ^= (1 << num);
		        break;
		      case "all":
		        bit = (1 << 21) - 1;
		        break;
		      case "empty":
		        bit = 0;
		    }
		}
		System.out.println(sb);
	}

}
