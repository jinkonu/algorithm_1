package dp;

import java.io.*;

public class _1로_만들기_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // dp[n] : min(dp[n / 3], dp[n / 2], dp[n - 1]) + 1
        // trace[n] : 연산을 당하는 이전 수를 저장하기 위한 배열
        int n = Integer.parseInt(reader.readLine());

        int[] dp = new int[n + 1];
        int[] trace = new int[n + 1];

        dp[0] = dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            trace[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                trace[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                trace[i] = i / 3;
            }
        }

        result.append(dp[n]).append("\n");

        while (n > 0) {
            result.append(n).append(" ");
            n = trace[n];
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
