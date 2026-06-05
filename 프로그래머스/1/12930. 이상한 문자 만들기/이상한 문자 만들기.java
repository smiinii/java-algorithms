class Solution {
    public String solution(String s) {
        String answer = "";
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
        
            if (ch == ' ') {
                count = 0;
                answer += ch;
                continue;
            }
            
            count++; 
            
            if (count % 2 != 0) {
                answer += Character.toUpperCase(ch);
            } else {
                answer += Character.toLowerCase(ch);
            }
        }
        
        
        return answer;
    }
}