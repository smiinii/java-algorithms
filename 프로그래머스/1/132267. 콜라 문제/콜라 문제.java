class Solution {
    public int solution(int a, int b, int n) {
        int result = 0;
        while(n >= a) {
            int newCola = (n / a) * b;
            int restBottle = n % a;
            result += newCola;
            n = newCola + restBottle;
        }
        return result;
    }
}