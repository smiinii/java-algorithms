import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        String remember = "";
        for(int i = 0; i < words.length; i++) {    
            int member = (i + 1) % n;
            int count = (n + i) / n;
            
            if (member == 0) {
                member = n;
            }
            
            if (i > 0) {
                if(remember.charAt(remember.length() - 1) == words[i].charAt(0)) {
                    if(!set.add(words[i])) {
                        return new int[] {member, count};
                    }
                } else {
                    return new int[] {member, count};
                }
            } else {
                set.add(words[i]);
            }
            
            remember = words[i];
        }
        
        return new int[] {0, 0};
    }
}