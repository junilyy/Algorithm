//  구간 합 구하기 4 (ㅂ백준 11659번)

/*
단순 for문 계산은 시간초과 날 것 같음..
-> 바텀업과 비슷한 느낌으로 누적합을 미리 계산
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // i번째~j번째에서 i번째가 1부터 시작하므로 n+1로 생성
        int[] cumulative = new int[n+1];

        cumulative[0] = 0;

        st = new StringTokenizer(br.readLine(), " ");

        // 누적합 계산
        for (int i = 1; i <= n; i++) {
            cumulative[i] = Integer.parseInt(st.nextToken());

            if (i==1){
                continue;
            }
            else{
                cumulative[i] += cumulative[i-1];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            System.out.println(cumulative[second] - cumulative[first-1]);
        }
    }
}