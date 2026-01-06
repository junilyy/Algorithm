//  스택 수열 (백준 1874번)

/*
BufferedWriter에 바로 write하지 말기 -> 이미 write 된 거 되돌리기 힘드니 StringBuilder 이용

헷갈렸던 부분: 현재 숫자가 stack에 있어 pop을 해야하는 경우를 어떻게 고려하나?
-> peek만 고려하면 됨. pop을 여러번 해서 찾아냈다는 것은 그 수열을 애초에 만들지 못한다는 것.
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int nextPush = 1;

        for (int i = 0; i < N; i++) {
            if (arr[i] >= nextPush){
                while(arr[i] >= nextPush){
                    stack.push(nextPush);
                    nextPush++;
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else if (arr[i] < nextPush){
                if (arr[i]==stack.peek()){
                    stack.pop();
                    sb.append("-\n");
                }
                else{
                    sb.setLength(0);
                    sb.append("NO");
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}