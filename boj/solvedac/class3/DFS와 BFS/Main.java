//  DFS와 BFS

/*
단순 BFS, DFS 구현 문제
(DFS 구현 시 재귀 활용, 이 문제는 N<=1000이므로 무리 없으나 깊이가 클 때를 고려해 스택 방식의 구현 연습 필요!)

오류 발생: DFS에서 visted 배열을 생성하니까 재귀 호출마다 계속 재생성되는 문제 발생 -> visited를 전역으로 번경
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static List<List<Integer>> map;
    static BufferedWriter bw;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a);
        }

        // 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(map.get(i));
        }

        // dfs
        visited = new boolean[N+1]; // visited 초기화
        dfs(start);

        // 개행 문자
        bw.write("\n");

        // bfs
        visited = new boolean[N+1]; // visited 초기화
        bfs(start);

        bw.flush();
        bw.close();
    }

    static void dfs(int start) throws IOException{
        visited[start] = true;

        bw.write(start + " ");

        for (int next : map.get(start)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) throws IOException {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        visited[start] = true;
        bw.write(start + " ");

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : map.get(cur)) {
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    bw.write(next + " ");
                }
            }
        }

    }
}