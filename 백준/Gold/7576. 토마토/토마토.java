import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        final int[] next;
        final int day;

        Node(int[] next, int day) {
            this.next = next;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] box = new int[x][y];

        for(int i = 0; i < box.length; i++){
            StringTokenizer token = new StringTokenizer(br.readLine());

            for(int j = 0; j < box[0].length; j++) {
                box[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        int[][] visited = new int[x][y]; // 방문 기록
        int maxDay = 0; // 최대 일

        for(int i = 0; i < box.length; i++) {
            for(int j = 0; j < box[0].length; j++) {
                if(box[i][j] == 1) {
                    queue.offer(new Node(new int[]{i, j}, 0)); // 첫 번째로 익은 토마토
                    visited[i][j] = 1; // 첫 번째 방문
                }
            }
        }

        int[] moveX = new int[]{0, 0, 1, -1}; // 동 서 남 북
        int[] moveY = new int[]{1, -1, 0, 0}; // 동 서 남 북

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(maxDay < node.day) {
                maxDay = node.day;
            }

            for(int i = 0; i < 4; i++) {
                int nextX = node.next[0] + moveX[i]; // x축으로 이동
                int nextY = node.next[1] + moveY[i]; // y축으로 이동

                if(nextX < 0 || nextX >= x || nextY < 0 || nextY >= y) { // box를 넘어가는지
                    continue;
                }

                if(visited[nextX][nextY] == 1) { // 방문 했으면
                    continue;
                }

                if(box[nextX][nextY] == 1 || box[nextX][nextY] == -1) { // 토마토가 익었거나, 없으면
                    continue;
                }

                queue.offer(new Node(new int[]{nextX, nextY}, node.day + 1));
                box[nextX][nextY] = 1;
                visited[nextX][nextY] = 1;
            }
        }

        for(int i = 0; i < box.length; i++) {
            for(int j = 0; j < box[0].length; j++) {
                if(box[i][j] == 0) { // 안익은 토마토가 있으면
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(maxDay);
    }
}
