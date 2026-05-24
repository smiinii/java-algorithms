import java.util.*;
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int[] intArr = new int[absolutes.length];
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i] == true) {
                intArr[i] = absolutes[i];
            } else {
                intArr[i] = - absolutes[i];
            }
        }
        return Arrays.stream(intArr).sum();
    }
}