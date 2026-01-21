//  IOIOI(백준 5525번)

/*
* - 첫 접근: P_N 문자열 만들고 입력받은 문자열을 같은 크기만큼 짤라내서 비교
* - 첫 접근 시도 후 50점: 시간초과 문제 같음.. 어떻게 연산을 줄이지 -> 슬라이딩 윈도우
* */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String line = br.readLine();

        int count = 0;
        int result = 0;

        for (int i = 0; i < line.length() - 2; i++) {
            // IOI 찾기
            if (line.charAt(i) == 'I' && line.charAt(i + 1) == 'O' && line.charAt(i + 2) == 'I') {
                count++;
                if (count == N) {
                    result++;
                    count--;
                }
                i+=1;
            }
            else {
                count = 0;
            }
        }
        System.out.println(result);
    }
}

/*
실패 코드 1 : 문자열로 접근

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String line = br.readLine();

        // P_N 문자열 만들기
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append("I");
            sb.append("O");
        }
        sb.append("I");

        int count = 0;
        for (int i = 0; i <= (M - sb.length()) ; i++) {

            if (sb.toString().equals(line.substring(i, i + sb.length()))){
                count++;
            }
        }
        System.out.println(count);
    }
}

실패 코드 2: count가 N보다 작으면 음수 계산, 그리고 IOI로 끝나는 경우 count를 통한 result 계산이 안됨
-> IOI를 다 찾고 계산하지 말고 찾을 때마다 결과 계산하자.

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String line = br.readLine();

        int count = 0;
        int result = 0;

        for (int i = 0; i < line.length(); i++) {
            // IOI 찾기
            if (i < line.length() - 2 && line.charAt(i) == 'I' && line.charAt(i + 1) == 'O' && line.charAt(i + 2) == 'I') {
                count++;
                i+=1;
                continue;
            }

            if (count > 0){
                result += (count+1) - N;
            }
            count = 0;
        }
        System.out.println(result);
    }
}
*/