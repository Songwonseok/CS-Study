package algo_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main_4358_생태학_retry {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, Double> trees = new HashMap<>();
		String tree = null;
		int treeCount = 0;
		while(true) {
			tree = br.readLine();
			if(tree == null || tree.length() == 0) break;
			trees.put(tree, trees.getOrDefault(tree, 0.0) + 1.0);
			treeCount++;
		}
		Object[] array = trees.keySet().toArray();
		Arrays.sort(array);
		for(Object key: array) {
			String selectTree = (String)key;
			double treePercent = trees.get(selectTree);
			treePercent = Math.round((treePercent / treeCount) * 100.0 * 10000.0) / 10000.0;
			sb.append(selectTree + " " + String.format("%.4f", treePercent) +"\n");
		}
		System.out.println(sb);
	}

}
