//  ATM (백준 11399)

/*
첫 문제 접근: 인출하는데 걸리는 시간이 제일 적은 사람 순으로 정렬

*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(people);

        System.out.println(countWait(people));
    }

    static int countWait(int[] people) {
        int sum = 0;
        int len = people.length;
        for (int i = 0; i < people.length; i++) {
            sum += people[i] * len;
            len = len - 1;
        }
        return sum;
    }
}