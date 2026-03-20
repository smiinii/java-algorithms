class Solution {
    public int solution(int order) {
        int answer = 0;
        String str = String.valueOf(order);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '3') {
                answer += 1;
            } else if (str.charAt(i) == '6') {
                answer += 1;
            } else if (str.charAt(i) == '9') {
                answer += 1;
            }
        }
        return answer;
    }
}