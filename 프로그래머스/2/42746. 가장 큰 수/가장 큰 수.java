import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(str, (a, b) -> {
            return (b + a).compareTo(a + b); 
        });
        
        if (str[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (String token : str) {
            sb.append(token);
        }
        
        return sb.toString();
    }
}