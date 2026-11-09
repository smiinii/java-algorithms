class Solution {
    public long solution(int n) {
        long[] arr = new long[n];
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                arr[i] = 1;
                continue;
            } 
            
            if(i == 1) {
                arr[i] = 2;
                continue;
            }
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
        }
        return (long) arr[n - 1];
    }
}