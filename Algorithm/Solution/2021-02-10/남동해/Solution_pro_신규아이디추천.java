package y2021.m02.d10;

public class Solution_pro_신규아이디추천 {
	public static void main(String[] args) throws Exception {
//		String new_id = "...!@BaT#*..y.abcdefghijklm";
//		String new_id = ".abcdertsdfggerd.vefe";
		String new_id = "cd";
		System.out.println(solution(new_id));
	}
	public static String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9-_.]","");
        new_id = new_id.replaceAll("[.]+",".");
        new_id = new_id.replaceAll("^[.]","");
        if(new_id.length()==0) {
        	new_id="a";
        }
        if(new_id.length()>15) {
        	new_id = new_id.substring(0,15);
        }
        new_id = new_id.replaceAll("[.]$","");
        if(new_id.length()<3) {
        	int a = new_id.length();
        	for(int i=0;i<3-a;i++) {
        		new_id=new_id+new_id.charAt(a-1);
        	}
        }
        answer = new_id;
        return answer;
    }
}
