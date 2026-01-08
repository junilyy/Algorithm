//  비밀번호 찾기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String site = st.nextToken();
            String pw = st.nextToken();
            map.put(site, pw);
        }

        for (int i = 0; i < M; i++) {
            String findSite = br.readLine();
            bw.write(map.get(findSite) + "\n");
        }

        bw.flush();
        bw.close();
    }
}