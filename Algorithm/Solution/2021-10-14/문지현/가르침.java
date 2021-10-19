import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가르침 {

    public static int N, K;
    public static int max = 0;
    public static boolean[] visited = new boolean[26];
    public static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];

        if (K < 5) {
            System.out.println("0");
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words[i] = word.substring(4, word.length() - 4);
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;
        check(0, 0);
        System.out.println(max);
    }

    public static void check(int idx, int depth) {
        if (depth == K - 5) {
            int count = 0;
            for (int i = 0; i < words.length; i++) {
                boolean flag = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!visited[words[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    count++;
                }
            }

            if (max < count) max = count;
            return;
        }

        for (int i = idx; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                check(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
