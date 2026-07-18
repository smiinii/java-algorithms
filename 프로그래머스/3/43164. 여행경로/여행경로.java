import java.util.*;

class Solution {
    
    private boolean[] visited;
    private String[] answer;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            int result = a[1].compareTo(b[1]);
            
            if(result == 0) {
                return a[0].compareTo(b[0]);
            }
            return result;
        });
        
        visited = new boolean[tickets.length];
        List<String> route = new ArrayList<>();
        route.add("ICN");
        
        dfs("ICN", tickets, route);

        return answer;
    }
    
    private boolean dfs(String now, String[][] tickets, List<String> route) {
        
        if (route.size() == tickets.length + 1) {
            answer = route.toArray(new String[0]);
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            if (!tickets[i][0].equals(now)) {
                continue;
            }
            
            visited[i] = true;
            route.add(tickets[i][1]);
            
            if (dfs(tickets[i][1], tickets, route)) {
                return true;
            }

            route.remove(route.size() - 1);
            visited[i] = false;
        }
        
        return false;
    }
}