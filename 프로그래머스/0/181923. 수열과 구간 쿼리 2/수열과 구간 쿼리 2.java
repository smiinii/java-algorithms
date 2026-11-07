import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        int index = 0;
        
        for(int[] query : queries) {
            int[] temp = Arrays.copyOfRange(arr, query[0], query[1] + 1);
            Arrays.sort(temp);
            int count = 0;
            for(int i = 0; i < temp.length; i++) {
                if(temp[i] > query[2] && count == 0) {
                    result[index++] = temp[i];
                    count++;
                }
            }
            if(count == 0) {
                result[index++] = -1;
            }
        }
        return result;
    }
}