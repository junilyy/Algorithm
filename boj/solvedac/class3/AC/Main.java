//  AC (백준 5430번)

/*
* - 첫 접근: java의 List, reverse 등을 이용하여 쉽게 구현
* (StringBuilder 쓴 이유는 BW는 int가 바로 append가 안돼서 valueOf를 사용해야했기때문)
* - 문제: 시간초과 발생 -> ArrayList의 reverse는 O(N), 또한 앞에서 pop 하는 것도 O(N)
* - 해결 방법: 실제로 reverse를 실행하지 말고 상태로 관리하자 -> 그러면 앞에서 pop 하는건 어떻게? -> Deque 이용해서 앞, 뒤 pop 가능하게
* - 주의사항: queue의 크기가 줄어들기 때문에 결과 출력 시 for문에서 array.size()를 바로 이용하지 말 것
* */
import java.sql.SQLOutput;
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int i = 0 ; i < T; i++) {
            // input
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> array = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), ",[]");

            for (int j = 0 ; j < n ; j++) {
                array.add(Integer.parseInt(st.nextToken()));
            }

            // reverse용 flag
            boolean reverseFlag = false;

            // 에러 확인용
            boolean errorFlag = false;

            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'R'){
                    if (reverseFlag){
                        reverseFlag = false;
                    }
                    else {
                        reverseFlag = true;
                    }
                }
                else if (p.charAt(j) == 'D'){
                    if (array.size() > 0){
                        if (reverseFlag){
                            array.pollLast();
                        }
                        else {
                            array.pollFirst();
                        }
                    }
                    else {
                        errorFlag = true;
                    }
                }
            }
            if (errorFlag){
                result.append("error\n");
            }
            else {
                int size = array.size();
                result.append("[");
                for (int j = 0; j < size; j++) {
                    if (reverseFlag){
                        result.append(array.pollLast());
                    }
                    else {
                        result.append(array.pollFirst());
                    }
                    if (j < size - 1){
                        result.append(",");
                    }
                }
                result.append("]\n");
            }
        }

        System.out.println(result.toString());

    }
}

/*
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int i = 0 ; i < T; i++) {
            // input
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            List<Integer> array = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), ",[]");

            for (int j = 0 ; j < n ; j++) {
                array.add(Integer.parseInt(st.nextToken()));
            }

            // 에러 확인용
            boolean error = false;

            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'R'){
                    Collections.reverse(array); // reverse 함수가 있는거 기억(List 타입은 Arrays.sort가 아님)
                }
                else if (p.charAt(j) == 'D'){
                    if (array.size() > 0){
                        array.remove(0);
                    }
                    else {
                        error = true;
                    }
                }
            }
            if (error){
                result.append("error\n");
            }
            else {
                result.append("[");
                for (int j = 0; j < array.size(); j++) {
                    result.append(array.get(j));
                    if (j < array.size()-1){
                        result.append(",");
                    }
                }
                result.append("]\n");
            }
        }

        System.out.println(result.toString());
        
    }
}
 */