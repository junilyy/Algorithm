//  부녀회장이 될테야 (백준 2775번)

/*
키포인트는 2차원 배열을 통한 각 호수별 인원 수 계산!
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int [15][14];

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j < k+1; j++){
                for (int l = 0; l < n; l++){
                    if (j==0){
                        arr[j][l] = l + 1;
                    }
                    else if (l==0){
                        arr[j][l] = 1;
                    }
                    else{
                        arr[j][l] = arr[j][l-1] + arr[j-1][l];
                    }
                }
            }
            System.out.println(arr[k][n-1]);
        }
    }
}