class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;

        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            // 마지막 인덱스이거나 'I', 'X', 'C' 가 아닌 경우
            if(i == s.length() - 1 
            || (curr != 'I' && curr != 'X' && curr != 'C')) {
                sum += map.get(curr);
                continue;
            }


            // 'I', 'X', 'C' 인 경우
            char next = s.charAt(i + 1);
            
            if(curr == 'I' && (next == 'V' || next == 'X')) {
                sum += map.get(next) - map.get(curr);
                i++;
                continue;
            }

            if(curr == 'X' && (next == 'L' || next == 'C')) {
                sum += map.get(next) - map.get(curr);
                i++;
                continue;
            }
            
            if(curr == 'C' && (next == 'D' || next == 'M')) {
                sum += map.get(next) - map.get(curr);
                i++;
                continue;
            }

            sum += map.get(curr);
        }


        return sum;
    }
}