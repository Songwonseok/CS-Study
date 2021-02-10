package y2021.m02.d09;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution_코테3 {
	public static void main(String[] args) throws Exception {
//		int n = 2;
//		String[] recipes = {"A 3","B 2"};
//		String[] orders = {"A 1","A 2","B 3","B 4"};
//		int n = 3;
//		String[] recipes = {"SPAGHETTI 3", "FRIEDRICE 2", "PIZZA 8"};
//		String[] orders = {"PIZZA 1", "FRIEDRICE 2", "SPAGHETTI 4", "SPAGHETTI 6", "PIZZA 7", "SPAGHETTI 8"};
		int n = 1;
		String[] recipes = {"COOKIE 10000"};
		String[] orders = {"COOKIE 300000"};
		
		System.out.println(solution(n,recipes,orders));
	}
	public static int solution(int n, String[] recipes, String[] orders) {
		int answer = 0;
		HashMap<String, Integer> recipe = new HashMap<>();
		for(int i=0;i<recipes.length;i++) {
			String[] curr = recipes[i].split(" ");
			recipe.put(curr[0], Integer.parseInt(curr[1]));
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		if(n>=orders.length) {
			String[] curr = orders[orders.length-1].split(" ");
			answer = recipe.get(curr[0]) + Integer.parseInt(curr[1]);
		}else {
			for(int i=0;i<n;i++) {
				String[] curr = orders[i].split(" ");
				pq.add(recipe.get(curr[0])+Integer.parseInt(curr[1]));
			}
			for(int i=n;i<orders.length;i++) {
				String[] curr = orders[i].split(" ");
				int next = pq.poll();
				if(Integer.parseInt(curr[1])>next) {
					next = recipe.get(curr[0]) + Integer.parseInt(curr[1]);
				}else {
					next += recipe.get(curr[0]);
				}
				if(i==orders.length-1) {
					answer=next;
				}
				pq.add(next);
			}
		}
        return answer;
    }
}
