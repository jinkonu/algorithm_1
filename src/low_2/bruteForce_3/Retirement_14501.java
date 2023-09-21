package low_2.bruteForce_3;

/*
2023년 9월 21일 목요일
(1)
    dp 문제다.
(2)
    어차피 상담을 받을 수 없는 인덱스는 제하고, 그 앞에서부터 시작했다.
    for 문을 보면 if 케이스를 매우 더럽게 나누고 있는데, 이 부분이 아직도 애매하다...
    그치만 성능은 나쁘지 않게 나왔다.
 */

import java.io.*;

import static java.lang.Math.*;

public class Retirement_14501 {
    static int N;
    static int[] T;
    static int[] P;
    static int[] dp;
    static int startIndex = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            T[i] = Integer.parseInt(line[0]);
            P[i] = Integer.parseInt(line[1]);
            if (i + T[i] <= N) startIndex = i;
        }

        for (int i = startIndex; i >= 0; i--) {
            if (i + T[i] < N)
                dp[i] = max(dp[i + T[i]] + P[i], dp[i + 1]);

            else if (i == N - 1)
                dp[i] = P[i];

            else if (i + T[i] == N)
                dp[i] = max(P[i], dp[i + 1]);

            else
                dp[i] = dp[i + 1];
        }

        result.append(dp[0]);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
