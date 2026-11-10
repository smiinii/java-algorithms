import java.util.*;
class Solution {
    static class Node {
        final int[] position;
        final int day;
        
        Node(int[] position, int day) {
            this.position = position;
            this.day = day;
        }
    }
    
    public int[] solution(String[] maps) {
        Queue<Node> queue = new ArrayDeque<>();
        int[][] visited = new int[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();
        
        for(int x = 0; x < maps.length; x++) {
            for(int y = 0; y < maps[0].length(); y++) {
                if('X' == maps[x].charAt(y)) { // 바다 인가?
                    continue;
                }
                if(visited[x][y] == 1) { // 방문 했는가? 
                    continue;
                }
                
                int[] d_x = {0, 0, 1, -1};
                int[] d_y = {1, -1, 0, 0};
                int sum = 0;
                
                visited[x][y] = 1;
                queue.offer(new Node(new int[]{x, y},
                Integer.parseInt(String.valueOf(maps[x].charAt(y)))));
                
                while(!queue.isEmpty()) {
                    Node node = queue.poll();
                    sum += node.day;
                    
                    for(int i = 0; i < 4; i++) {
                        int next_x = node.position[0] + d_x[i];
                        int next_y = node.position[1] + d_y[i];
                        
                        if(next_x < 0 || next_x >= maps.length || 
                          next_y < 0 || next_y >= maps[0].length()) { // 지도 범위 밖
                            continue;
                        }
                        
                        if('X' == maps[next_x].charAt(next_y)) { // 바다인가?
                            continue;
                        }
                        
                        if(visited[next_x][next_y] == 1) { // 방문했는가?
                            continue;
                        }
                        
                        visited[next_x][next_y] = 1;
                        queue.offer(new Node(new int[]{next_x, next_y}, 
                            Integer.parseInt(String.valueOf(maps[next_x].charAt(next_y)))));
                    }
                }
                list.add(sum);
            }
        }
        
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        if(result.length == 0) {
            return new int[]{-1};
        }
        
        Arrays.sort(result);
        return result;
    }
}