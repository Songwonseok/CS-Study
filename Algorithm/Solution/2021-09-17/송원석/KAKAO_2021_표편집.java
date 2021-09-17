package Programmers.kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KAKAO_2021_표편집 {
	static class Row {
		int index;
		Row up;
		Row down;

		Row(int index) {
			this.index = index;
		}
	}

	static class Table {
		boolean[] isDelete;
		Row curr;
		List<Row> list;
		Stack<Row> undoStack;

		Table(List<Row> list, int curr) {
			this.isDelete = new boolean[list.size()];
			this.list = list;
			this.curr = list.get(curr);
			this.undoStack = new Stack<>();
		}

		void moveUp(int count) {
			while(count > 0) {
				curr = curr.up;
				count--;
			}
		}

		void moveDown(int count) {
			while(count > 0) {
				curr = curr.down;
				count--;
			}
		}

		void delete() {
			undoStack.push(curr);
			isDelete[curr.index] = true;

			if(curr.down == null){
				curr.up.down = null;
				curr = curr.up;
				return;
			}

			if(curr.up == null){
				curr.down.up = null;
			}else {
				curr.up.down = curr.down;
				curr.down.up = curr.up;
			}

			curr = curr.down;
		}

		void undo() {
			Row reset = undoStack.pop();

			isDelete[reset.index] = false;

			Row up = reset.up;
			Row down = reset.down;

			if(up != null){
				up.down = reset;
			}

			if(down != null) {
				down.up = reset;
			}
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();

			for(boolean b : isDelete) {
				if(b){
					sb.append("X");
				}else{
					sb.append("O");
				}
			}

			return sb.toString();
		}
	}

	public static String solution(int n, int k, String[] cmd) {
		List<Row> list = new ArrayList<>();

		for(int i=0;i<n;i++){
			Row curr = new Row(i);
			list.add(curr);

			if(i > 0){
				Row prev = list.get(i-1);
				curr.up = prev;
				prev.down = curr;
			}
		}

		Table table = new Table(list, k);

		for(String c : cmd) {
			String[] cammand = c.split(" ");

			switch (cammand[0]) {
				case "U" :
					table.moveUp(Integer.parseInt(cammand[1]));
					break;
				case "D" :
					table.moveDown(Integer.parseInt(cammand[1]));
					break;
				case "C" :
					table.delete();
					break;
				case "Z" :
					table.undo();
					break;
			}
		}


		return table.toString();
	}

	public static void main(String[] args) {
		int n = 8;
		int k = 2;
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};

		System.out.println(solution(n,k,cmd));
	}
}
