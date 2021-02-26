package y2021.m02.d26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
 */

public class Solution_pro_튜플 {
	public static void main(String[] args) throws Exception {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
//		String s = "{{20,111},{111}}";
//		String s = "{{123}}";
//		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
				
		System.out.println(Arrays.toString(solution(s)));
	}
	public static int[] solution(String s) {
        ArrayList<Integer>[] al = new ArrayList[501];
        int temp = 0;
        int maxindex = 0;
        for(int i=1;i<s.length()-1;i++) {
        	if(s.charAt(i)=='{') {
        		temp=i+1;
        	}else if(s.charAt(i)=='}') {
        		String[] set = s.substring(temp,i).split(",");
        		int index = set.length-1;
        		if(set.length>maxindex) {
        			maxindex=set.length;
        		}
        		al[index]=new ArrayList<>();
        		for(int j=0;j<set.length;j++) {
        			al[index].add(Integer.parseInt(set[j]));
        		}
        	}
        }
        int[] answer = new int[maxindex];
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<al.length;i++) {
        	if(al[i]==null) {
        		break;
        	}
        	for(int j=0;j<al[i].size();j++) {
        		int curr = al[i].get(j);
        		if(!hs.contains(curr)) {
        			hs.add(curr);
        			answer[i]=curr;
        			break;
        		}
        	}
        }
        return answer;
    }
}
