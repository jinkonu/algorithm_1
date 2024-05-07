package soptrithm.week_5;

/*
 * dp를 활용해보겠다.
 * 1부터 n으로 올라가면서 해보면 될 것 같다.
 * 10일 때
 *   1 + 8 + 1 -> 8일 때
 *   2 + 6 + 2 -> 6일 때
 *   3 + 4 + 3 -> 4일 때
 *
 * 해법은 찾았지만,
 * 4와 6에서 2+2, 3+3이 특수한 상황이라고 한다.
 * 나는 dp[0]에 값을 넣어서 처리하려고 했지만 그 방법이 아니었다...
 * */

 import java.io.*;

public class _15991_123_더하기_6 {

    static int[] inputs;
    static int[] dp;
    static int mod = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int T = Integer.parseInt(reader.readLine());
        inputs = new int[T];

        for (int i = 0; i < T; i++) {
            inputs[i] = Integer.parseInt(reader.readLine());
        }

        dp = new int[100_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;
        dp[6] = 6;

        for (int i = 7; i <= 100_000; i++)
            dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % mod;

        for (int input : inputs) {
            result.append(dp[input]).append("\n");
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
