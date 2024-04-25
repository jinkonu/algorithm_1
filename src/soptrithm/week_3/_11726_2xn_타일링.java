package soptrithm.week_3;

import java.io.*;

public class _11726_2xn_타일링 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * dp 문제다.
        * k > 1일 경우, dp[k] = (dp[k-1] + dp[k-2]) % 10_007
        * k == 1일 경우, -1만 가능하다.
        * 1, 2는 직접 작성하고, 3부터 n까지 쌓아간다.
        *
        * */
        int n = Integer.parseInt(reader.readLine());
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10_007;
        }

        result.append(dp[n]);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
