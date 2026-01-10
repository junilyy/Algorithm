//  Four Squares(백준 17626번)

/*
바텀업 방식.
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i] , dp[i-j*j] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}

/*

실패 코드(반례 n=12, 9를 빼면 3이 남는데 1,1,1보다는 4,4,4로 나뉘는게 더 최소 개수)
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double n = sc.nextDouble();
        int sqrtN = (int) Math.sqrt(n);

        double[] dp = new double[sqrtN + 1];

        dp[0] = 0;

        for (int i = 1; i <= sqrtN; i++){
            dp[i] = Math.pow(i, 2);
        }

        int count = 0;
        for (int i = sqrtN; i >= 1; i--){
            if (n - dp[i] >= 0){
                n = n - dp[i];
                count++;
            }
        }
        System.out.println(count);

    }
}
 */


