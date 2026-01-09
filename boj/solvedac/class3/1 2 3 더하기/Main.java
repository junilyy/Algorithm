//  1, 2, 3 더하기(백준 9095번)

/*
주어지는 정수 n의 수가 작은거보니 미리 계산해두는 느낌(바텀업)
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = new int[11];

        numbers[1] = 1;
        numbers[2] = 2;
        numbers[3] = 4;

        for (int i = 4; i < 11; i++){
            numbers[i] = numbers[i-1] + numbers[i-2] + numbers[i-3];
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(numbers[n] + "\n");
        }
        bw.flush();
        bw.close();
    }
}