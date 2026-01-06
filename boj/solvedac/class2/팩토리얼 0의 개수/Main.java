//  팩토리얼 0의 개수(백준 1676번)

import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(countZero(n));
    }

    static int countZero(int n){
        int count5 = 0;
        for (int i = 5; i<=n; i++){
            int a = i;
            while(a%5==0){
                a /= 5;
                count5++;
            }
        }
        return count5;
    }
}


/*
실패 코드: 시간 초과
-> 재귀로 계산하지 않고 미리 배열에 저장해두면 되는거라 생각했으나 시간초과
-> 팩토리얼을 애초에 계산하지 말자

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // factorial 미리 계산
        int[] fact = new int[501];
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i < 501; i++){
            fact[i] = fact[i-1]*i;
        }
        System.out.println(countZero(fact[n]));
    }
    static int countZero(int n){
        int count = 0;

        while(n % 10 == 0){
            n /= 10;
            count++;
        }
        return count;
    }
}
*/