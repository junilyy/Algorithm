//  N과 M (9) (백준 15663번)

/*
* 첫 접근: 백트래킹 문제, but 중복된 수 제거를 어떻게? -> 문제 풀어본 결과 중복 제거 필요없음!
* 중복 제거 방법: 1. List -> Set -> List
*         2. TreeSet
*         3. .distinct().sorted()
* 고려사항: 중복된 수를 제거하는게 아니라 중복된 수열을 제거해야함 (ex/ 9 7 9 1에서 9 9가 가능)
*    -> check 배열로 해당 인덱스를 이용했는지 확인, 그리고 lastUsed로 해당 depth에서 해당 값이 중복되지 않게 방지
* */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M;
    static int[] num;
    static List<Integer> visited;
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        visited = new ArrayList<>();
        check = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        backTrack();
        System.out.print(sb);
    }

    static void backTrack() {
        if (visited.size() == M){
            for (int i = 0; i < M; i++){
                sb.append(visited.get(i) + " ");
            }
            sb.append('\n');
            return;
        }
        else {
            int lastUsed = 0;
            for (int i = 0; i < N; i++) {
                if (lastUsed == num[i]) {
                    continue;
                }
                if (check[i]) {
                    continue;
                }
                check[i] = true;
                visited.add(num[i]);
                lastUsed = num[i];
                backTrack();
                visited.remove(visited.size()-1);
                check[i] = false;
            }
        }
    }
}