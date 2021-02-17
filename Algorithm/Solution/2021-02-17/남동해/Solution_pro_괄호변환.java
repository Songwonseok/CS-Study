package y2021.m02.d17;

import java.util.Stack;

/*
1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
  4-3. ')'를 다시 붙입니다. 
  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
  4-5. 생성된 문자열을 반환합니다.
 */

public class Solution_pro_괄호변환 {
	public static void main(String[] args) throws Exception {
		String p = ")(";
		System.out.println(solution(p));
	}
	public static String solution(String p) {
        String answer = "";
        if(p.length()>0) {
        	int temp = split(p);
        	answer = dfs(p.substring(0,temp+1),p.substring(temp+1,p.length()));
        }
        return answer;
    }
	private static int split(String p) {
		int left=0;
		int right=0;
		for(int i=0;i<p.length();i++) {
			if(p.charAt(i)=='(') {
				left++;
			}else {
				right++;
			}
			if(left==right) {
				return i;
			}
		}
		return 0;
	}
	private static String dfs(String u, String v) {
		if(!check(u)) {
			int temp = split(v);
			u=u.substring(1,u.length()-1);
			u=reverse(u);
			if(v.length()==0) {
				return "()" + u;
			}
			return "(" + dfs(v.substring(0,temp+1),v.substring(temp+1,v.length())) + ")" + u;
		}else {
			if(v.length()==0) {
				return u;
			}
			int temp = split(v);
			return u+dfs(v.substring(0,temp+1),v.substring(temp+1,v.length()));
		}
	}
	private static String reverse(String u) {
		u=u.replace("(", "1");
		u=u.replace(")", "(");
		u=u.replace("1", ")");
		return u;
	}
	private static boolean check(String u) {
		Stack<Character> stack = new Stack<>();
		if(u.charAt(0)==')') {
			return false;
		}
		stack.add('(');
		for(int i=1;i<u.length();i++) {
			if(u.charAt(i)=='(') {
				stack.add('(');
			}else {
				if(stack.size()==0) {
					return false;
				}
				stack.pop();
			}
		}
		return true;
	}
}
