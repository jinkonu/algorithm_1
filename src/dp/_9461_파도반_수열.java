package dp;

import java.io.*;

public class _9461_파도반_수열 {

    static int t;
    static int max = 0;
    static int[] input;
    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * P(5)까지는 규칙이 통하지 않는다.
        * 그 이후에는 P(n) = P(n - 1) + P(n - 5)가 성립한다.
        * */
        t = Integer.parseInt(reader.readLine());
        input = new int[t];

        for (int i = 0; i < t; i++) {
            input[i] = Integer.parseInt(reader.readLine());
            max = Math.max(max, input[i]);
        }

        init();
        print(result);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void print(StringBuilder result) {
        for (int x : input) {
            result.append(dp[x]).append("\n");
        }
    }

    private static void init() {
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 6; i <= max; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }
    }
}
