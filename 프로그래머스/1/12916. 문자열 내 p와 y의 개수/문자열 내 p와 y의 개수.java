class Solution {
    boolean solution(String s) {
        String[] strArr = s.split("");
        int pCount = 0;
        int yCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (strArr[i].equals("p") || strArr[i].equals("P")) {
                pCount++;
            }
            if (strArr[i].equals("y") || strArr[i].equals("Y")) {
                yCount++;
            }
        }
        return pCount == yCount;
    }
}