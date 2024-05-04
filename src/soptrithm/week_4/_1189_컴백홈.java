package soptrithm.week_4;

import java.io.*;

public class _1189_컴백홈 {

    static int M;
    static int N;
    static int K;
    static int count = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * dfs를 활용해서 거리가 K인 경로를 찾아야 할 것 같다.
        * bfs는 visisted를 관리하기가 좀 더 까다로운 느낌이다.
        * */
        String[] input = reader.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        boolean[][] visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            char[] line = reader.readLine().toCharArray();

            for (int j = 0; j < N; j++)
                if (line[j] == 'T')
                    visited[M - 1 - i][j] = true;
        }

        visited[0][0] = true;
        dfs(visited, new Point(0, 0, 1));

        result.append(count);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dfs(boolean[][] visited, Point prev) {
        if (isReached(prev)) {
            ++count;
            return;
        }

        for (int i = 0; i < 4; i++) {
            Point point = new Point(prev.y + dy[i], prev.x + dx[i], prev.distance + 1);

            if (isReachable(point, visited)) {
                visited[point.y][point.x] = true;
                dfs(visited, point);
                visited[point.y][point.x] = false;
            }
        }
    }

    private static boolean isReachable(Point point, boolean[][] visited) {
        return 0 <= point.y && point.y < M
                && 0 <= point.x && point.x < N
                && !visited[point.y][point.x];
    }

    private static boolean isReached(Point point) {
        return point.y == (M - 1)
                && point.x == (N - 1)
                && point.distance == K;
    }
}

class Point {
    int y;
    int x;
    int distance;

    public Point(int y, int x, int distance) {
        this.y = y;
        this.x = x;
        this.distance = distance;
    }
}