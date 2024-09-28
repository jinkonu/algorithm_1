package dp;

import java.io.*;

public class _11722_가장_긴_감소하는_부분_수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * dp[i] = i번째까지의 최장 감소 부분 수열의 길이
        * dp[i] = max(dp[i], dp[j] + 1) (j < i, arr[j] > arr[i])
        * 즉, i보다 왼쪽에 있고 arr[i]보다 큰 수들 중에서 가장 긴 감소 부분 수열을 찾아서 +1해서 dp[i]에 저장한다.
        * 없을 경우, arr[i]가 현재까지 가장 큰 수가 되기 때문에 dp[i] = 1이다.
        */
        int N = Integer.parseInt(reader.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++)
                if (arr[j] > arr[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
        }

        int max = 0;
        for (int i = 0; i < N; i++)
            max = Math.max(max, dp[i]);

        result.append(max);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
