//  A → B (백준 16953번)

/*
* 첫 접근: 1부터 시작해서 각 연산을 수행한 후 해당 배열 index에 연산값 저장(dp)
* 문제: b가 10^9까지 가능해서 배열을 선언시 메모리 초과
* 문제 해결 방법: a -> b가 아닌 b -> a로 한다. (bfs로도 가능하나 굳이..?)
* */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = 0;

        while (b > a){
            if (b % 2 == 0){
                b = b / 2;
                count++;
            }
            else if (b % 10 == 1){
                b = b / 10;
                count++;
            }
            else {
                break;
            }
        }

        if (b == a) {
            System.out.println(count + 1);
        }
        else {
            System.out.println(-1);
        }
    }
}
/*
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] dp = new int[b+1];
        Arrays.fill(dp, -1);

        dp[a] = 1;
        for (int i = a; i <= b; i++) {
            if (dp[i] != -1) {
                int mul2 = i * 2;
                int right1 = i * 10 + 1;

                if (mul2 <= b){
                    dp[mul2] = dp[i] + 1;
                }
                if (right1 <= b){
                    dp[right1] = dp[i] + 1;
                }
            }
        }

        System.out.println(dp[b]);
    }
}
* */