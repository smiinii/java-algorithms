import java.util.*;
class Solution {
    class State {
        final int node; // 도착 마을
        final int cost; // 누적 비용
        
        State(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        Queue<State> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost)); // 작은 순 큐
        int[] visited = new int[N + 1]; // 방문 기록
        int result = 0; // 갈 수 있는 마을 개수
        
        List<List<State>> graph = new ArrayList<>();
        
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < road.length; i++) {
            int start = road[i][0];
            int end = road[i][1];
            int cost = road[i][2];
            
            graph.get(start).add(new State(end, cost));
            graph.get(end).add(new State(start, cost));
        }
        
        queue.offer(new State(1, 0)); // 1번 마을에서 시작
        
        while(!queue.isEmpty()) {
            State temp = queue.poll();
            
            if (visited[temp.node] == 1) { // 방문 했으면 패스
                continue;
            }

            visited[temp.node] = 1; // 방문 기록
            
            if(temp.cost <= K) { // 목표 보다 이하인가?
                result++;
            }
            
            for(int i = 0; i < graph.size(); i++) { // 큐에 넣기
                if(i == temp.node) {
                    for(int j = 0; j < graph.get(i).size(); j++) {
                        queue.offer(new State(graph.get(i).get(j).node, temp.cost + graph.get(i).get(j).cost));
                    }
                }
            }
        }
        return result;
    }
}