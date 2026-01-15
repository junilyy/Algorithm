//  과일 탕후루

/*
첫 접근: 제일 가운데 과일을 기준으로 양옆을 비교해서 count하자?? -> 시간 초과
해결: 투 포인터/슬라이딩 윈도우

*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] fruits = new int[N];

        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[10]; // 과일 수 1~9
        int kinds = 0;

        int result = 0;
        int index = 0;

        for (int i = 0; i < N; i++) {
            if (count[fruits[i]] == 0) {
                kinds++;
            }
            count[fruits[i]]++;

            while (kinds > 2){
                count[fruits[index]]--;
                if (count[fruits[index]] == 0) {
                    kinds--;
                }
                index++;
            }

            result = Math.max(result, i-index+1);
        }

        System.out.println(result);
    }
}