//  패션왕 신해빈(백준 9375번)

/*
단순 경우의 수 문제.
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String clothNmae = st.nextToken(); // 얘는 굳이 안씀
                String clothType = st.nextToken();

                map.put(clothType, map.getOrDefault(clothType, 0) + 1);

            }
            int clothCount = 1;
            for (int cnt : map.values()){
                clothCount *= (cnt + 1);
            }
            System.out.println(clothCount - 1);
        }

    }
}