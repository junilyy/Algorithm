//  solved.ac (백준 18110번)

/*
로직 자체는 떠올리기 쉬움
but sum을 int로 했을 때 29번 line에서 자동으로 소수점을 버리는 문제 발생, sum을 double로
-> 타입에 따른 연산 결과 확인 똑바로!
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int invalidCount = (int) (0.15 * N + 0.5);

        double sum = 0;
        for (int i = invalidCount; i < N - invalidCount; i++) {
            sum += arr[i];
        }

        int result = (int) (sum / (N - 2 * invalidCount) + 0.5);
        System.out.println(result);
    }
}