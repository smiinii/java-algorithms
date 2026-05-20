class Solution {
    public long solution(long n) {
        long answer = 0;
        long temp = 1;
        while(true) {
            if (temp * temp > n) {
                break;
            } 
            if (temp * temp == n) {
                return (temp + 1) * (temp + 1);
            }
            temp++;
        }
        return -1;
    }
}