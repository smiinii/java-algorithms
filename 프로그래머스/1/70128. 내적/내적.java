class Solution {
    public int solution(int[] a, int[] b) {
        int[] temp = new int[a.length];
        int result = 0;
        for(int i = 0; i < a.length; i++) {
            temp[i] = a[i] * b[i];
        }
        for(int i = 0; i < temp.length; i++) {
            result += temp[i];
        }
        return result;
    }
}