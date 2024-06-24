package dp;

import java.io.*;

public class _1890_점프 {

    static int n;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * dp[i][j] = (0, 0)부터 (i, j)까지의 최대 경로
        * */
        n = Integer.parseInt(reader.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp();
        result.append(dp[n - 1][n - 1]);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dp() {
        dp = new long[n][n];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int size = map[i][j];

                if (size == 0)
                    continue;

                if (i + size < n)
                    dp[i + size][j] += dp[i][j];

                if (j + size < n)
                    dp[i][j + size] += dp[i][j];
            }
        }
    }
}