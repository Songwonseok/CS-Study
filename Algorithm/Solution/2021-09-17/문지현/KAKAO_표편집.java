import java.util.ArrayList;
import java.util.List;

public class KAKAO_표편집 {

    public static void main(String[] args) {
        KAKAO_표편집 num1 = new KAKAO_표편집();
//        System.out.println(num1.solution(
//                8, 2,
//                new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}
//        ));
        System.out.println(num1.solution(
                8, 2,
                new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}
        ));
    }

    public String solution(int n, int k, String[] cmd) {
        List<Integer> removeList = new ArrayList<>();
        int idx = k;
        int length = n;
        for (String str : cmd) {
            String[] temp = str.split(" ");
            int number = 0;
            String command = temp[0];

            if (temp.length > 1) number = Integer.parseInt(temp[1]);

            switch (command) {
                case "U":
                    idx = idx - number;
                    break;
                case "D":
                    idx = idx + number;
                    break;
                case "C":
                    removeList.add(idx);
                    if (idx == length - 1) idx--;
                    length--;
                    break;
                case "Z":
                    int remove = removeList.remove(removeList.size() - 1);
                    if (remove <= idx) idx++;
                    length++;
                    break;
            }
        }

        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("O");
        }
        for (int i = removeList.size()-1; i >= 0; i--) {
            sb.insert(removeList.get(i), "X");
        }
        return sb.toString();
    }
}
