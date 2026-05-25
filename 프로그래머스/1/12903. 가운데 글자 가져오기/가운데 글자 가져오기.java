class Solution {
    public String solution(String s) {
        int target = 0;
        char[] ch = s.toCharArray();
        if(ch.length % 2 == 0) {
            target = (ch.length / 2);
            return "" + ch[target - 1] + ch[target];
        } else {
            target = (ch.length / 2);
            return "" + ch[target];
        }
    }
}