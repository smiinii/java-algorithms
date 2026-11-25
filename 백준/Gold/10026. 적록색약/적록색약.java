import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        final int[] point;
        final String color;

        Node(int[] point, String color) {
            this.point = point;
            this.color = color;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken()); // 가로 세로 값
        String[][] board = new String[length][length]; // 보드판

        for(int x = 0; x < length; x++) {
            StringTokenizer token = new StringTokenizer(br.readLine()); // 한 줄씩 읽으며
            String[] temp = token.nextToken().split(""); // 한 글자씩 짤라
            for(int y = 0; y < length; y++) {
                board[x][y] = temp[y]; // 보드판에 한개씩 넣기
            }
        }

        Queue<Node> queue = new ArrayDeque<>(); // 큐 등록
        int[][] visited = new int[length][length]; // 방문 기록
        int nCount = 0; // 적록색약이 아닌 사람 영역
        int mCount = 0; // 적록색약인 사람 영역

        int[] x = new int[]{0, 0, 1, -1}; // x 이동 좌표
        int[] y = new int[]{1, -1, 0, 0}; // y 이동 좌표

        for(int i = 0; i < length; i++) { // 적록색약이 아닌 사람
            for(int j = 0; j < length; j++) {
                if(visited[i][j] != 1) { // 방문을 안했으면
                    queue.offer(new Node(new int[]{i, j}, board[i][j])); // 시작점
                    visited[i][j] = 1; // 방문 기록

                    while(!queue.isEmpty()) {
                        Node node = queue.poll();

                        for(int d = 0; d < 4; d++) {
                            int nextX = node.point[0] + x[d]; // 다음 좌표
                            int nextY = node.point[1] + y[d]; // 다음 좌표

                            if(nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length) { // 보드를 넘어가면
                                continue;
                            }

                            if(visited[nextX][nextY] == 1) { // 방문 했으면
                                continue;
                            }
                            if(!board[node.point[0]][node.point[1]].equals(board[nextX][nextY])) { // 주변이 같지 않으면
                                continue;
                            }
                            visited[nextX][nextY] = 1; // 방문 기록
                            queue.offer(new Node(new int[]{nextX, nextY}, board[nextX][nextY])); // 큐 삽입
                        }
                    }
                    nCount++; // 영역 하나 추가
                }
            }
        }

        visited = new int[length][length]; // 방문 초기화

        for(int i = 0; i < length; i++) { // 적록색약인 아닌 사람
            for(int j = 0; j < length; j++) {
                if(visited[i][j] != 1) { // 방문을 안했으면
                    queue.offer(new Node(new int[]{i, j}, board[i][j])); // 시작점
                    visited[i][j] = 1; // 방문 기록

                    while(!queue.isEmpty()) {
                        Node node = queue.poll();

                        for(int d = 0; d < 4; d++) {
                            int nextX = node.point[0] + x[d]; // 다음 좌표
                            int nextY = node.point[1] + y[d]; // 다음 좌표

                            if(nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length) { // 보드를 넘어가면
                                continue;
                            }

                            if(visited[nextX][nextY] == 1) { // 방문 했으면
                                continue;
                            }

                            if(!board[node.point[0]][node.point[1]].equals(board[nextX][nextY])) { // 주변이 같지 않으면
                                if((board[node.point[0]][node.point[1]].equals("R") && board[nextX][nextY].equals("G")) ||
                                        (board[node.point[0]][node.point[1]].equals("G") && board[nextX][nextY].equals("R"))) { // 현재 레드이면서 다음이 그린이면 또는 반대이면
                                    queue.offer(new Node(new int[]{nextX, nextY}, board[nextX][nextY])); // 큐 삽입
                                } else {
                                    continue;
                                }
                            }

                            visited[nextX][nextY] = 1; // 방문 기록
                            queue.offer(new Node(new int[]{nextX, nextY}, board[nextX][nextY])); // 큐 삽입
                        }
                    }
                    mCount++; // 영역 하나 추가
                }
            }
        }

        System.out.println(nCount + " " + mCount);
    }
}
