import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int temp = 0;
        String[] splitStr = s.split(" ");
        for (String token : splitStr) {
            if (!token.equals("Z")) {
                answer += Integer.parseInt(token);
                temp = Integer.parseInt(token);
            }
            if (token.equals("Z")) {
                answer -= temp;
            }
        }
        return answer;
    }
}