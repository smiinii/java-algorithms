import java.util.*;
class Solution {
    
    public int solution(int n, int[][] computers) {
        int[] visited = new int[n];
        int result = 0;
        
        for(int i = 0; i < n;i++){
            if(visited[i] == 1) continue;
            result++;
            dfs(computers, i, visited);
        }
        return result;
    }
    
    private void dfs(int[][] computers, int now, int[] visited) {
        visited[now] = 1;
        for(int i=0;i<computers.length;i++){
            if(i != now && visited[i] == 0 && computers[now][i] == 1){
                dfs(computers, i, visited);
            }
        }
    }
}