//  2×n 타일링 2 (백준 11727번)

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 1<= n <= 1000
        int[] method = new int[1001];

        method[0] = 1;
        method[1] = 1;
        method[2] = 3;

        for (int i = 3; i <= n; i++) {
            // i-1은 마지막 타일이 2*1, i-2는 2*2를 놓는 경우(2*2는 1*2 두개도 돼서 *2)
            method[i] = (method[i-1] + method[i-2] * 2) % 10007;
        }

        System.out.println(method[n]);
    }
}