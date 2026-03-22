import java.util.Arrays;
class Solution {
    public int solution(String before, String after) {
        char[] beforeChars = before.toCharArray();
        char[] afterChars = after.toCharArray();

        Arrays.sort(beforeChars);
        Arrays.sort(afterChars);
        
        if (Arrays.equals(beforeChars, afterChars)) {
            return 1;
        }
        return 0;
    }
}