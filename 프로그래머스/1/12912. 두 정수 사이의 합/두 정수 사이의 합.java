import java.util.*;
class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int size = Math.abs(a - b);
        int temp = 0;
        if (a < b) {
            temp = a;
        }
        if(a > b) {
            temp = b;
        }
        if (a == b) {
            temp = a;
        }
        for (int i = 0; i <= size; i++) {
            answer += (long)temp;
            temp++;
        }
        return answer;
    }
}