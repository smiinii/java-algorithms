import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] start = new int[2];
        
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    start = new int[]{i, j};
                }
            }
        }
        
        for(int i = 0; i < routes.length; i++) {
            String[] move = routes[i].split(" ");
            
            if(move[0].equals("E")) {  
                boolean x = false;
                
                if(start[1] + Integer.parseInt(move[1]) > park[start[0]].length() - 1) { // 보드판 넘어가는지?
                    continue;
                }
                
                for(int j = start[1] + 1; j <= start[1] + Integer.parseInt(move[1]); j++) { // 장애물이 있는지?
                    if(park[start[0]].charAt(j) == 'X') {
                        x = true;
                        break;
                    }
                }
                
                if(x) {
                    continue;
                }
                
                start[1] += Integer.parseInt(move[1]);
            }
            
            if(move[0].equals("W")) {
                boolean x = false;
                
                if(start[1] - Integer.parseInt(move[1]) < 0) { // 보드판 넘어가는지?
                    continue;
                }
                
                for(int j = start[1] - 1; j >= start[1] - Integer.parseInt(move[1]); j--) { // 장애물이 있는지?
                    if(park[start[0]].charAt(j) == 'X') {
                        x = true;
                        break;
                    }
                }
                
                if(x) {
                    continue;
                }
                
                start[1] -= Integer.parseInt(move[1]);
            }
            
            if(move[0].equals("S")) {   
                boolean x = false;
                
                if(start[0] + Integer.parseInt(move[1]) > park.length - 1) { // 보드판 넘어가는지?
                    continue;
                }
                
                for(int j = start[0] + 1; j <= start[0] + Integer.parseInt(move[1]); j++) { // 장애물이 있는지?
                    if(park[j].charAt(start[1]) == 'X') {
                        x = true;
                        break;
                    }
                }
                
                if(x) {
                    continue;
                }
                
                start[0] += Integer.parseInt(move[1]);
            }
            
            if(move[0].equals("N")) { 
                boolean x = false;
                
                if(start[0] - Integer.parseInt(move[1]) < 0) { // 보드판 넘어가는지?
                    continue;
                }
                
                for(int j = start[0] - 1; j >= start[0] - Integer.parseInt(move[1]); j--) { // 장애물이 있는지?
                    if(park[j].charAt(start[1]) == 'X') {
                        x = true;
                        break;
                    }
                }
                
                if(x) {
                    continue;
                }
                
                start[0] -= Integer.parseInt(move[1]);
            }
        }
        
        return start;
    }
}