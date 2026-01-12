//  색종이 만들기(백준 2630번)

/*
분할정복 문제

재귀 호출로 풀 수도 있음 -> 1,2,3,4분면의 개념으로 분할해서 재귀 호출(이러면 visited 배열 만들 필요 없음)
내 코드의 문제점은 같은 구역을 여러번 탐색. visited 배열 비용 추가.

*/
import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int[][] map;
    static int blueBlock = 0;
    static int whiteBlock = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int range = N;

        partition(0, 0, range);
        System.out.println(whiteBlock);
        System.out.println(blueBlock);
    }

    static void partition(int y, int x, int n){
        if (n == 0){
            return;
        }
        if (findBlock(y, x, n, 1)){
            blueBlock += 1;
            return;
        }
        else if (findBlock(y, x, n, 0)){
            whiteBlock += 1;
            return;
        }

        int size = n / 2;
        partition(y, x, size);
        partition(y, x + size, size);
        partition(y + size, x, size);
        partition(y + size, x + size, size);
    }

    static boolean findBlock(int y, int x, int n, int findNum){
        for (int i = y; i < n + y; i++) {
            for (int j = x; j < n + x; j++) {
                if(map[i][j] != findNum){
                    return false;
                }
            }
        }
        return true;
    }
}

/*
- 내가 작성했던 코드

class Main {
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int range = N;
        int blueBlock = 0;
        int whilteBlock = 0;

        while(range >= 1){
            for (int i = 0; i < N; i+=range) {
                for (int j = 0; j < N; j+=range) {
                    if (findBlock(i, j, range, 1)){
                        blueBlock += 1;
                    }
                    if(findBlock(i, j, range, 0)){
                        whilteBlock += 1;
                    }
                }
            }
            range = range / 2;
        }
        System.out.println(whilteBlock);
        System.out.println(blueBlock);
    }

    static boolean findBlock(int y, int x, int n, int findNum){
        for (int i = y; i < n + y; i++) {
            for (int j = x; j < n + x; j++) {
                if(map[i][j] != findNum || visited[i][j]){
                    return false;
                }
            }
        }

        for (int i = y; i < n + y; i++) {
            for (int j = x; j < n + x; j++) {
                visited[i][j] = true;
            }
        }

        return true;
    }
}
*/