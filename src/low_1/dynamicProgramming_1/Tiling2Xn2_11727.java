package low_1.dynamicProgramming_1;

/*
2023년 8월 27일 일요일
(1)
    11726번 문제와 아주 살짝만 다르다.
    "i - 2"로 두 칸 건너뛸 때에는 케이스 가짓수가 두 배로 늘어난다는 점을 캐치해야 한다.
    그거랑 나머지를 저장해서 오버플로우 방지하기만 하면 할만하다.
 */

import java.io.*;

public class Tiling2Xn2_11727 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 1];

        dp[0] = dp[1] = 1;
        for (int i = 2; i <= N; i++)
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;

        result.append(dp[N]);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
