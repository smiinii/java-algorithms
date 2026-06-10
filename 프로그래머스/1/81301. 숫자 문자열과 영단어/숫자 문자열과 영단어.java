class Solution {
    public int solution(String s) {
        String[] token = new String[10];
        token[0] = "zero";
        token[1] = "one";
        token[2] = "two";
        token[3] = "three";
        token[4] = "four";
        token[5] = "five";
        token[6] = "six";
        token[7] = "seven";
        token[8] = "eight";
        token[9] = "nine";
        
        for(int i = 0; i < token.length; i++) {
            s = s.replace(token[i], Integer.toString(i));
        }
        
        return Integer.parseInt(s);
    }
}