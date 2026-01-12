//  나무 자르기 (백준 2805번)

/*
첫 접근: 이분탐색 이용하자
*/


import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int max = trees[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(max, trees[i]);
        }

        int answer = 0;
        int low = 0;
        int high = max;

        while(low <= high) {
            int mid = (low + high) / 2;
            if (count(mid, trees) >= M) {
                answer = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }
    static long count(int num, int[] trees) {
        long cnt = 0;
        for (int i = 0; i < trees.length; i++) {
            if (trees[i] > num) {
                cnt += trees[i] - num;
            }
        }
        return cnt;
    }
}