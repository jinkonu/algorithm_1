package low.dynamicProgramming_2;

/*
2023년 9월 2일 토요일
(1)
    이 문제가 dp를 어떻게 사용하는지만 알면 성공할 수 있는 문제다.
    다른 무엇보다도 질문 게시판에 올라와 있는 사례가 도움이 많이 되었다.
(2)
    dp[N] = (3 * dp[N - 2] + 2 * dp[N - 4] + ... + 2 * dp[2]) + 2
    라고 식을 세우면 쉽게 풀 수 있다.
 */

import java.io.*;

public class TileInserting_2133 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        if (N % 2 == 0) {   // N이 홀수면 dp[N] = 0
            dp[2] = 3;      // dp[2] = 3으로 초기화

            for (int i = 4; i <= N; i += 2) {
                for (int j = 2; j < i; j += 2) {
                    if (j == 2) dp[i] += 3 * dp[i - j];
                    else dp[i] += 2 * dp[i - j];
                }
                dp[i] += 2;
            }
        }

        result.append(dp[N]);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
