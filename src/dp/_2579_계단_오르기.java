package dp;

import java.io.*;

public class _2579_계단_오르기 {

    static int n;
    static int[] stairs;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * dp로 풀어야 한다.
        * dp[현재 칸][얼마나 밟고 현재 칸으로 왔는지];
        * dp[n + 1][3]
        * 결국엔 max(dp[n][1], dp[n][2])가 정답이 된다.
        * */
        n = Integer.parseInt(reader.readLine());
        stairs = new int[n + 1];
        dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(reader.readLine());
        }

        dp();
        result.append(Math.max(dp[n][1], dp[n][2]));
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dp() {
        dp[1][1] = stairs[1];
        dp[1][2] = 0;

        if (n == 1) return;

        dp[2][1] = stairs[1] + stairs[2];
        dp[2][2] = stairs[2];

        for (int i = 3; i <= n; i++) {
            dp[i][1] = dp[i - 1][2] + stairs[i];
            dp[i][2] = Math.max(dp[i - 2][1], dp[i - 2][2]) + stairs[i];
        }
    }
}
