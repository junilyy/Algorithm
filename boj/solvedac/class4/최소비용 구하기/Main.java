//  최소비용 구하기 (백준 1916번)

/*
* - 첫 접근: 무조건 다익스트라 알고리즘.
* - 해결: 구햔 방법 몰라서 일단 참고함. 우선순위큐 사용
* */

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost)); // 이게 핵심
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.to] < cur.cost) { // 이미 더 싼 노선인 경우 continue
                continue;
            }

            for (Node next : graph.get(cur.to)) {
                if (dist[next.to] > cur.cost + next.cost) { // 최소 비용으로 갱신
                    dist[next.to] = cur.cost + next.cost;
                    pq.add(new Node(next.to, dist[next.to])); // 다음 간선 push
                }
            }
        }
        System.out.println(dist[end]);
    }
}

class Node{
    int to, cost;

    Node(int next, int cost) {
        this.to = next;
        this.cost = cost;
    }
}