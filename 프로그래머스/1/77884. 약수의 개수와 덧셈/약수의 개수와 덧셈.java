class Solution { 
    static int cal(int num) {
        int count = 1; 
        for (int i= 1; i <= num / 2; i++) 
            if (num % i == 0)
                count++;
        return count;
    }
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i<= right; i++) {
            if (cal(i) % 2 == 0)
                answer += i;
            else 
                answer -= i;
        }
        return answer;
    }
}