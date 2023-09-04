package low.dynamicProgramming_2;

/*
2023년 9월 1일 금요일
(1)
    dp 문제는 dp의 본질에 입각해야 한다.
    이 문제는 dp를 이중으로 나눠서 생각해야 한다.
    지금 내가 붙잡고 있는 인덱스를 기준으로 왼쪽과 오른쪽을 각각 생각해야 한다.
    그래서 int[][] dp를 정의해서 인덱스 왼쪽은 [0]에, 오른쪽은 [1]에 담았다.
    엔트리의 값은 자기보다 작은 값으로 끝나는 수열 중에서 가장 긴 수열의 크기이다.
 */

import java.io.*;

public class LargestBitonicSequence_11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] list = new int[N];
        int[][] dp = new int[N][2];     // [0]은 자기보다 작은 왼쪽 개수, [1]은 자기보다 큰 오른쪽 개수
        int max = 0;

        for (int i = 0; i < N; i++)
            list[i] = Integer.parseInt(line[i]);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++)         // i 기준 왼쪽 dp
                if (list[j] < list[i] && dp[i][0] < dp[j][0])
                    dp[i][0] = dp[j][0];        // +1은 j에 있는 수도 포함해야 하기 때문에 필요
            dp[i][0] += 1;
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 1; j < N; j++)     // i 기준 오른쪽 dp
                if (list[j] < list[i] && dp[i][1] < dp[j][1])
                    dp[i][1] = dp[j][1];        // +1은 j에 있는 수도 포함해야 하기 때문에 필요
            dp[i][1] += 1;

            if (max < (dp[i][0] + dp[i][1] - 1))
                max = dp[i][0] + dp[i][1] - 1;
        }

        result.append(max);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
