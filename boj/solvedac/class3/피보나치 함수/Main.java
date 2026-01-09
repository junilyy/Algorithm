//  피보나치 함수 (백준 1003번)

/*
재귀쓰면 시간 초과, 입력 숫자의 범위가 40까지인걸 보면 미리 계산해두라는 뜻
-> 바텀업 이용
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] fibo = new int[2][41];

        // 입력 숫자가 0일 때
        fibo[0][0] = 1;
        fibo[1][0] = 0;

        // 입력 숫자가 1일 때
        fibo[0][1] = 0;
        fibo[1][1] = 1;

        for (int i=2; i<=40; i++) {
            fibo[0][i] = fibo[0][i-2] + fibo[0][i-1];
            fibo[1][i] = fibo[1][i-2] + fibo[1][i-1];
        }

        int testNum = 0;

        for (int i = 0; i < T; i++){
            testNum = Integer.parseInt(br.readLine());
            bw.write(fibo[0][testNum] + " " + fibo[1][testNum] + "\n");
        }
        bw.flush();
        bw.close();
    }
}