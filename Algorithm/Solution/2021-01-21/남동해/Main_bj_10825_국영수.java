package y2021.m01.d21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
12
Junkyu 50 60 100
Sangkeun 80 60 50
Sunyoung 80 70 100
Soong 50 60 90
Haebin 50 60 100
Kangsoo 60 80 100
Donghyuk 80 60 100
Sei 70 70 70
Wonseob 70 70 90
Sanghyun 70 70 80
nsj 80 80 80
Taewhan 50 60 90
 */


class Main_bj_10825_국영수 {
	static class Student implements Comparable<Student>{
		String name;
		int[] score;
		public Student(String name, int[] score) {
			this.name = name;
			this.score = score;
		}
		@Override
		public int compareTo(Student o) {
			if(o.score[0]>this.score[0]) {
				return 1;
			}else if(o.score[0]==this.score[0]) {
				if(o.score[1]<this.score[1]) {
					return 1;
				}else if(o.score[1]==this.score[1]) {
					if(o.score[2]>this.score[2]) {
						return 1;
					}else if(o.score[2]==this.score[2]) {
						return -o.name.compareTo(this.name);
					}
				}
			}
			return -1;
		}
	}
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int N = Integer.parseInt(br.readLine());
    	PriorityQueue<Student> stu = new PriorityQueue<>();
//    	Student[] stu = new Student[N];
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		String name = st.nextToken();
    		int[] sco = new int[3];
    		for(int j=0;j<3;j++) {
    			sco[j]=Integer.parseInt(st.nextToken());
    		}
    		stu.add(new Student(name, sco));
    	}
//    	Arrays.sort(stu);
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<N;i++) {
    		sb.append(stu.poll().name).append("\n");
    	}
    	System.out.println(sb.toString());
	}
}
