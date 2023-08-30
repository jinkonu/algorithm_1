package low.dynamicProgramming_1;

/*
2023년 8월 29일 화요일
(1)
    10844번 문제와 알고리즘이 거의 동일하다.
    예를 들어 k개의 이친수가 있을 때, k-1개 이친수의 0과 1의 개수만으로 유추가 가능하다.
    (이 부분은 for문을 보면 알 수 있다.)
 */

import java.io.*;

public class PinaryNumber_2193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][2];

        dp[1][1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][1] = dp[i - 1][0];
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
        }

        result.append(dp[N][0] + dp[N][1]);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
