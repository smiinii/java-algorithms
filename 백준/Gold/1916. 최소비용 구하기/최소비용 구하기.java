import java.util.*;

class Node implements Comparable<Node> {
    int to, cost;

    Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cityCount = sc.nextInt();
        int busCount = sc.nextInt();

        List<List<Node>> cityList = new ArrayList<>();
        for (int i = 0; i <= cityCount; i++) { cityList.add(new ArrayList<>()); }

        for (int i = 0; i < busCount; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            cityList.get(from).add(new Node(to, cost));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        int[] dist = dijkstra(cityList, cityCount, start);
        System.out.println(dist[end]);

    }
    static int[] dijkstra(List<List<Node>> cityList, int cityCount, int start) {
        int[] dist = new int[cityCount + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.to;
            int costSoFar = cur.cost;

            // 이미 더 짧은 경로가 있다면 스킵
            if (costSoFar > dist[now]) continue;

            // 현재 도시와 연결된 모든 노선 확인
            for (Node next : cityList.get(now)) {
                int newCost = costSoFar + next.cost;

                // 더 짧은 경로 발견 시 갱신
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }
        }
        return dist;
    }
}