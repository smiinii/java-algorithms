import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; i++) {
            int temp = 100 - progresses[i];
            int result = (temp + (speeds[i] - 1)) / speeds[i];
            queue.offer(result);
        }
        
        List<Integer> result = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            int count = 1;
            
            while(!queue.isEmpty() && queue.peek() <= now) {
                queue.poll();
                count++;
            }
            
            result.add(count);
        }
        
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}