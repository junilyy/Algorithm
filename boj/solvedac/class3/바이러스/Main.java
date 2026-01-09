//  바이러스 (백준 2606번)

/*
첫 접근: 2차원 배열을 쓰자.
-> 각 row의 원소를 확인하며 카운트하는 메소드를 생성하려 했으나 조금 까다로움.. 해결은 BFS 사용

*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int connection = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= T; i++) list.add(new ArrayList<>());

        StringTokenizer st;

        for (int i = 0; i < connection; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            list.get(first).add(second);
            list.get(second).add(first);
        }

        boolean[] visited = new boolean[T+1];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[1] = true;
        queue.add(1);

        int count = 0;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int next : list.get(cur)){
                if (!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}