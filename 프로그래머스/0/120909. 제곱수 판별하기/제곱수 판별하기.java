class Solution {
    public int solution(int n) {
        double number = Math.sqrt(n);
        if (number % 1 == 0) {
            return 1;
        }
        return 2;
    }
}