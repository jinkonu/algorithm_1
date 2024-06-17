package dp;

import java.io.*;

public class _2011_암호코드 {

    static String input;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * dp를 활용해서 푼다.
        * dp[i] = i번째 문자까지의 암호 해석 방법의 수
        * dp[i] = dp[i - 1](i번째 글자 따로 해석) + dp[i - 2](i - 1번째 문자까지 함께 해석) (i번째 문자가 0이 아닐 때)
        * */
        input = reader.readLine();
        dp = new int[input.length() + 1];

        if (input.charAt(0) == '0') {
            result.append(0);
        } else {
            dp();
            result.append(dp[input.length()]);
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dp() {
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= input.length(); i++) {
            int num = Integer.parseInt(input.substring(i - 2, i));

            // dp[i - 1] -> (i번째 글자 따로 해석)
            if (input.charAt(i - 1) != '0')
                dp[i] += (dp[i - 1] % 1_000_000);

            // dp[i - 2] -> (i - 1번째 글자까지 함께 해석)
            if (num >= 10 && num <= 26)
                dp[i] += (dp[i - 2] % 1_000_000);

            dp[i] %= 1_000_000;
        }
    }
}
