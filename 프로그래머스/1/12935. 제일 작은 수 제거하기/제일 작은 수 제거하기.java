class Solution {
    public int[] solution(int[] arr) {
        int min = arr[0];
        if (arr.length == 1) {
            return new int []{-1};
        }
        
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        
        int [] ans = new int [arr.length - 1];
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == min) {
                continue;
            }
            ans[count++] = arr[i];
        }
        return ans;
    }
}