class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[food.length];
        for(int i = 0; i < food.length; i++) {
            if(food[i] % 2 != 0) {
                arr[i] = food[i] - 1;
            } else if(food[i] % 2 == 0) {
                arr[i] = food[i];
            } else if (food[i] == 0) {
                arr[i] = food[i];
            }
        }
        
        for(int i = 1; i < arr.length; i++) {
            for(int j = 0; j < arr[i] / 2; j++) {
                sb.append(i);
            }
        }
        sb.append("0");
        for(int i = arr.length - 1; i >= 1; i--) {
            for(int j = 0; j < arr[i] / 2; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}