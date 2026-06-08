class Solution {
    public int[] solution(String s) {
        int[] result = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            int answer = -1;
            for(int j = i - 1; j >= 0; j--) {
                if(s.charAt(i) == s.charAt(j)) {
                    answer = i - j;
                    
                    break;
                }
            }
            result[i] = answer;
        }
        return result;
    }
}