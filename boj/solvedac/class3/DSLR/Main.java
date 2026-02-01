//  DSLR(백준 9019번)

/*
 * - 첫 접근: depth를 1, 2, 3으로 차례때로 늘려가면서 가능한 모든 경우의 수를 실행하고 원하는 결과값이 나오는지 확인
 * - 첫 접근 문제: 시간초과 문제 + 최단경로 보장 안됨
 * - 해결 방법: bfs로 구현.
 * - 주의사항: 역방향으로 추적해야함(trace[cur] = num과 같이 정방향으로 추적시 안됨. cur은 여러 개의 num을 가질 수 있어서 값 덮어쓰기 발생)
 * */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int a, b;
    static char[] operation = {'d', 's', 'l', 'r'};
    static boolean[] visited;
    static char[] result;
    static int[] trace;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            sb = new StringBuilder();

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            bfs();
            int cur = b;
            while(cur != a){
                sb.append(result[cur]);
                cur = trace[cur];
            }
            sb.reverse();
            System.out.println(sb.toString());
        }
    }
    static void bfs(){
        int num = 0;

        visited = new boolean[10000];
        result = new char[10000];
        trace = new int[10000];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(a);
        visited[a] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == b) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                char op = operation[i];
                switch (op) {
                    case 'd':
                        num = d(cur);
                        break;
                    case 's':
                        num = s(cur);
                        break;
                    case 'l':
                        num = l(cur);
                        break;
                    case 'r':
                        num = r(cur);
                        break;
                    default:
                        break;
                }
                if (!visited[num]){
                    queue.add(num);
                    visited[num] = true;
                    trace[num] = cur;
                    result[num] = Character.toUpperCase(op);
                }
            }
        }
    }
    static int d(int n){
        int doubleN = 2 * n;
        int result = doubleN > 9999 ? doubleN % 10000 : doubleN;

        return result;
    }

    static int s(int n){
        int result = n == 0 ? 9999 : n - 1;
        return result;
    }

    static int l(int n){
        return (n % 1000) * 10 + (n / 1000);
    }

    static int r(int n){
        return (n % 10) * 1000 + (n / 10);
    }

}