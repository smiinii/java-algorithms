class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        for (Integer num : numbers) {
        answer += num;
        }
        return answer / numbers.length;
    }
}