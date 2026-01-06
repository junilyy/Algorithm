//  덩치(백준 7568)

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        int[] rank = new int[n];
        Arrays.fill(rank, 1);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (i==j) continue;

                if (arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]) {
                    rank[i] += 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(rank[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}