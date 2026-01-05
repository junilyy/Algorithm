//  Hashing (백준 15829번)

/*
 핵심은 자료형(long), 큰 숫자 연산 시 짤리지 않게 하는게 포인트
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long hash = 0;
        long pow = 1;

        for (int i = 0; i < L; i++) {
            char c = s.charAt(i);
            int a = c - 'a' + 1;
            hash = (hash + a * pow) % 1234567891;
            pow = (pow * 31) % 1234567891;
        }

        bw.write(String.valueOf(hash));
        bw.flush();
    }
}