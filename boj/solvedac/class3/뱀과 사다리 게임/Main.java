//  뱀과 사다리 게임 (백준 16928번)

/*
* 첫 접근: 정렬 or 투포인터
* 첫 접근 실패: 정렬, 투포인터를 고려했을 때 주사위를 던지는 횟수 고려가 힘듬
* 문제 해결 : bfs를 이용하자. 기존 direction처럼 주사위는 x+1~+6으로 생각
*
* */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ladderNum = Integer.parseInt(st.nextToken());
        int snakeNum = Integer.parseInt(st.nextToken());

        // laddder, snake 값 저장
        int[] ladders = new int[101];
        int[] snakes = new int[101];

        for (int i = 0; i < ladders.length; i++) {
            ladders[i] = -1;
            snakes[i] = -1;
        }

        for (int i = 0; i < ladderNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladders[a] = b;
        }

        for (int i = 0; i < snakeNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            snakes[a] = b;
        }

        // bfs
        int[] dice = {1, 2, 3, 4, 5, 6}; // 주사위를 던져 이동할 수 있는 칸
        int[] visited = new int[101];

        Arrays.fill(visited, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for (int i = 0; i < 6; i++){
                int next = cur + dice[i];

                if (next > 100){
                    continue;
                }

                if (ladders[next] != -1){
                    next = ladders[next];
                }
                else if (snakes[next] != -1){
                    next = snakes[next];
                }

                if (visited[next] == -1){
                    queue.add(next);
                    visited[next] = visited[cur] + 1;
                }

            }

        }
        System.out.println(visited[100]);

    }
}