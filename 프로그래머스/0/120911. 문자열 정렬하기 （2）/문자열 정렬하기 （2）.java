import java.util.*;
class Solution {
    public String solution(String my_string) {
        String lowString = my_string.toLowerCase();
        char[] array = lowString.toCharArray();
        Arrays.sort(array);
        return String.valueOf(array);
    }
}