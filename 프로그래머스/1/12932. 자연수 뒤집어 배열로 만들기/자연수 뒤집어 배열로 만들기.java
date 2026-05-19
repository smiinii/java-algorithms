class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        int length = str.length();
        int[] answer = new int[length];
        
        for (int i = 0; i < length; i++) {
            answer[i] = str.charAt(length - 1 - i) - '0';
        }
        
        return answer;
    }
}