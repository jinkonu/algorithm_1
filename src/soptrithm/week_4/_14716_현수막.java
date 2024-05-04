package soptrithm.week_4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class _14716_현수막 {

    static int M;
    static int N;
    static boolean[][] present;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
         * BFS를 활용하여 트리의 개수를 구하면 될 것 같다.
         * 대각선까지 포함이니 잘 확인하자.
         * */
        String[] input = reader.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        present = new boolean[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String[] line = reader.readLine().split(" ");

            for (int j = 0; j < N; j++)
                if (line[j].charAt(0) == '1')
                    present[i][j] = true;
        }

        int count = 0;
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (present[i][j] && !visited[i][j]) {
                    bfs(i, j);
                    ++count;
                }

        result.append(count);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void bfs(int y, int x) {
        Queue<Dot> queue = new LinkedList<>();

        visited[y][x] = true;
        queue.add(new Dot(y, x));

        while (!queue.isEmpty()) {
            Dot dot = queue.poll();

            for (int i = 0; i < 8; i++) {
                Dot near = new Dot(dot.y + dy[i], dot.x + dx[i]);

                if (isReachable(near)) {
                    queue.add(near);
                    visited[near.y][near.x] = true;
                }
            }
        }
    }

    private static boolean isReachable(Dot dot) {
        return  0 <= dot.y && dot.y < M &&
                0 <= dot.x && dot.x < N &&
                present[dot.y][dot.x] &&
                !visited[dot.y][dot.x];
    }
}

class Dot {
    int y;
    int x;

    public Dot(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
