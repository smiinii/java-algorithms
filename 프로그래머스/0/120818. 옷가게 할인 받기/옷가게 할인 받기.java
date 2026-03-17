class Solution {
    public int solution(int price) {
        double answer = price;
        if ( 100000 <= price && price < 300000) {
            answer = price - (price * 0.05);
        } else if ( 300000 <= price && price < 500000) {
            answer = price - (price * 0.1);
        } else if (500000 <= price) {
            answer = price - (price * 0.2);
        }
        return (int)answer;
    }
}