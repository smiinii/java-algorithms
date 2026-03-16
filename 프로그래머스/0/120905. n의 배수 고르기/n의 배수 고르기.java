class Solution {
    public int[] solution(int n, int[] numlist) {
        int count = 0;
        for (int num : numlist) {
            if (num % n == 0) {
                count++;
            }
            continue;
        }
        int[] answer = new int[count];
        int index = 0;
        for (int num : numlist) {
            if (num % n == 0) {
                answer[index++] = num;
            }
            continue;
        }
        return answer;
    }
}