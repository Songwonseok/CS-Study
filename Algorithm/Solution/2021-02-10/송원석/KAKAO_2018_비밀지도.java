package Programmers.kakao;

public class KAKAO_2018_비밀지도 {
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0;i<n;i++){
            int number = arr1[i] | arr2[i];
            StringBuilder st = new StringBuilder();
            String bin = Integer.toBinaryString(number);
            
            for(int j=0;j<n - bin.length();j++){
                st.append(" ");
            }
            
            for(int j=0;j<bin.length();j++){
                if(bin.charAt(j) == '1'){
                    st.append("#");
                }else{
                    st.append(" ");
                }
            }
            answer[i] = st.toString(); 
        }
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
