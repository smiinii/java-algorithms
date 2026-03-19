import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String cipher, int code) {
        List<String> result = new ArrayList<>();
        for (int i = code - 1; i < cipher.length(); i += code) {
            result.add(Character.toString(cipher.charAt(i)));
        }
        return result.stream().collect(Collectors.joining());
    }
}