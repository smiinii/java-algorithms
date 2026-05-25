class Solution {
    public int solution(int num) {
        int count = 0;
        long result = num;
        
        if (result == 1)
            return 0;
        
        while (count != 500) {
            
            if (result % 2 == 0) {
                result /= 2; 
                count++;
            } 
            else {
                result = (result * 3) + 1;
                count++;
            } 
            
            if (result == 1) {
                return count;
            }
        }
        return -1;
    }
}