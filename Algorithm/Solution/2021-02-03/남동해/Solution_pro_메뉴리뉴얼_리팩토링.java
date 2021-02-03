package y2021.m02.d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_메뉴리뉴얼_리팩토링 {
	public static void main(String[] args) throws Exception {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//		String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		System.out.println(Arrays.toString(solution(orders, course)));
	}
	static class Menu implements Comparable<Menu>{
		String name;
		int count;
		int len;
		public Menu(String name, int count, int len) {
			this.name = name;
			this.count = count;
			this.len = len;
		}
		@Override
		public String toString() {
			return "menu [name=" + name + ", count=" + count + ", len=" + len + "]";
		}
		@Override
		public int compareTo(Menu o) {
			if(o.len==this.len) {
				return o.count-this.count;
			}
			return o.len-this.len;
		}
		
	}
	public static HashMap<String,Integer> map;
	public static String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();
        for(int i=0;i<course.length;i++) {
        	int menulen=course[i];
        	for(int j=0;j<orders.length;j++) {
        		String temp = orders[j];
        		String[] menus = temp.split("");
        		Arrays.sort(menus);
        		dfs(menulen,menus,0,0,"");
        	}
        }
        ArrayList<Menu> al = new ArrayList<>();
        for(String s : map.keySet()) {
        	if(map.get(s)>1) {
        		al.add(new Menu(s,map.get(s),s.length()));
        	}
        }
        Collections.sort(al);
        int currlen = al.get(0).len;
        int currcount = al.get(0).count;
        ArrayList<String> answerarr = new ArrayList<>();
        answerarr.add(al.get(0).name);
        for(int i=1;i<al.size();i++) {
        	if(currlen==al.get(i).len) {
        		if(currcount==al.get(i).count) {
        			answerarr.add(al.get(i).name);
        		}else {
        			continue;
        		}
        	}else {
        		currlen=al.get(i).len;
        		currcount=al.get(i).count;
        		answerarr.add(al.get(i).name);
        	}
        }
        String[] answer = new String[answerarr.size()];
        for(int i=0;i<answer.length;i++) {
        	answer[i]=answerarr.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
	
	private static void dfs(int menulen, String[] menus,int count,int start,String word) {
		if(count==menulen) {
			if(map.get(word)==null) {
				map.put(word,1);
			}else {
				map.put(word,map.get(word)+1);
			}
			return;
		}
		for(int i=start;i<menus.length;i++) {
			dfs(menulen, menus, count+1, i+1, word+menus[i]);
		}
	}
}
