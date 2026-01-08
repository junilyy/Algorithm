//  집합 (백준 11723번)

/*
자바 기준으로 단순한 collecgtion 메소드 사용 문제 -> 메소드 기억
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String  op = st.nextToken();
            int num = 0;
            int index = 0;
            if (st.hasMoreTokens()) num = Integer.parseInt(st.nextToken());

            switch(op){
                case "add":
                    if(!numbers.contains(num)){
                        numbers.add(num);
                    }
                    break;
                case "remove":
                    if(numbers.contains(num)){
                        index = numbers.indexOf(num);
                        numbers.remove(index);
                        // -> numbers.remove((Integer) num); 으로도 가능
                    }
                    break;
                case "check":
                    if(numbers.contains(num)){
                        bw.write("1\n");
                    }
                    else{
                        bw.write("0\n");
                    }
                    break;
                case "toggle":
                    if(numbers.contains(num)){
                        index = numbers.indexOf(num);
                        numbers.remove(index);
                    }
                    else{
                        numbers.add(num);
                    }
                    break;
                case "all":
                    numbers.clear();
                    for (int j = 1; j <= 20; j++) numbers.add(j);
                    break;
                case "empty":
                    numbers.clear();
                    break;
            }
        }
        bw.flush();
        bw.close();
    }

}