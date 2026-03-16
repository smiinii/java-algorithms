class Solution {
    public int solution(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (str1.contains(str2)) {
                return 1;
            }
            continue;
        }
        return 2;
    }
}