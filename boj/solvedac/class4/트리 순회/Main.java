//  트리 순회 (백준 1991번)

/*
* - 첫 접근: dfs처럼 ArrayList로 설정하고 양방향 매핑 후에 출력하려고 함
* - 문제: 도저히 안됨.. left, right 구분이 명확하지 않음. 그렇다고 Tree Class를 만들기엔 너무 부담
* - 해결: 코드 참고, left-right 배열을 생성 후 재귀
* */
import java.sql.SQLOutput;
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] left;
    static int[] right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        left = new int[N];
        right = new int[N];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 'A';
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            if (l != '.') left[parent] = l - 'A';
            if (r != '.') right[parent] = r - 'A';
        }
        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }
    static void preorder(int node){
        if (node == -1){
            return;
        }
        else {
            System.out.print((char) (node + 'A'));
            preorder(left[node]);
            preorder(right[node]);
        }
    }

    static void inorder(int node){
        if (node == -1){
            return;
        }
        else {
            inorder(left[node]);
            System.out.print((char) (node + 'A'));
            inorder(right[node]);
        }
    }

    static void postorder(int node){
        if (node == -1){
            return;
        }
        else {
            postorder(left[node]);
            postorder(right[node]);
            System.out.print((char) (node + 'A'));
        }
    }


}

/*
- 실패 코드: ArrayList로 접근해서 dfs로 풀려했던거.

class Main {
    static List<List<Integer>> tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        tree = new ArrayList<>();
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';

            tree.get(parent).add(left);
            tree.get(parent).add(right);
            if (left != '.' - 'A'){
                tree.get(left).add(parent);
            }
            if (right != '.' - 'A'){
                tree.get(right).add(parent);
            }
        }
        dfs2(0);
    }

    static void dfs(int parent){
        System.out.print(Character.toString(parent + 'A'));
        visited[parent] = true;
        for (int i = 0; i < tree.get(parent).size(); i++){
            int child = tree.get(parent).get(i);
            if (child != '.' - 'A' && visited[child] == false){
                dfs(child);
            }
            else continue;
        }
    }

    static void dfs2(int parent){
        visited[parent] = true;
        for (int i = 0; i < tree.get(parent).size(); i++){
            int child = tree.get(parent).get(i);
            if (child != '.' - 'A' && visited[child] == false){
                dfs(child);
            }
            else continue;
        }

    }
}
*/