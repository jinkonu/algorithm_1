package low_1.dynamicProgramming_2;

/*
2023년 8월 30일 수요일
(2)
    항상 문제를 풀 때마다 코너 케이스를 생각해줘야 될 것 같다.
    이 문제에서는, dp를 수동으로 초기화할 때 max 값이 1이나 2일 경우 수동 초기화의 범위를 줄여줘야 한다.
 */

import java.io.*;

public class PlusOneTwoThree3_15998 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        long div = 1_000_000_009;
        int T = Integer.parseInt(br.readLine());
        int[] n = new int[T];
        int max = 0;

        for (int i = 0; i < T; i++) {
            n[i] = Integer.parseInt(br.readLine());
            if (n[i] > max) max = n[i];
        }

        long[] dp = new long[max + 1];

        dp[1] = 1;
        if (max >= 2) dp[2] = 2;
        if (max >= 3) dp[3] = 4;

        for (int i = 4; i <= max; i++)
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % div;

        for (int i = 0; i < T; i++)
            result.append(dp[n[i]]).append("\n");
        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
