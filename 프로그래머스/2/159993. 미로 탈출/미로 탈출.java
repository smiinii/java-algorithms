import java.util.*;
class Solution {
    static class Node {
        final int[] position;
        final int distance;
        
        Node(int[] position, int distance) {
            this.position = position;
            this.distance = distance;
        }
    }
    
    public int solution(String[] maps) {
        Queue<Node> queue = new ArrayDeque<>();
        int[][] visited = new int[maps.length][maps[0].length()]; // 방문 기록
        int distance = 0; // 총 거리 저장소
        int lever_x = 0;
        int lever_y = 0;
        
        int[] start = {0, 0};
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                if('S' == (maps[i].charAt(j))) {
                    start = new int[]{i, j};
                    break;
                }
            }
        }
        
        visited[start[0]][start[1]] = 1;
        queue.offer(new Node(start, 0)); // 위치, 이동거리
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            int[] x = {0, 0, 1, -1};
            int[] y = {1, -1, 0, 0};
            
            if('L' == (maps[node.position[0]].charAt(node.position[1]))) { // 레버인지?
                distance = node.distance;
                lever_x = node.position[0];
                lever_y = node.position[1];
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int next_x = node.position[0] + x[i];
                int next_y = node.position[1] + y[i];
                
                if(next_x < 0 || next_x >= maps.length || 
                   next_y < 0 || next_y >= maps[0].length()) { // 보드판을 넘었는지?
                    continue;
                }
                
                if('X' == (maps[next_x].charAt(next_y))) { // 벽인지? 
                    continue;
                }
                
                if(visited[next_x][next_y] == 1) { // 방문했는지?
                    continue;
                }
                
                visited[next_x][next_y] = 1; // 방문처리
                queue.offer(new Node(new int[]{next_x, next_y}, node.distance + 1)); // 이동
            }
        }
        
        if(distance == 0) {
            return -1;
        }
        
        Queue<Node> exit_queue = new ArrayDeque<>();
        int[][] exit_visited = new int[maps.length][maps[0].length()]; // 방문 기록
        
        exit_visited[lever_x][lever_y] = 1;
        exit_queue.offer(new Node(new int[]{lever_x, lever_y}, 0)); // 위치, 이동거리
        
        while(!exit_queue.isEmpty()) {
            Node node = exit_queue.poll();
            
            int[] x = {0, 0, 1, -1};
            int[] y = {1, -1, 0, 0};
            
            if('E' == (maps[node.position[0]].charAt(node.position[1]))) { 
                return distance + node.distance;
            }
            
            for(int i = 0; i < 4; i++) {
                int next_x = node.position[0] + x[i];
                int next_y = node.position[1] + y[i];
                
                if(next_x < 0 || next_x >= maps.length || 
                   next_y < 0 || next_y >= maps[0].length()) { // 보드판을 넘었는지?
                    continue;
                }
                
                if('X' == (maps[next_x].charAt(next_y))) { // 벽인지? 
                    continue;
                }
                
                if(exit_visited[next_x][next_y] == 1) { // 방문했는지?
                    continue;
                }
                
                exit_visited[next_x][next_y] = 1; // 방문처리
                exit_queue.offer(new Node(new int[]{next_x, next_y}, node.distance + 1)); // 이동
            }
        }
        
        return -1;
    }
}