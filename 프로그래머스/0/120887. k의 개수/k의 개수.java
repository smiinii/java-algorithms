class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for (int x = i; x <= j; x++) {
            String s = String.valueOf(x);
            for (int n = 0; n < s.length(); n++) {
                if (s.charAt(n) - '0' == k) {
                    answer++;
                }
            }
        }
        return answer;
    }
}