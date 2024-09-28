package dp;

import java.io.*;

public class _1003_피보나치_함수 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // int[41][2] dp: i일 때 출력되는 0의 개수와 1의 개수를 각각 담음
        // dp[i][0] = dp[i - 1][0] + dp[i - 2][0]
        int[][] dp = new int[41][2];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int t = Integer.parseInt(reader.readLine());
        int[] inputs = new int[t];
        int max = 0;

        for (int i = 0; i < t; i++) {
            int input = Integer.parseInt(reader.readLine());
            inputs[i] = input;

            max = Math.max(max, input);
        }

        for (int i = 2; i <= max; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        for (int input : inputs) {
            result.append(dp[input][0]).append(" ").append(dp[input][1]).append("\n");
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
