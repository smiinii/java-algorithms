import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Integer[] integer = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            integer[i] = citations[i];
        }
        
        Arrays.sort(integer, (a, b) -> {
            return Integer.compare(b, a);
        });
        
        int result = 0;

        for (int i = 0; i < integer.length; i++) {
            int h = i + 1;

            if (integer[i] >= h) {
                result = h;
            } else {
                break;
            }
        }
        return result;
    }
}