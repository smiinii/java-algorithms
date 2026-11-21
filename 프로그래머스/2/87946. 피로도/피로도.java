class Solution {
    public int solution(int k, int[][] dungeons) {
        int[] visit = new int[dungeons.length]; // 방문 기록
        return dfs(k, dungeons, 0, visit); // 던전 탐험 시작
    }
    
    int dfs(int k, int[][] dungeons, int clear, int[] visit) {
        int maxClear = clear; // 최대 탐험 수 
        
        for(int i = 0; i < dungeons.length; i++) {
            if(visit[i] == 1 || k < dungeons[i][0]) { // 방문 했거나 최소 피로도 조건이 안되면 패스
                continue;
            }
            
            visit[i] = 1; // 방문 기록
            
            int temp = dfs(k - dungeons[i][1], dungeons, clear + 1, visit);
            
            visit[i] = 0; // 방문 기록 해제
            
            if (temp > maxClear) { // 최대 탐험 수 업데이트
                maxClear = temp;
            }       
        }
        
        return maxClear;
    }
}