class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] answer = new char[my_string.length()];
        for (int i = 0; i < my_string.length(); i++) {
            answer[i] = my_string.charAt(i);
        }
        char temp = answer[num1];
        answer[num1] = answer[num2];
        answer[num2] = temp;
        return new String(answer);
    }
}