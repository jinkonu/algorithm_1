package soptrithm.week_3;

import java.io.*;

public class _1987_알파벳 {

    static int m;
    static int n;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static char[][] matrix;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * dfs를 활용하자.
        * visited[]는 boolean[26]으로 관리한다.
        * */
        String[] input = reader.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        matrix = new char[m][n];

        for (int i = 0; i < m; i++) {
            String line = reader.readLine();

            for (int j = 0; j < n; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        boolean[] visited = new boolean[26];
        visited[matrix[0][0] - 'A'] = true;
        dfs(new Alphabet(0, 0, 1), visited);

        result.append(max);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dfs(Alphabet curr, boolean[] visited) {
        max = Math.max(max, curr.distance);

        for (int i = 0; i < 4; i++) {
            Alphabet next = new Alphabet(curr.y + dy[i], curr.x + dx[i], curr.distance + 1);

            if (isReachable(next, visited)) {
                visited[matrix[next.y][next.x] - 'A'] = true;
                dfs(next, visited);
                visited[matrix[next.y][next.x] - 'A'] = false;
            }
        }
    }

    private static boolean isReachable(Alphabet point, boolean[] visited) {
        return 0 <= point.y && point.y < m
                && 0 <= point.x && point.x < n
                && !visited[matrix[point.y][point.x] - 'A'];
    }
}

class Alphabet {

    int y;
    int x;
    int distance;

    public Alphabet(int y, int x, int distance) {
        this.y = y;
        this.x = x;
        this.distance = distance;
    }
}