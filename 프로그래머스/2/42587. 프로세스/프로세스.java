import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(i);
            priorityQueue.offer(priorities[i]);
        }

        int order = 0;

        while (!queue.isEmpty()) {
            int index = queue.poll();

            if (priorities[index] == priorityQueue.peek()) {
                priorityQueue.poll();
                order++;

                if (index == location) {
                    return order;
                }
            } else {
                queue.offer(index);
            }
        }

        return -1;
    }
}