class Solution {
    int result;
    
    public int solution(int[] numbers, int target) {
        result = 0;
        
        dfs(numbers, target, 0, 0);
        
        return result;
    }
    
    void dfs(int[] numbers, int target, int index, int sum) {
        if(index == numbers.length) {
            if(sum == target) {
                result += 1;
                return;
            }
            return;
        }
        dfs(numbers, target, index + 1, sum + numbers[index]);
        dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}