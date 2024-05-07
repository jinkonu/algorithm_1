package soptrithm.week_5;

/*
* /*
 * dp를 활용해야 한다고 한다.
 * 해당 위치에 임의의 방향 k로 왔다고 했을 때의 합을 구하면 될 것 같다.
 * 예를 들어, [1][0]의 cost가 10이고, [0][0]의 cost가 5, [0][1]이 3이면 [1][0][1]은 15, [1][0][2]는 8로
 *
* 아래 그대로 제출하면 틀렸다고 하는데, 왜 틀렸는지는 모르겠다...
* */

import java.io.*;
import java.util.Arrays;

public class _17484_진우의_달_여행 {

    static int n;
    static int m;

    static int[][] cost;
    static int[][][] dp;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};

    static int MAX = 101;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START

        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        cost = new int[n][m];
        dp = new int[n][m][3];

        for (int i = 0; i < n; i++) {
            input = reader.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                cost[i][j] = Integer.parseInt(input[j]);
                Arrays.fill(dp[i][j], MAX);
            }
        }

        result.append(dp());
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static int dp() {
        for (int i = 0; i < m; i++) {
            dp[0][i][0] = cost[0][i];
            dp[0][i][1] = cost[0][i];
            dp[0][i][2] = cost[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp[i][j][1] = cost[i][j] + dp[i - 1][j][2];
                    dp[i][j][2] = cost[i][0] + Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]);
                }

                else if (j == m - 1) {
                    dp[i][j][1] = cost[i][j] + dp[i - 1][j][0];
                    dp[i][j][0] = cost[i][j] + Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]);
                }

                else {
                    dp[i][j][0] = cost[i][j] + Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]);
                    dp[i][j][1] = cost[i][j] + Math.min(dp[i - 1][j][2], dp[i - 1][j][0]);
                    dp[i][j][2] = cost[i][j] + Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]);
                }
            }


        }

        int min = MAX;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < 3; j++)
                min = Math.min(min, dp[n - 1][i][j]);

        return min;
    }
}
