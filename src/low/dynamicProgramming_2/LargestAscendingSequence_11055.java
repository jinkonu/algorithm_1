package low.dynamicProgramming_2;

/*
2023년 8월 31일 목요일
(1)
    dp 문제다.
    합이 가장 큰 증가하는 부분 수열을 골라야 한다.
(2)
    여러 시도 끝에 각주에 있는 것처럼 작성했다.
    인덱스를 0에서 N으로 끌고 가면서 매 인덱스마다 최적의 결과를 얻는 dp가 아니다.
    list[k]를 유지하면서 최적의 수열을 찾는 문제다.
    그러한 본질은 파악했지만 쓸데없는 부분이 조금 있는 것 같아서 다른 사람의 것을 참고해서 아래와 같이 작성했다.
(3)
    dp를 2차원 배열로 할 필요가 없었다.
    어차피 dp[k][k]는 List[k]와 동일해서 list[k]를 쓰면 되었고, 총합이 가장 큰 것이 중요했으므로.
    그래서 dp[][]는 수열과 수열의 합을 동시에 보존했다면, dp[]는 수열의 합만 보존한다.
    dp[k]를 작성하는 데 있어서, list[j] < list[k]이고, dp[j] + list[k]가 최대가 되도록 하는 dp[j]를 끌어다 dp[k]에 더해주면 된다.
 */

import java.io.*;

public class LargestAscendingSequence_11055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] list = new int[N];
        int[] dp = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++)
            list[i] = Integer.parseInt(line[i]);

        dp[0] = list[0];
        max = dp[0];

        for (int i = 1; i < N; i++) {
            dp[i] = list[i];
            for (int j = 0; j < i; j++) {
                if (list[j] < list[i] && dp[i] < dp[j] + list[i])
                    dp[i] = dp[j] + list[i];
            }

            if (max < dp[i]) max = dp[i];
        }

        result.append(max);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}

//        int[][] dp = new int[N][];
//        int max = 0;
//
//        for (int i = 0; i < N; i++) {
//            list[i] = Integer.parseInt(line[i]);
//            dp[i] = new int[i + 2];
//        }
//
//        dp[0][0] = dp[0][1] = list[0];
//        max = list[0];
//
//        for (int i = 1; i < N; i++) {
//            dp[i][i] = list[i];
//            int tmpMax = 0;
//            int[] tmpArr = dp[i];
//
//            for (int j = 0; j < i; j++)
//                if (dp[j][j] < dp[i][i] && tmpMax < dp[j][j + 1]) {
//                    tmpMax = dp[j][j + 1];
//                    tmpArr = dp[j];
//                }
//
//            System.arraycopy(tmpArr, 0, dp[i], 0, tmpArr.length - 1);
//
//            for (int j = 0; j < i + 1; j++)
//                dp[i][i + 1] += dp[i][j];
//
//            if (max < dp[i][i + 1])
//                max = dp[i][i + 1];
//        }
