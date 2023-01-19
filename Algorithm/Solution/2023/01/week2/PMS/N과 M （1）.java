import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean [] visit = new boolean [N+1];
		int [] answer = new int [M];
		StringBuilder sb = new StringBuilder();
		
		dfs(0,N,M,sb,answer,visit);
		System.out.println(sb.toString());
	}

	public static void dfs(int idx, int N, int M, StringBuilder sb, int [] answer, boolean [] visit)
	{
		if(idx == M)
		{
			for(int i=0;i<M;i++)
			{
				sb.append(answer[i]);
				sb.append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i=1;i<=N;i++)
		{
			if(visit[i]) continue;
			visit[i] = true;
			answer[idx] = i;
			dfs(idx+1, N, M, sb, answer, visit);
			visit[i] = false;
		}
	}
}