class Solution {
    public boolean solution(int x) {
        int n = 0;
        int temp = x;
        String strNumber = String.valueOf(x);
        
        for (int i = 0; i < strNumber.length(); i++) {
            n += temp % 10;
            temp = temp / 10;
        }
        
        if (x % n == 0) {
            return true;
        }
        
        return false;
    }
}