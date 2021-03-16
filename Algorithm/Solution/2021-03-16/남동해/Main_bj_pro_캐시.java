package y2021.m03.d17;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Main_bj_pro_캐시 {
	public static void main(String[] args) throws Exception {
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(solution(cacheSize, cities));
	}
	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        if(cities.length<=cacheSize||cacheSize==0){
            return cities.length*5;
        }
        
        for(int i=0;i<cities.length;i++){
            String input = cities[i].toUpperCase();
            if(set.contains(input)){
                int qsize = q.size();
                for(int j=0;j<qsize;j++){
                    String curr = q.poll();
                    if(!curr.equals(input)){
                        q.add(curr);
                    }
                }
                q.add(input);
                answer++;
            }else{
                if(set.size()>=cacheSize){
                    set.remove(q.poll());   
                }
                set.add(input);
                q.add(input);
                answer+=5;
            }
        }
        return answer;
	}
}