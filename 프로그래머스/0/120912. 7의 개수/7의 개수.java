class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for (int token : array) {
            char[] ch = String.valueOf(token).toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == '7') {
                    answer++;
                }
            }
        }
        return answer;
    }
}