import java.util.HashMap;
import java.util.Map;

public class 자동완성 {

    public static void main(String[] args) {
        자동완성 num1 = new 자동완성();
        System.out.println(num1.solution(
//                new String[]{"go", "gone", "guild"}
//                new String[]{"abc","def","ghi","jklm"}
                new String[]{"word","war","warrior","world"}
        ));
    }

    TrieNode root;

    public static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;
    }

    public void insert(String word) {
        TrieNode current = this.root;

        for (char l : word.toCharArray()) {
            current = current.children.computeIfAbsent(l, c -> new TrieNode());
            current.count++;
        }
    }

    public int solution(String[] words) {
        int answer = 0;

        root = new TrieNode();

        for (String word : words) {
            insert(word);
        }

        for (String word : words) {
            TrieNode current = root;
            for (char l : word.toCharArray()) {
                TrieNode node = current.children.get(l);
                answer++;
                if(node.count == 1) break;
                current = node;
            }
        }

        return answer;
    }

}
