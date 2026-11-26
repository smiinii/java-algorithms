import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        final int now;
        final int weight;

        Node(int now, int weight) {
            this.now = now;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken()); // 노드 개수 입력 받기
        int findCount = Integer.parseInt(st.nextToken()); // 찾고 싶은 쌍의 개수 입력 받기

        int[][] link = new int[findCount][2]; // 찾고 싶은 노드 쌍 저장 배열
        List<List<Node>> nodes = new ArrayList<>(); // 노드 트리

        for(int i = 0; i < nodeCount; i++) {
            nodes.add(new ArrayList<>()); // 1~n
        }

        for(int i = 0; i < nodeCount - 1; i++) { // 노드 개수 - 1개 입력 받기
            StringTokenizer token = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(token.nextToken()) - 1; // 시작 노드
            int next = Integer.parseInt(token.nextToken()) - 1; // 종료 노드
            int weight = Integer.parseInt(token.nextToken()); // 노드 사이의 거리
            nodes.get(now).add(new Node(next, weight)); // 노드 단방향
            nodes.get(next).add(new Node(now, weight)); // 노드 역방향
        }

        for(int i = 0; i < findCount; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            link[i][0] = Integer.parseInt(token.nextToken()) - 1; // 시작 노드 입력 받기
            link[i][1] = Integer.parseInt(token.nextToken()) - 1; // 종료 노드 입력 받기
        }

        for(int n = 0; link.length > n; n++) { // 찾아야 하는 쌍 만큼
            Queue<Node> queue = new ArrayDeque<>();
            int[] visited = new int[nodeCount + 1];

            queue.offer(new Node(link[n][0], 0)); // 큐 적재
            visited[link[n][0]] = 1; // 방문 기록

            while(!queue.isEmpty()) {
                Node node = queue.poll();

                if(node.now == link[n][1]) { // 목적지에 도착하면 누적 거리 출력
                    System.out.println(node.weight);
                    break;
                }

                for(int i = 0; i < nodes.get(node.now).size(); i++) {
                    Node nextNode = nodes.get(node.now).get(i); // 다음 노드

                    if(visited[nextNode.now] == 1) { // 방문 여부
                        continue;
                    }

                    visited[nextNode.now] = 1; // 방문 기록
                    queue.offer(new Node(nextNode.now, node.weight + nextNode.weight));
                }
            }
        }

    }
}
