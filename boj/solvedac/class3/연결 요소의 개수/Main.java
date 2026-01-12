//  연결 요소의 개수(백준 11724번)

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[N+1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            graph.get(first).add(second);
            graph.get(second).add(first);
        }

        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                queue.add(i);
                visited[i] = true;
                count += 1;

                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int next : graph.get(cur)) {
                        if (!visited[next]) {
                            queue.add(next);
                            visited[next] = true;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}