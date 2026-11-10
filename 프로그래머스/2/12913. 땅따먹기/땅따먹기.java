import java.util.*;
class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];
        
        for(int i = 0; i < land[0].length; i++) { // 1번째 행 생성
            dp[0][i] = land[0][i];
        }
        
        for(int x = 1; x < land.length; x++) { // 행
            for(int y = 0; y < 4; y++) { // 열
                int max = land[x][y]; // 최대값
                for(int index = 0; index < 4; index++) { // dp안에 3개중 최대값 찾기
                    if(index != y) { // 같은 열이 아닌 부분만 확인
                        if(max < land[x][y] + dp[x - 1][index]) { 
                            max = land[x][y] + dp[x - 1][index];
                        }
                    }
                }
                dp[x][y] = max; // dp 업데이트
            }
        }
        
        int max = 0;
        for(int i = 0; i < 4; i++) {
            if(max < dp[dp.length - 1][i]) {
                max = dp[dp.length - 1][i];
            }
        }
        return max;
    }
}