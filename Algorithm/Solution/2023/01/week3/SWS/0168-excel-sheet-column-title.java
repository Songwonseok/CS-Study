class Solution {
    public char convertToAlphabet(int num) {
        int startAscii = (int)'A' - 1;

        if(num == 0) {
            return 'Z';
        }
        
        return (char)(startAscii + num);
    } 

    public String convertToTitle(int columnNumber) {
        // 26진수
        StringBuilder sb = new StringBuilder();

        while(columnNumber > 26) {
            int mod = columnNumber % 26;
            sb.append(convertToAlphabet(mod));

            columnNumber /= 26;

            if(mod == 0) {
                columnNumber--;
            }

        }

        sb.append(convertToAlphabet(columnNumber));

        return sb.reverse().toString();
    }
}