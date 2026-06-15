import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        Queue<int[]> queue = new LinkedList<>();
        int result = 0;
        
        queue.add(new int[]{numbers[0], 0});
        queue.add(new int[]{-numbers[0], 0});
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            
            if(temp[0] == target && temp[1] == numbers.length - 1) {
                result++;
                continue;
            }
            
            if(temp[1] >= numbers.length - 1) {
                continue;
            }
            
            queue.add(new int[]{temp[0] + numbers[temp[1] + 1], temp[1] + 1});
            queue.add(new int[]{temp[0] - numbers[temp[1] + 1], temp[1] + 1});
        }
        
        return result;
    }
}