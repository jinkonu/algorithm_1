package dp;

import java.io.*;

public class _1965_상자넣기 {

    static int n;
    static int[] boxes;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * dp를 활용해서 푼다.
        * dp[i] = i번째 상자를 넣었을 때 최대 상자의 개수
        * dp[i] = max(dp[j] + 1) (j < i, arr[j] < arr[i])
        * answer = max(dp[i])
        * */
        n = Integer.parseInt(reader.readLine());
        boxes = new int[n];
        dp = new int[n];

        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            boxes[i] = Integer.parseInt(input[i]);
        }

        result.append(dp());
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static int dp() {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (boxes[j] < boxes[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }

            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
