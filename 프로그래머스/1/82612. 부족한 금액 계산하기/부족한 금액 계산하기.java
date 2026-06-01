import java.util.*;
class Solution {
    public long solution(int price, int money, int count) {
        long temp = 0;
        for(int i = 1; i <= count; i++) {
            temp += price * i;
        }
        if(money - temp >= 0)
            return 0;
        else
            return Math.abs(temp - money);
    }
}