//  회의실 배정(백준 1931번)

/*
* 첫 접근: 일단 입력값을 배열에 저장한 후 끝나는 시간 순으로 정렬(끝나는 시간이 같을 경우 시작 시간이 빠른 경우)
* */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        int N = Integer.parseInt(br.readLine());

        int[][] schedule = new int[N][2];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        // 정렬(회의 끝나는 시간 오름차순, 동일할 땐 시작 시간 오름차순)
        Arrays.sort(schedule, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int count = 1;
        int finish = schedule[0][1];

        for (int i = 1; i < N; i++) {
            // 회의 시작 시간이 이전 회의 끝나는 시간 이후인 경우
            if (schedule[i][0] >= finish) {
                // 회의 개수 증가 및 회의 끝나는 시간 재세팅
                count += 1;
                finish = schedule[i][1];
            }
        }
        System.out.println(count);
    }
}