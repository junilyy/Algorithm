//  케빈 베이컨의 6단계 법칙

/*
* - 첫 접근: BFS로 poll 이벤트가 일어날 때마다 count 증가
* - 첫 접근 실패 이유: for문 도중 if (next == i)를 하는 것은 최단거리 보장이 아님
* - 해결 방법: bfs를 한번만 돌리되 start부터 단계에 따라 거리를 재는 배열(dist[] 도입)
* */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static List<List<Integer>> friendship;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friendship = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            friendship.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            friendship.get(first).add(second);
            friendship.get(second).add(first);
        }

        int minBacon = Integer.MAX_VALUE;
        int minBaconIndex = -1;

        for (int i = 1; i <= N; i++) {
            if (baconNum(i) < minBacon) {
                minBacon = baconNum(i);
                minBaconIndex = i;
            }
        }
        System.out.println(minBaconIndex);
    }
    static int baconNum(int start) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : friendship.get(cur)) {
                if (dist[next] == -1) { //한번도 방문 안한 경우
                    queue.add(next);
                    dist[next] = dist[cur] + 1; // 단계 증가
                }
            }
        }

        int result = 0;
        for (int val : dist) {
            result += val;
        }
        return result;
    }

    /*
    이전 코드

    static int baconNum(int start) {
        int result = 0;

        // i는 도착 유저를 나타냄
        for (int i = 1; i <= N; i++) {
            if (start == i) continue; // 본인은 skip

            int count = 0;
            visited = new boolean[N+1];

            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(start);
            visited[start] = true;

            boolean continueFlag = true;

            while (!queue.isEmpty() && continueFlag) {
                int cur = queue.poll();
                for (int next : friendship.get(cur)) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                    if (next == i){
                        continueFlag = false;
                        break;
                    }
                }
                count += 1;
            }
            System.out.println("i: " + i + ", count: " + count);
            result += count;
        }
        return result;
    }
    */
}