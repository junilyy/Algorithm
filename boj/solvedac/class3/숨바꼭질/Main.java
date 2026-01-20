//  숨바꼭질 (백준 1697번)

/*
*- 첫 접근: 각 숫자에 대해서 -1, +1, *2를 계산해서 단계 횟수 계산
*- 첫 접근 문제: 한 숫자에 대해서 -1, +1, *2를 계산하는 것이 아닌 계속 같은 연산만 반복
*- 해결: Queue를 도입해서 bfs처럼 하자.
*/

import java.sql.SQLOutput;
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 0 <= N, K <= 100000
        int[] visited = new int[100001];
        Arrays.fill(visited, -1);
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(N);
        visited[N] = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) break;

            // -1 케이스
            if ((now-1) >= 0 && visited[now - 1] == -1) {
                queue.add(now-1);
                visited[now-1] = visited[now] + 1;
            }

            // +1 케이스
            if ((now+1) <= 100000 && visited[now + 1] == -1) {
                queue.add(now + 1);
                visited[now + 1] = visited[now] + 1;
            }

            // *2 케이스
            if ((now*2) <= 100000 && visited[now * 2] == -1) {
                queue.add(now * 2);
                visited[now * 2] = visited[now] + 1;
            }
        }
        System.out.println(visited[K]);

    }
}

/*
이전 코드:
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 0 <= N, K <= 100000
        int[] visited = new int[100001];
        Arrays.fill(visited, -1);

        // 시간 초기화 및 초기값 세팅
        int a = N;
        int b = N;
        int c = N;
        visited[N] = 0;

        while(true){
            a = a - 1;
            if (a >= 0){
                if (visited[a] == -1){
                    visited[a] = visited[a + 1] + 1;
                }
            }

            b = b + 1;
            if (visited[b] == -1 && b <= 100000){
                visited[b] = visited[b - 1] + 1;
            }

            c = 2 * c;
            if (visited[c] == -1 && c <= 100000){
                visited[c] = visited[c/2] + 1;
            }

            if (visited[K] != -1){
                break;
            }
        }
        System.out.println(visited[K]);
    }
}
*/