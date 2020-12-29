package algo_study;

import java.io.*;
import java.util.*;

public class Main_4358_생태학_fail {

	/*
		ArrayList와 LinkList, PriorityQueue를 모두 사용했지만 모두 시간초과가 났음.
		List내부적으로 정렬하는 시간이 많이 걸리는 게 아닌가 싶음
		
		keySet().toArray()를 통해 Object형 배열을 만들어서 sort후 순차적으로 key값을 가져와서
		알맞은 value값으로 변환하여 통과함
	*/
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<String> treeList = new ArrayList<>();
		HashMap<String, Double> trees = new HashMap<>();
		String tree = null;
		int treeCount = 0;
		while(true) {
			tree = br.readLine();
			if(tree == null || tree.length() == 0) break;
			trees.put(tree, trees.getOrDefault(tree, 0.0) + 1.0);
			if(!treeList.contains(tree))
				treeList.add(tree);
			treeCount++;
		}
		
		Collections.sort(treeList);
		int size = treeList.size();
		for(int i=0;i<size;i++) {
			String selectTree = treeList.get(i);
			double treePercent = trees.get(selectTree);
			treePercent = Math.round(treePercent / treeCount * 1000000.0) / 10000.0;
			sb.append(selectTree + " " + treePercent +"\n");
		}
		System.out.println(sb);
	}

}
