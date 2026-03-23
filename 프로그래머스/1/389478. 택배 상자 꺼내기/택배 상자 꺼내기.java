import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int count = 0;
        boolean isStop = false;
        int[] number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = i + 1;
        }
        
        int[][] boxs = new int[((n - 1) / w) + 1][w];
        for (int i = 0; i < ((n - 1) / w) + 1; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < w; j++) {
                    boxs[i][j] = number[count];
                    count++;
                    if(count == n) {
                        break;
                    }
                }
            } else if (i % 2 != 0) {
                for (int j = w - 1; j >= 0; j--) {
                    boxs[i][j] = number[count];
                    count++;
                    if(count == n) break;
                }
            }
        }
        
        int targetY = 0;
        int targetX =0;
        
        x:for (int i = 0; i < ((n - 1) / w) + 1; i++) {
            for (int j = 0; j < w; j++) {
                if (boxs[i][j] == num) {
                    targetY = i;
                    targetX = j;
                    break x;
                }
            }
        }
        
        for(int i=targetY; i<boxs.length;i++){
            if(boxs[i][targetX] != 0){
                answer++;
            }
        }
        
        return answer;
    }
}