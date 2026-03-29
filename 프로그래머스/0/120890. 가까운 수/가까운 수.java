import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        Arrays.sort(array);
        int result = array[0];
        int answer = Math.abs(array[0] - n);
        
        for (int number : array) {
            int value = Math.abs(number - n);
            if (answer > value) {
                result = number;
                answer = value;
            } else if (answer < value) {
                break;
            }
        }
        return result;
    }
}