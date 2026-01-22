//  경로 찾기(백준 11403번)

/*
* - 첫 접근: 그냥 BFS 구현 문제인데 자기 자신한테 다시 돌아올 수 있어야 하네..? -> start를 visited로 하지 말자.
* */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[][] map; // input 저장용
    static List<int[]> result; // 결과 출력용
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력할게 많아 bw 이용

        // 입력값 저장
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new int[N][N];
        result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // bfs 호출
        for (int i = 0; i < N; i++) {
            bfs(i); // 각 정점당 갈 수 있는 모든 정점을 기록 후 result에 추가
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            int[] answer = result.get(i);
            for (int j = 0; j < N; j++) {
                bw.write(answer[j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();

    }
    /*
    * bfs
    * 시작 지점으로 돌아올 수 있게 start는 visited 처리 X
    * start로부터 갈 수 있는 정점을 visited에 기록 후 result에 추가
    * */
    static void bfs(int start) {
        int[] visited = new int[N];
        Arrays.fill(visited, 0);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < N; i++) {
                if (map[cur][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    queue.add(i);
                }
            }
        }
        result.add(visited);
    }


}