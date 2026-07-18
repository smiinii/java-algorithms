import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n];
        
        for(int i = 0; i < n; i++) {
            
            if(visited[i] == 1) {
                continue;
            }
            
            queue.add(i);
            visited[i] = 1;
            
            while(!queue.isEmpty()) {
                int target = queue.poll();
                
                for(int j = 0; j < n; j++) {
                    if (computers[target][j] == 1 && visited[j] == 0) {
                        visited[j] = 1;
                        queue.add(j);
                    }
                }
            }
            result++;
        }
        return result;
    }
}