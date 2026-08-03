import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < bridge_length; i++) {
            queue.offer(0);
        }
        
        int time = 0;
        int currentWeight = 0;
        int truckIndex = 0;

        while (truckIndex < truck_weights.length) {
            time++;

            currentWeight -= queue.poll();

            int nextTruck = truck_weights[truckIndex];

            if (currentWeight + nextTruck <= weight) {
                queue.offer(nextTruck);
                currentWeight += nextTruck;
                truckIndex++;
            } else {
                queue.offer(0);
            }
        }

        return time + bridge_length;
        
        
    }
}