//  단지번호붙이기(백준 2667번)

/*
* - 첫 접근: 동서남북 BFS 문제, 다른점은 각 집단의 count를 어떻게 세냐 -> visited=true로 바뀔 때 count하자..?
* - 틀린 이유: 시작 위치 count 및 visited에 포함 꼭 할 것
* */
import java.sql.Array;
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[][] map;
    static boolean[][] visited;
    static List<Integer> sector;

    // 동서남북
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // map, visited, sector 선언
        map = new int[N][N];
        visited = new boolean[N][N];
        sector = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]){
                    findSector(j, i, N);
                }
            }
        }

        // 결과 출력
        System.out.println(sector.size()); // 총 집단 개수
        Collections.sort(sector); // 오름차순 정렬

        for (int i = 0; i < sector.size(); i++) {
            System.out.println(sector.get(i));
        }

    }

    static void findSector(int x, int y, int size){
        // sector에 속한 집 수
        int count = 0;

        // 시작 위치
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        count += 1;
        visited[y][x] = true;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= size || ny < 0 || ny >= size){
                    continue;
                }

                if (map[ny][nx] == 1 && !visited[ny][nx]){
                    queue.add(new int[]{nx, ny});
                    visited[ny][nx] = true;
                    count++; // 새로운 집 방문할 때 마다 count
                }
            }

        }
        sector.add(count);
    }

}