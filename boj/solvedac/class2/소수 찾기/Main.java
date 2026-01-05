//  소수 찾기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int count = 0;
        while(st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());

            if(isPrime(n)){
                count++;
            }
        }
        System.out.println(count);


    }
    static boolean isPrime(int n) {
        if (n==1){
            return false;
        }

        for (int i = 2; i<=Math.sqrt(n); i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}