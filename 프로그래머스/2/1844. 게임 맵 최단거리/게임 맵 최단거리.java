import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        int[] target = new int[]{maps.length - 1, maps[0].length - 1};
        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, 1, -1};
        int[][] visited = new int[maps.length][maps[0].length];
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = 1;
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            
            if(temp[0] == target[0] && temp[1] == target[1]) {
                return temp[2];
            }
            
            for(int i = 0; i < 4; i++) {
                int newX = temp[1] + x[i];
                int newY = temp[0] + y[i];
                
                if(0 <= newX && newX < maps[0].length && 0 <= newY && newY < maps.length && 
                 maps[newY][newX] == 1 && visited[newY][newX] == 0) {
                    queue.add(new int[]{newY, newX, temp[2] + 1});
                    visited[newY][newX] = 1;
                }
            }
        }
        return -1;
    }
}