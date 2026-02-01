//  이중 우선순위 큐 (백준 7662번)

/*
* - 첫 접근: Deque 선언 후 정렬 -> 앞,뒤 양 끝에서 삽입-삭제 연산 수행
* - 첫 접근 문제: Deque 자체는 정렬이 안됨 Deque를 List로 변환해서 정렬 후 다시 Deque로 바꿔야함
* - 해결 방법:
*   1. PQ를 두개 쓴다. -> 동기화 문제 해결 필요(이거 했다가 동기화 어려워서 포기)
*   2. TreeMap을 쓴다. -> Map 자체에서 최대,최소 바로 접근 가능
* */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                char op = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                switch (op) {
                    case 'I':
                        map.put(num, map.getOrDefault(num, 0) + 1);
                        break;
                    case 'D':
                        // 최댓값 삭제
                        if (!map.isEmpty()) {
                            if (num == 1) {
                                int max = map.lastKey();
                                if (map.get(max) == 1) {
                                    map.remove(max);
                                }
                                else {
                                    map.put(max, map.get(max) - 1);
                                }
                            }
                            // 최솟값 삭제
                            else if (num == -1) {
                                int min = map.firstKey();
                                if (map.get(min) == 1) {
                                    map.remove(min);
                                }
                                else {
                                    map.put(min, map.get(min) - 1);
                                }
                            }
                        }
                        break;
                }
            }

            if (map.isEmpty()) {
                System.out.println("EMPTY");
            }
            else {
                System.out.println(map.lastKey()+ " " + map.firstKey());
            }
        }
    }
}