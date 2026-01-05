//  팰린드롬수 (백준 1259번)

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String num = br.readLine();
            if(num.equals("0")) break;

            if (isPelindrom(num)){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }

        }

    }
    static boolean isPelindrom(String num){
        for (int i = 0; i < num.length()/2; i++) {
            if (num.charAt(i) == num.charAt(num.length()-1-i)) {
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}