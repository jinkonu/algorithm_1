import java.io.*;

public class _9655_돌_게임 {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // dp[k]: k개 남았을 때 이기는 사람이 나올 때까지 걸리는 최소 횟수
        // dp[1]: 1, dp[2]: 2, dp[3] : 1
        // dp[k]: n일 때, n % 2 == 1이면 SK, 0이면 CY
        n = Integer.parseInt(reader.readLine());
        dp = new int[n + 1];

        dp();
        if (dp[n] % 2 == 0) {
            result.append("CY");
        }
        else {
            result.append("SK");
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dp() {
        dp[0] = 0;
        dp[1] = 1;

        if (n > 1) {
            dp[2] = 2;

            if (n > 2) {
                for (int i = 3; i <= n; i++) {
                    dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
                }
            }
        }
     }
}
