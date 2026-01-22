//  Z(백준 1074번)

/*
* - 첫 접근: 1,2,3,4분면을 나눠서 재귀적으로 합하는거 같은데 구현 방법이 안떠오르네(걍 규칙 찾아서 계산)
* -> 성공(이게 왜?: 분할 정복 문제인데 재귀 호출은 안했지만 로직은 똑같이 해서 된듯)
* */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int order = 0;

        while (N >= 1){
            N = N - 1;
            double exp2 = Math.pow(2, N);

            // 1사분면
            if (r < exp2 && c >= exp2) {
                c -= exp2;
                order += (exp2 * exp2);
            }
            // 2사분면
            else if (r < exp2 && c < exp2) {
            }
            // 3사분면
            else if (r >= exp2 && c < exp2) {
                r -= exp2;
                order += (exp2 * exp2 * 2);
            }
            // 4사분면
            else if (r >= exp2 && c >= exp2) {
                r -= exp2;
                c -= exp2;
                order += (exp2 * exp2 * 3);
            }
        }

        System.out.println(order);
    }
}