package y2021.m01.d22;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Solution_채널톡코테3 {
	public static void main(String[] args) throws Exception {
		int card[] = {1, 3, 2, 5, 3, 1};
//		int arr2[] = {1, 2, 3, 4, 4, 3, 2, 5};
		System.out.println(Arrays.toString(solution(card)));
	}
	public static int[] solution(int[] card) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0;i<card.length;i++) {
        	int temp = card[i];
        	if(!set.contains(temp)) {
        		set.add(temp);
        	}else {
        		set.remove(temp);
        	}
        }
        int[] answer = new int[set.size()];
		Iterator<Integer> iter = set.iterator();
		int index=0;
		while(iter.hasNext()) {
			answer[index]=iter.next();
			index++;
		}
		Arrays.sort(answer);
		return answer;
    }
}
