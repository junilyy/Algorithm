//  트리의 부모 찾기 (백준 11725번)

/*
* 첫 접근:: dfs로 구현해보자 (재귀 호출)
* -> bfs로도 가능. depth가 큰 경우 재귀 호출보다는 bfs(queue) 혹은 stack을 이용해서 구현해야함
* */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i <= N; i++) {
            List<Integer> node = new ArrayList<>();
            graph.add(node);
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        result = new int[N+1];
        visited = new boolean[N+1];
        Arrays.fill(result, -1);

        visited[1] = true;
        dfs(1, 0);

        for (int i = 2; i <= N; i++) {
            System.out.println(result[i]);
        }
    }

    static void dfs(int node, int parent) {

        for (int i = 0; i < graph.get(node).size(); i++) {
            int cur = graph.get(node).get(i);
            if (!visited[cur]) {
                visited[cur] = true;
                result[cur] = node;
                dfs(cur, node);
            }
        }
    }
}

/*
- 시간초과 코드
* class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i <= N; i++) {
            List<Integer> node = new ArrayList<>();
            graph.add(node);
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 2; i <= N; i++) {
            visited = new boolean[N+1];
            visited[1] = true;
            dfs(1, i, 0);
        }

    }

    static void dfs(int node, int target, int parent) {
        if (node == target) {
            System.out.println(parent);
        }
        else {
            for (int i = 0; i < graph.get(node).size(); i++) {
                int cur = graph.get(node).get(i);
                if (!visited[cur]) {
                    visited[cur] = true;
                    dfs(graph.get(node).get(i), target, node);
                }
            }
        }
    }
}
* */