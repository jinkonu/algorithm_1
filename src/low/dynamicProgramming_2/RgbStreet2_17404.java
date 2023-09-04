package low.dynamicProgramming_2;

/*
2023년 9월 4일 월요일
(1)
    dp 문제다. 1149번 문제의 다른 버전이다.
(2)
    dp로 어떻게 풀어나갈까 찾는 데 시간이 좀 걸렸다.
    1149번과 달리 0에서 N - 1까지 직선적으로 dp를 끌고나갈 수가 없었다.
    그래서 생각한 것이 0에서 N/2까지, N-1부터 N/2까지 양방향으로 끌고 온 다음 매칭해보는 것이었다.
    대신 [0]과 [N-1]이 서로 다르도록 설정해야 하기 때문에 기본적으로 6개 출발점을 가지게 되었다.
    그리고 그 다음인 1과 N-2에서 이 부분을 받아들이도록 하기 위해서 findDp()는 굉장히 중복도 많고 복잡한 메서드가 되었다...
 */

import java.io.*;

import static java.lang.Math.*;

public class RgbStreet2_17404 {
    static int N;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        String[] line;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < 3; j++)
                cost[i][j] = Integer.parseInt(line[j]);
        }

        min = min(min, findDp(0, 1));
        min = min(min, findDp(0, 2));
        min = min(min, findDp(1, 0));
        min = min(min, findDp(1, 2));
        min = min(min, findDp(2, 0));
        min = min(min, findDp(2, 1));

        result.append(min);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    public static int findDp(int start, int end) {
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[N][3];

        for (int i = 0; i < 3; i++) {
            if (i == start) dp[0][i] = cost[0][i];
            else dp[0][i] = 1001;
        }

        for (int i = 0; i < 3; i++) {
            if (i == end) dp[N - 1][i] = cost[N - 1][i];
            else dp[N - 1][i] = 1001;
        }

        if (N % 2 == 0) {   // 짝수
            for (int i = 1; i < N / 2; i++) {
                dp[i][0] = cost[i][0] + min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = cost[i][1] + min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = cost[i][2] + min(dp[i - 1][0], dp[i - 1][1]);
            }

            for (int i = N - 2; i >= N / 2; i--) {
                dp[i][0] = cost[i][0] + min(dp[i + 1][1], dp[i + 1][2]);
                dp[i][1] = cost[i][1] + min(dp[i + 1][0], dp[i + 1][2]);
                dp[i][2] = cost[i][2] + min(dp[i + 1][0], dp[i + 1][1]);
            }

            min = min(min, dp[N / 2 - 1][0] + dp[N / 2][1]);
            min = min(min, dp[N / 2 - 1][0] + dp[N / 2][2]);
            min = min(min, dp[N / 2 - 1][1] + dp[N / 2][0]);
            min = min(min, dp[N / 2 - 1][1] + dp[N / 2][2]);
            min = min(min, dp[N / 2 - 1][2] + dp[N / 2][0]);
            min = min(min, dp[N / 2 - 1][2] + dp[N / 2][1]);
        }

        else {              // 홀수
            for (int i = 1; i < N / 2; i++) {
                dp[i][0] = cost[i][0] + min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = cost[i][1] + min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = cost[i][2] + min(dp[i - 1][0], dp[i - 1][1]);
            }

            for (int i = N - 2; i > N / 2; i--) {
                dp[i][0] = cost[i][0] + min(dp[i + 1][1], dp[i + 1][2]);
                dp[i][1] = cost[i][1] + min(dp[i + 1][0], dp[i + 1][2]);
                dp[i][2] = cost[i][2] + min(dp[i + 1][0], dp[i + 1][1]);
            }

            min = min(min, cost[N / 2][0] + min(dp[N / 2 - 1][1], dp[N / 2 - 1][2]) + min(dp[N / 2 + 1][1], dp[N / 2 + 1][2]));
            min = min(min, cost[N / 2][1] + min(dp[N / 2 - 1][0], dp[N / 2 - 1][2]) + min(dp[N / 2 + 1][0], dp[N / 2 + 1][2]));
            min = min(min, cost[N / 2][2] + min(dp[N / 2 - 1][0], dp[N / 2 - 1][1]) + min(dp[N / 2 + 1][0], dp[N / 2 + 1][1]));
        }

        return min;
    }
}
