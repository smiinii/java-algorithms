class Solution {
    public int solution(int hp) {
        int answer = 0;
        int hight = hp / 5;
        int temp1 = hp % 5;
        int middle = temp1 / 3;
        int temp2 = temp1 % 3;
        int bottom = temp2 / 1;
        return hight + middle + bottom;
    }
}