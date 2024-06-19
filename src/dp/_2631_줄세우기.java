package dp;

import java.io.*;

public class _2631_줄세우기 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        *
        * 1. dp[i] = i번째까지의 최장 증가 부분 수열의 길이
        * 2. dp[i] = max(dp[i], dp[j] + 1) (j < i, arr[j] < arr[i])
        * 3. (N - dp[i]의 최대값)이 정답
        *
        * 즉, 증가하는 수열 가장 긴 구간을 찾는다.
        * 그리고 나머지는 다 옮긴다고 생각하면, {옮기는 횟수 = N - 최장 구간}이 된다.
        * */

        int N = Integer.parseInt(reader.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++)
                if (arr[j] < arr[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
        }

        int max = 0;
        for (int i = 0; i < N; i++)
            max = Math.max(max, dp[i]);

        result.append(N - max);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
