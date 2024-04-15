package low_1_again;

// N에 대해 N보다 같거나 작은 최대의 제곱수 k를 찾는다.
// int[] dp = new int[N]
// dp[1, 4, ..., k] = 1;
// dp[N] = dp[N - k] + dp[k]; -> 재귀적으로 풀어 나간다.

// 위의 방식대로 하니까 시간 초과가 발생한다.
// 반대로 1부터 N까지 올라가는 게 더 빠른 것 같다.

import java.io.*;

import static java.lang.Math.sqrt;

public class _1699_제곱수의_합 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(reader.readLine());
        int[] min = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            min[i] = i;

            for (int j = 1; j <= sqrt(i); j++)
                min[i] = Math.min(min[i], 1 + min[i - j * j]);
        }

        result.append(min[N]);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
