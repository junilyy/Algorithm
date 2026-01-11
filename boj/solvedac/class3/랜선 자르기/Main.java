//  랜선 자르기(백준 1654번)

/*
단순히 for문을 이용해 찾으면 시간초과 -> 이분탐색 이용
1. 가장 긴 랜선을 기준으로 mid 구하고 그때의 랜선 count 계산
2. count가 N보다 크거나 같으면 mid 값 저장(후보) 후 low = mid + 1로 갱신
3. 1-2 반복

주의: 랜선의 길이가 2^31-1보다 작거나 같은 자연수 -> 계산할 때 범위가 커질 수 있으니 안전하게 double로?
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[] lan;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 이미 가지고 있는 랜선의 개수 K, 필요한 랜선의 개수 N
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        lan = new int[K];

        for(int i = 0; i < K; i++){
            lan[i] = Integer.parseInt(br.readLine());
        }

        // 가장 긴 랜선 길이 계산
        int max = lan[0];
        for (int i = 1; i < lan.length; i++) {
            max = Math.max(max, lan[i]);
        }

        long low = 1;
        long high = max;
        long answer = 0;

        while(low <= high){
            long mid = (low + high) / 2;

            if (count(mid) >= N){
                answer = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }

    static long count(long leng){
        long cnt = 0;
        for(int i = 0; i < lan.length; i++){
            cnt += (lan[i] / leng);
        }
        return cnt;
    }
}