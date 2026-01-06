//  수 찾기

/*
문제 접근: 탐색 시간을 줄이자 -> 이분 탐색
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nArray = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArray);

        int M = Integer.parseInt(br.readLine());
        int[] mArray = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            mArray[i] = Integer.parseInt(st.nextToken());
            bw.write(binarySearch(nArray, mArray[i])+"\n");
        }
        bw.flush();
        bw.close();
    }

    static int binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length - 1;

        while(left <= right){
            int mid = (left + right)/2;

            if(array[mid] == target){
                return 1;
            }
            else if(array[mid] < target){
                left = mid + 1;
            }
            else if(array[mid] > target){
                right = mid - 1;
            }
        }
        return 0;
    }
}