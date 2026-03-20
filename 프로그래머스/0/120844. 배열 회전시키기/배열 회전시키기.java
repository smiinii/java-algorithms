class Solution {
    public int[] solution(int[] numbers, String direction) {
        int n = numbers.length;
        int[] result = new int[n];
        
        int k;
        if (direction.equals("right")) {
            k = 1;
        } else {
            k = n - 1;
        }
        
        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            result[newIndex] = numbers[i];
        }
        
        return result;
    }
}