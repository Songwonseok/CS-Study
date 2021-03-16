package algo_study;

import java.util.*;

public class Programmers_캐시 {

	public static void main(String[] args) {
		int cacheSize = 3;
		String [] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(solution(cacheSize, cities));
	}

	public static int solution(int cacheSize, String [] cities) {
		int answer = 0;
		HashSet<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0;i<cities.length;i++) {
            String city = cities[i].toLowerCase();
            if(set.contains(city)) {
                answer++;
                int index = 0;
                for(int j=0;j<list.size();j++) {
                    String t = list.get(j);
                    if(city.equals(t)) {
                    	index = j;
                    	break;
                    }
                }
                list.remove(index);
                list.add(city);
            } else {
                set.add(city);
                answer += 5;
                list.add(city);
                if(list.size() > cacheSize) {
                    set.remove(list.get(0));
                    list.remove(0);
                }
            }
        }
		return answer;
	}
}
