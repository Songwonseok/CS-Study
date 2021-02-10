package y2021.m02.d10;

import java.util.HashSet;
import java.util.Iterator;

public class Solution_pro_후보키 {
	public static void main(String[] args) throws Exception {
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		System.out.println(solution(relation));
	}
	public static HashSet<String> set;
	public static int answer;
	public static int solution(String[][] relation) {
		answer = 0;
		set = new HashSet<>();
		for(int i=1;i<=relation[0].length;i++) {
			dfs(relation,relation[0].length,i,0,0,"");
		}
		answer = set.size();
        return answer;
    }
	private static void dfs(String[][] relation, int N, int K, int count, int start, String tuple) {
		if(count==K) {
			if(!tupleCheck(tuple,N)) {
				solve(relation,tuple);
			}
			return;
		}
		for(int i=start;i<N;i++) {
			dfs(relation,N,K,count+1,i+1,tuple+i);
		}
	}
	private static boolean tupleCheck(String tuple, int N) {
		boolean[] visit = new boolean[N];
		for(int i=0;i<tuple.length();i++) {
			visit[tuple.charAt(i)-'0']=true;
		}
		Iterator<String> iter = set.iterator();
		here:while(iter.hasNext()) {
			String temp = iter.next();
			for(int i=0;i<temp.length();i++) {
				if(!visit[temp.charAt(i)-'0']) {
					continue here;
				}
			}
			return true;
		}
		return false;
	}
	
	private static void solve(String[][] relation, String tuple) {
		HashSet<String> visit = new HashSet<>();
		for(int i=0;i<relation.length;i++) {
			String temp = "";
			for(int j=0;j<tuple.length();j++) {
				int a = tuple.charAt(j)-'0';
				temp+=relation[i][a];
			}
			visit.add(temp);
		}
		if(visit.size()==relation.length) {
			set.add(tuple);
		}
	}
}
