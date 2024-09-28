package dp;

import java.io.*;

public class _1695_팰린드롬_만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
         * dp[i][j] = i부터 j까지 팰린드롬을 만들기 위해 추가해야 하는 수의 최소 개수
         * dp[i][j] = dp[i + 1][j - 1] (arr[i] == arr[j])
         * dp[i][j] = min(dp[i + 1][j], dp[i][j - 1]) + 1 (arr[i] != arr[j])
         */
        int N = Integer.parseInt(reader.readLine());
        int[] arr = new int[N];

        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int[][] dp = new int[N][N];

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                    continue;
                }

                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        result.append(dp[0][N - 1]);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
