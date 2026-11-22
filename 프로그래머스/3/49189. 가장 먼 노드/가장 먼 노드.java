import java.util.*;
class Solution {
    class Node {
        final int number; // 현재 노드
        final int length; // 현재 노드로부터 거리
        
        Node(int number, int length) {
            this.number = number;
            this.length = length;
        }
    }
    
    public int solution(int n, int[][] edge) {
        Queue<Node> queue = new ArrayDeque<>(); // 큐 생성
        List<List<Integer>> graph = new ArrayList<>(); // 새로운 그래프
        int[] visited = new int[n + 1]; // 방문 기록
        int maxLength = 0; // 지금까지 발견한 가장 먼 거리
        int result = 0;   // 그 거리에 있는 노드 개수
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>()); // 그래프 인덱스
        }
        
        for(int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        queue.offer(new Node(1, 0));
        visited[1] = 1;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if(node.length > maxLength) { // 더 먼 노드가 발견될 때
                maxLength = node.length;
                result = 1;
            } else if(node.length == maxLength) { // 가장 먼 노드와 거리가 같을 때
                result += 1;
            }
            
            for(int next : graph.get(node.number)) { // 인덱스에 있는 모든 노드들
                if(visited[next] == 0) { // 방문 안했으면
                    visited[next] = 1; // 방문 표시
                    
                    queue.offer(new Node(next, node.length + 1));
                }
            }
        }
        return result;
    }
}