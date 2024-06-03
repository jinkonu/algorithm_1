package soptrithm.week_7;

import java.io.*;

public class _1189_컴백홈 {

    static int r;
    static int c;
    static int k;
    static boolean[][] visited;
    static int total;

    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * 최단 거리가 아닌, 정해진 거리에 대한 가짓수에 대해서는 dfs가 확실히 편할 것 같다.
        * */
        String[] input = reader.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String line = reader.readLine();

            for (int j = 0; j < c; j++) {
                if (line.charAt(j) == 'T') {
                    visited[i][j] = true;
                }
            }
        }

        visited[r - 1][0] = true;
        dfs(new Hansoo(r - 1, 0, 1));

        result.append(total);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dfs(Hansoo last) {
        if (isEndPoint(last)) {
            ++total;
            return;
        }

        for (int i = 0; i < 4; i++) {
            Hansoo next = new Hansoo(last.y + dy[i], last.x + dx[i], last.distance + 1);

            if (!isNotReachable(next.y, next.x)) {
                visited[next.y][next.x] = true;
                dfs(next);
                visited[next.y][next.x] = false;
            }
        }
    }

    private static boolean isNotReachable(int ny, int nx) {
        return ny < 0 || nx < 0 ||
                ny >= r || nx >= c ||
                visited[ny][nx];
    }

    private static boolean isEndPoint(Hansoo hansoo) {
        return hansoo.y == 0 &&
                hansoo.x == c - 1 &&
                hansoo.distance == k;
    }
}

class Hansoo {
    int y;
    int x;
    int distance;

    public Hansoo(int y, int x, int distance) {
        this.y = y;
        this.x = x;
        this.distance = distance;
    }
}