import java.util.*;
class Solution {
    public int[] solution(int n, int m) {
        int[] arr = new int[2];
        int a = n;
        while(true) {
            if(a % m == 0) {
                arr[1] = a;
                break;
            }
            a += n;
        }
        
        for(int i = n; i > 0; i--) {
            if(n % i == 0 && m % i == 0) {
                arr[0] = i;
                break;
            }
        }
        return arr;
    }
}