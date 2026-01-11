//  잃어버린 괄호 (백준 1541번)

/*
최소가 되는 경우는 -를 기준으로 분리 후 나머지 숫자 계산
ex/ 55-50+40-50+40 -> 55 - (50+40) - (50+40)

기억! 정규식(.+*?^$()[]{}|\)을 기준으로 split하고 싶으면 \\를 붙여야 함.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split("-");

        int sum = 0;

        for (int i = 0; i < line.length; i++) {
            String[] number = line[i].split("\\+");
            int num = 0;
            for (int j = 0; j < number.length; j++) {
                num += Integer.parseInt(number[j]);
            }
            if (i==0){
                sum += num;
            }
            else{
                sum -= num;
            }
        }
        System.out.println(sum);

    }
}