package low.dynamicProgramming_2;

/*
2023년 8월 30일 수요일
(1)
    dp 문제고, 여러모로 2225번 문제와 유사하다.
(2)
    asc[1][k]는 전부 1로 채워둔다.
    asc[2]부터는 asc[k][0]만 1로 초기화하고, asc[k][l] = asc[k][l - 1] + asc[k - 1][l]처럼 일종의 삼각형?으로 쌓아가면 된다.
 */

import java.io.*;

public class AscendingNumber_11057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        final int MOD = 10_007;
        int N = Integer.parseInt(br.readLine());
        int[][] asc = new int[N + 1][10];
        long answer = 0;

        for (int i = 0; i < 10; i++)
            asc[1][i] = 1;

        for (int i = 2; i <= N; i++) {
            asc[i][0] = 1;
            for (int j = 1; j < 10; j++)
                asc[i][j] = (asc[i][j - 1] + asc[i - 1][j]) % MOD;
        }

        for (int i : asc[N])
            answer += i % MOD;

        result.append(answer % MOD);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
