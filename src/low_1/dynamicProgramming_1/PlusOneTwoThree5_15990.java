package low_1.dynamicProgramming_1;

/*
2023년 8월 29일 화요일
(1)
    컨셉을 잡는 데 시간이 걸렸다.
    연속된 두 수를 더하지 않는다면, i에 대해 1로 뺀다면, i-1에서 2로 뺀 경우의 수와 3으로 뺀 경우의 수를 더해주기만 하면 된다.
(2)
    여기에 더해서, 테스트 케이스의 최댓값 100,000을 다 계산하는 것은 비효율적인 것 같아서
    입력값 중 최댓값을 max로 구해서 i = 4부터 i = max까지만 dp[][]를 채워나갔다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlusOneTwoThree5_15990 {
    static long div = 1_000_000_009;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int T = Integer.parseInt(br.readLine());
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < T; i++)
            input.add(Integer.parseInt(br.readLine()));
        int max = input.stream().max(Integer::compareTo).get();
        dp = new long[max + 1][4];

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for (int i = 4; i <= max; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % div;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % div;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % div;
        }

        for (Integer i : input)
            result.append((dp[i][1] + dp[i][2] + dp[i][3]) % div).append("\n");
        result.deleteCharAt(result.length() - 1);

//        for (int i = 1; i <= max; i++){
//            result.append(i + ", 0 : " + dp[i][0] % div).append("    ");
//            result.append(i + ", 1 : " + dp[i][1] % div).append("    ");
//            result.append(i + ", 2 : " + dp[i][2] % div).append("    ").append("\n");
//        }
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
