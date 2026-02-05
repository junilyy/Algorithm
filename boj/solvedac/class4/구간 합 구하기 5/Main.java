//  구간 합 구하기 5 (백준 11660번)

/*
* - 첫 접근: 1,1부터 시작해서 합을 퍼뜨려나가기. 이후 완성된 합 table을 가지고 계산
* - 문제: 이렇게 하는건 맞는거 같은데 계산을 어떡하지..
* - 해결: 드모르간 법칙 마냥 각 영역 더하고 중복해서 더한 영역 빼주고 하면 됨
* */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] table = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // (1,1)부터 시작되는 누적합 계산
        int[][] sum = new int[N+1][N+1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(sum[i], 0);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + table[i][j];
            }
        }

        // 결과값 계산
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());
            int endRow = Integer.parseInt(st.nextToken());
            int endCol = Integer.parseInt(st.nextToken());

            int result = sum[endRow][endCol] - sum[endRow][startCol - 1] - sum[startRow - 1][endCol] + sum[startRow-1][startCol - 1];
            System.out.println(result);
        }


    }
}