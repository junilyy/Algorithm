//  FizzBuzz

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        if (isNumber(a)){
            System.out.println(fizzBuzz(Integer.parseInt(a)+3));
        }
        else if (isNumber(b)){
            System.out.println(fizzBuzz(Integer.parseInt(b)+2));
        }
        else if (isNumber(c)){
            System.out.println(fizzBuzz(Integer.parseInt(c)+1));
        }
    }

    static boolean isNumber(String s){
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    static String fizzBuzz(int n) {
        if (n % 3 == 0 && n % 5 == 0) {
            return "FizzBuzz";
        }
        else if (n % 3 == 0) {
            return "Fizz";
        }
        else if (n % 5 == 0) {
            return "Buzz";
        }
        else {
            return String.valueOf(n);
        }
    }
}