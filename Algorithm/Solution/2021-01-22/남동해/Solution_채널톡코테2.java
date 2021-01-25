package y2021.m01.d22;

public class Solution_채널톡코테2 {
	public static void main(String[] args) throws Exception {
//		int arr1[] = {7, 8, 10};
//		int arr2[] = {10, 7, 8};
		int arr1[] = {4, 3, 2, 1};
		int arr2[] = {5, 4, 1, 2};
		System.out.println(solution(arr1, arr2));
	}
	public static boolean solution(int[] arr1, int[] arr2) {
		boolean answer = false;
		int N = arr1.length;
		here:for(int i=0;i<N;i++) {
			if(arr1[0]==arr2[i]) {
				for(int j=1;j<N;j++) {
					if(arr1[j]!=arr2[(i+j)%N]) {
						continue here;
					}
				}
				answer=true;
			}
		}
        return answer;
    }
}
