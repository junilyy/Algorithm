//  N과 M (12) (백준 15666번)

/*
* 첫 접근: 중복된 수는 lastUsed로 해결. 비내림차순은 cur 도입으로 해결
* */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M;
    static int[] num;
    static List<Integer> visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        visited = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        backTrack(0);
        System.out.print(sb);
    }

    static void backTrack(int cur) {
        if (visited.size() == M){
            for (int i = 0; i < M; i++){
                sb.append(visited.get(i) + " ");
            }
            sb.append('\n');
            return;
        }
        else {
            int lastUsed = 0;
            for (int i = cur; i < N; i++) {
                if (lastUsed == num[i]) {
                    continue;
                }

                visited.add(num[i]);
                lastUsed = num[i];
                backTrack(i);
                visited.remove(visited.size()-1);
            }
        }
    }
}