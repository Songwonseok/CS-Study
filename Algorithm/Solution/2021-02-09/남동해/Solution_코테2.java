package y2021.m02.d09;

import java.util.ArrayList;

public class Solution_코테2 {
	public static void main(String[] args) throws Exception {
		int line[][] = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
//		int line[][] = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
//		int line[][] = {{1, -1, 0}, {2, -1, 0}};
//		int line[][] = {{1, -1, 0}, {2, -1, 0}, {4, -1, 0}};
		
		String[] result = solution(line);
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}
	public static String[] solution(int[][] line) {
		int maxx=-100001;
		int maxy=-100001;
		int minx=100001;
		int miny=100001;
		ArrayList<int[]> al = new ArrayList<>();
		for(int i=0;i<line.length;i++) {
        	for(int j=i+1;j<line.length;j++) {
        		double x = (double)(line[i][1]*line[j][2]-line[i][2]*line[j][1])/(line[i][0]*line[j][1]-line[i][1]*line[j][0]);
        		double y = (double)(line[i][2]*line[j][0]-line[i][0]*line[j][2])/(line[i][0]*line[j][1]-line[i][1]*line[j][0]);
        		if(x-(int)x==0&&y-(int)y==0) {
        			int nx = (int)x;
        			int ny = (int)y;
        			if(nx>maxx) {
        				maxx=nx;
        			}
        			if(ny>maxy) {
        				maxy=ny;
        			}
        			if(nx<minx) {
        				minx=nx;
        			}
        			if(ny<miny) {
        				miny=ny;
        			}
        			al.add(new int[] {nx,ny});
        		}
        	}
        }
		boolean[][] map = new boolean[maxx-minx+1][maxy-miny+1];
		for(int i=0;i<al.size();i++) {
			int[] curr = al.get(i);
			map[curr[0]-minx][curr[1]-miny]=true;;
		}
		String[] answer = new String[map[0].length];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<map[0].length;i++) {
			for(int j=0;j<map.length;j++) {
				if(map[j][map[i].length-i-1]) {
					sb.append("*");
				}else {
					sb.append(".");
				}
			}
			answer[i]=sb.toString();
			sb.setLength(0);
		}
        return answer;
    }
}
