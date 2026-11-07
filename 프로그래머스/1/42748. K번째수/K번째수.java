import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        int index = 0;
        for(int[] command : commands) {
            int[] temp = new int[command[1] - command[0] + 1];
            int j = 0;
            for(int i = command[0] - 1; i < command[1]; i++) {
                temp[j++] = array[i];
            }
            Arrays.sort(temp);
            System.out.println(temp[0]);
            result[index++] = temp[command[2] - 1];
        }
        
        return result;
    }
}