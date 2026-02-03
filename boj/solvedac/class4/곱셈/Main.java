//  곱셈 (백준 1629번)

/*
* - 첫 접근: 자료형 관련 문제, 나누기를 적절하게 계속할 것
* - 문제: 시간초과 발생 -> b가 21억번까지 올 수 있어서 for문이 21억번..
* - 해결: 분할정복 10^11 = 10^5 * 10^6  = .... % 연산 진짜 잘 활용해야함 (어떻게 썼는지 잘 확인하기)
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        System.out.println(pow(a,b,c));
    }

    static long pow(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        long temp = pow(a, b / 2, c);

        if (b % 2 == 0) {
            return temp * temp % c ;
        }
        else {
            return ((temp * temp % c) * (a % c)) % c;
        }
    }
}