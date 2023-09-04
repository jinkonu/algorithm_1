package low_1.dynamicProgramming_1;

/*
2023년 8월 26일 토요일
(1)
    아주 간단한 피보나치 비슷한 문제였다.
    bottom -> up으로 쌓아가면서 N일 때의 값을 찾으면 되었다.
(2)
    문제는, 피보나치처럼 쌓다가 "오버플로우" 문제가 발생하는 것을 예기치 못했다.
    오버플로우 문제를 방지하기 위해 문제에서도 10007로 나눈 나머지를 구하라고 한 것이었다.
    그래서 계속 틀렸었고, 아예 dp[i]에 나머지 값을 넣는다.
(3)
    어차피 나머지랑 나머지랑 더해서 나머지를 만드는 건, 원래 값을 더해서 나머지를 구하는 것과 동일하다.
 */

import java.io.*;

public class Tiling2Xn_11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= N; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;

        result.append(dp[N]);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
