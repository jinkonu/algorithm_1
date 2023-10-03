package low_2.graph_1;

/*
2023년 10월 3일 화요일
(1)
    미로를 탐색하는 문제다.
    dfs로 했다가 boolean[][] visited를 메서드끼리 공유하는 문제가 생긴 건지 여러 방면으로 탐색을 못해서 bfs로 변경했다.
(2)
    X와 Y, 거리를 각각 담는 큐를 하나씩 생성해서 현재 지점에서 동서남북 4가지 방향 중 닿을 수 있는 지점을 다 큐에 담는다.
    큐에서 top 엔트리를 빼서 다시 동서남북을 찾는 방식이다.
    조금 이해가 가지 않는 건, dist의 값을 찾자마자 반환한다는 점인데, 만약 갈 수 있는 루트가 2개 이상이면 어떻게 되는거지..?
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.*;

public class MazeSearch_2178 {
    static StringBuilder result;
    static int N;
    static int M;
    static boolean[][] map;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        String[] line = br.readLine().split(" ");
        N = parseInt(line[0]);
        M = parseInt(line[1]);
        map = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < M; j++)
                if (input.charAt(j) == '1') map[i][j] = true;
        }

        result.append(bfs());
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs() {
        boolean[][] visited = new boolean[N][M];

        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        Queue<Integer> queueDist = new LinkedList<>();

        queueX.add(0);
        queueY.add(0);
        queueDist.add(1);
        visited[0][0] = true;

        while (!queueX.isEmpty()) {
            int x = queueX.poll();
            int y = queueY.poll();
            int dist = queueDist.poll();

            if (x == N - 1 && y == M - 1) return dist;

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (isValid(newX, newY) && !visited[newX][newY]) {
                    queueX.add(newX);
                    queueY.add(newY);
                    queueDist.add(dist + 1);
                    visited[newX][newY] = true;
                }
            }
        }

        return -1;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && map[x][y];
    }
}
