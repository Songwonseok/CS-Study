import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 흙길보수하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken(" "));
        int L = Integer.parseInt(st.nextToken(" "));

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken(" "));
            int end = Integer.parseInt(st.nextToken(" "));
            list.add(new int[]{start, end});
        }

        list.sort((int[] o1, int[] o2) -> o1[0] - o2[0]);

        int left = 0;
        int answer = 0;

        for (int i = 0; i < list.size(); i++) {
            if (left < list.get(i)[0]) left = list.get(i)[0];

            double temp = (double) (list.get(i)[1] - left) / L;
            int cnt = (int) Math.ceil(temp);

            left += cnt * L;
            answer += cnt;
        }
        System.out.println(answer);
    }
}
