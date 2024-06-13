package dp;

import java.io.*;
import java.util.Arrays;

public class _2294_동전_2 {

    static int n;
    static int k;
    static int[] coins;
    static int[] dp;

    static final int MAX = 10_001;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * dp[i] = i원을 만들 수 있는 최소 동전 개수
        * init(dp) -> dp[i] = 10001로 초기화
        * dp[최소 동전 값]부터 dp[k]까지,
        *   dp[i] = min(dp[i], dp[i - coins[j]] + 1)
        * */
        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        coins = new int[n];
        dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(coins);
        Arrays.fill(dp, MAX);

        result.append(dp());
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static int dp() {
        for (int coin : coins) {
            if (coin <= k) {
                dp[coin] = 1;
            }
        }

        for (int i = coins[0]; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[k] == MAX ? -1 : dp[k];
    }
}
