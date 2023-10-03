package low_2.graph_1;

import java.io.*;

import static java.lang.Integer.*;

public class NumberOfIslands_4963 {
    static int w;
    static int h;
    static boolean[][] map;
    static boolean[][] visited;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] wANDh = br.readLine().split(" ");
        w = parseInt(wANDh[0]);
        h = parseInt(wANDh[1]);

        while (w > 0 && h > 0) {
            map = new boolean[h][w];
            visited = new boolean[h][w];
            num = 0;

            for (int i = 0; i < h; i++) {
                String[] input = br.readLine().split(" ");

                for (int j = 0; j < w; j++)
                    if (input[j].charAt(0) == '1') map[i][j] = true;
            }

            for (int i = 0; i < h; i++)
                for (int j = 0; j < w; j++)
                    if (map[i][j] && !visited[i][j]) {
                        ++num;
                        dfs(i, j);
                    }

            result.append(num).append("\n");

            wANDh = br.readLine().split(" ");
            w = parseInt(wANDh[0]);
            h = parseInt(wANDh[1]);
        }

        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;

        // 위아래
        if (i < h - 1 && map[i + 1][j] && !visited[i + 1][j]) dfs(i + 1, j);
        if (i > 0     && map[i - 1][j] && !visited[i - 1][j]) dfs(i - 1, j);

        // 양옆
        if (j < w - 1 && map[i][j + 1] && !visited[i][j + 1]) dfs(i, j + 1);
        if (j > 0     && map[i][j - 1] && !visited[i][j - 1]) dfs(i, j - 1);

        // 대각선 1
        if (i < h - 1 && j > 0     && map[i + 1][j - 1] && !visited[i + 1][j - 1]) dfs(i + 1, j - 1);
        if (i < h - 1 && j < w - 1 && map[i + 1][j + 1] && !visited[i + 1][j + 1]) dfs(i + 1, j + 1);

        // 대각선 2
        if (i > 0     && j > 0     && map[i - 1][j - 1] && !visited[i - 1][j - 1]) dfs(i - 1, j - 1);
        if (i > 0     && j < w - 1 && map[i - 1][j + 1] && !visited[i - 1][j + 1]) dfs(i - 1, j + 1);
    }
}
