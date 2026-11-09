import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int all = brown + yellow;

        for (int i = 3; (long) i * i <= all; i++) {
            if (all % i == 0) {
                int height = i;
                int width = all / i;

                if ((width - 2) * (height - 2) == yellow) {
                    return new int[]{width, height};
                }
            }
        }

        return new int[0];
    }
}