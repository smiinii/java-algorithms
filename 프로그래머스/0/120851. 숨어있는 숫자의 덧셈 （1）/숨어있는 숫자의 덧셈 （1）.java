class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String number = my_string.replaceAll("[a-z, A-Z]","");
        for(int i = 0; i < number.length(); i++) {
            answer += Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        return answer;
    }
}