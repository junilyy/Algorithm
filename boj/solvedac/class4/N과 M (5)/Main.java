//  N과 M (5) (백준 15654번)

import java.util.*;
import java.lang.*;
import java.io.*;

/*
* - 첫접근: 전형적인 백트래킹 문제
* - 주의사항: StringBuilder에 공백을 append할 때 + ' ' 대신 + " "을 할 것
*           ' '는 char로 인식해서 int + ' '로 하게 되면 char의 아스키코드값과 int + 연산을 해버림
* */
class Main {

    static int N, M;
    static int[] num;
    static List<Integer> visited;

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

        backTrack();

    }

    static void backTrack() {
        if (visited.size() == M){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++){
                sb.append(visited.get(i) + " ");
            }
            sb.append('\n');
            System.out.print(sb);
            return;
        }
        else {
            for (int i = 0; i < N; i++) {
                if (visited.contains(num[i])) {
                    continue;
                }
                visited.add(num[i]);
                backTrack();
                visited.remove(visited.size()-1);
            }
        }
    }
}