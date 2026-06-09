import java.util.*;
class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            if(temp == ' ') {
                sb.append(" ");
                continue;
            }
            if('A' <= temp && temp <= 'Z'){
                for(int j=0;j<n;j++){
                    temp++;
                    if(temp > 'Z'){
                        temp -= ('Z' - 'A' + 1);
                    }
                }
                sb.append(temp);
            } else {
                for(int j=0;j<n;j++){
                    temp++;
                    if(temp>'z'){
                        temp -= ('z' - 'a' + 1);
                    }
                }
                sb.append(temp);
            }
        }
        return sb.toString();
    }
}