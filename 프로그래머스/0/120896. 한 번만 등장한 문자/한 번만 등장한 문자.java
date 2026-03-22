import java.util.*;
class Solution {
    public String solution(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        char[] st = s.toCharArray();
        Arrays.sort(st);
        for (char c : st) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            if (counts.get(c) == 1) {
                sb.append(c);
            }
        }
        
        if (sb.length() > 0) {
            return sb.toString();
        }
        return String.valueOf(st);
    }
}