//  헌내기는 친구가 필요해 (백준 21736번)

/*
첫 접근: bfs 문제다 -> 맞음
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        int sy = -1, sx = -1; // 시작 지점

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'I') {
                    sy = i;
                    sx = j;
                }
            }
        }

        int result = bfs(sy, sx);
        if (result == 0) {
            System.out.println("TT");
        }
        else{
            System.out.println(result);
        }
    }

    static int bfs(int sy, int sx){
        int count = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy});
        visited[sy][sx] = true;

        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];

            if (map[y][x] == 'P'){
                count+=1;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[ny][nx] ) {
                    continue;
                }

                if (map[ny][nx] == 'X') {
                    continue;
                }

                queue.add(new int[] {nx, ny});
                visited[ny][nx] = true;

            }
        }

        return count;
    }
}


package modelly.modelly_be.global.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    // SPRING_CONFIG_ADDITIONAL_LOCATION=file:/app/config/application.yaml(서버 file path)
    @Value("${spring.config.additional-location:}")
    private String additionalLocation;

    // json 파일명
    private static final String FIREBASE_KEY_FILENAME = "moandi_serviceAccountKey.json";

    @PostConstruct
    public void init() {
        try (InputStream serviceAccount = resolveServiceAccountStream()) {

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }

        } catch (Exception e) {
            throw new IllegalStateException(
                    "Failed to initialize Firebase. " +
                            "For server: place " + FIREBASE_KEY_FILENAME + " next to application.yaml in the mounted config dir. " +
                            "For local dev: put it under src/main/resources.",
                    e
            );
        }
    }

    // 파일 path 확인
    private InputStream resolveServiceAccountStream() throws Exception {
        // 운영: additional-location(file:) 기준으로 application.yaml과 같은 디렉토리에서 찾기
        if (additionalLocation != null && !additionalLocation.isBlank()) {
            String first = additionalLocation.trim().split(",")[0].trim();

            if (first.startsWith("file:")) {
                String yamlPath = first.substring("file:".length()); // e.g. "/app/config/application.yaml"
                File yaml = new File(yamlPath);
                File dir = yaml.getParentFile();

                if (dir != null) {
                    File json = new File(dir, FIREBASE_KEY_FILENAME);
                    if (json.exists() && json.isFile()) {
                        return new FileInputStream(json);
                    }
                }
            }
        }

        // 로컬 개발 fallback: classpath(src/main/resources)에서 찾기
        InputStream cp = getClass().getResourceAsStream("/" + FIREBASE_KEY_FILENAME);
        if (cp == null) {
            throw new IllegalStateException(
                    "Firebase service account key not found. " +
                            "Server: mount it next to application.yaml. " +
                            "Local: place it at src/main/resources/" + FIREBASE_KEY_FILENAME
            );
        }
        return cp;
    }
}
