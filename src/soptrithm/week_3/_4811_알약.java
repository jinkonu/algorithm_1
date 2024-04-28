package soptrithm.week_3;

import java.io.*;

public class _4811_알약 {

    static long[][] dp = new long[33][33];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        *
        * W와 H의 관계를 괄호로 생각했는데 풀리지 않았다.
        * dp의 bottom-up을 활용한 아래 풀이는 다른 방식으로 접근했다.
        * 무조건 n개의 W와 n개의 H가 있는 상황을 가정하지 않았다.
        * 대신에, (w, h) = (w - 1, h) + (w, h - 1)에서 착안했다.
        * 예를 들어, (3, 1)은 WHWW, WWHW, WWWH이고 이는 (WHW, WWH) + (WWW)
        * */
        for (int h = 0; h <= 30; h++)
            for (int w = 0; w <= 30; w++) {
                if (h > w) continue;
                else if (h == 0) dp[w][h] = 1;
                else dp[w][h] = dp[w - 1][h] + dp[w][h - 1];
            }

        int n = Integer.parseInt(reader.readLine());
        while (n != 0) {
            result.append(dp[n][n]).append("\n");

            n = Integer.parseInt(reader.readLine());
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
