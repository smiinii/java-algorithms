import java.util.*;
class Solution {
    static class Node {
        final int[] location;
        final int distance;
        
        Node(int[] location, int distance) {
            this.location = location;
            this.distance = distance;
        }
    }
    
    public int solution(int[][] maps) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[maps.length][maps[0].length];
        
        int[] x = new int[]{0, 0, 1, -1};
        int[] y = new int[]{1, -1, 0, 0};
        
        visit[0][0] = true;
        queue.offer(new Node(new int[]{0, 0}, 1)); // 시작점
        
        while(!queue.isEmpty()) { // 큐가 빌때까지 진행
            Node node = queue.poll();
            int[] location = node.location; // 현재 위치
            
            if (location[0] == maps.length - 1 &&
                location[1] == maps[0].length - 1) {
                return node.distance; // 도착
            }
            
            for(int i = 0; i < 4; i++) { // 동서남북으로 확인.
                int temp_x = location[0] + x[i];
                int temp_y = location[1] + y[i];
                
                if(maps.length <= temp_x || temp_x < 0 || // x축을 넘고
                   maps[0].length <= temp_y || temp_y < 0) { // y축을 넘고
                    continue;
                } 
                
                if(maps[temp_x][temp_y] == 0 || visit[temp_x][temp_y]) { // 장애물이 있고 방문한 것
                   continue;
                }
                
                visit[temp_x][temp_y] = true;
                queue.offer(new Node(new int[]{temp_x, temp_y}, node.distance + 1));
            }
        }
        return -1;
    }
}