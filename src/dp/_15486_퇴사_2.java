package dp;

import java.io.*;

public class _15486_퇴사_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(reader.readLine());
        int[] T = new int[1_500_002];
        int[] P = new int[1_500_002];

        for (int i = 1; i <= N; i++) {
            String[] inputs = reader.readLine().split(" ");

            T[i] = Integer.parseInt(inputs[0]);
            P[i] = Integer.parseInt(inputs[1]);
        }

        int[] dp = new int[1_500_002];

        for (int i = N; i >= 1; i--) {
            if (i + T[i] > N + 1)
                dp[i] = dp[i + 1];
            else
                dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
        }

        result.append(dp[1]);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
