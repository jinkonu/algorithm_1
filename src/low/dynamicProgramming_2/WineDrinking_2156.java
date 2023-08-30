package low.dynamicProgramming_2;

/*
2023년 8월 30일 수요일
(1)
    간단한 dp 문제이다.
    처음에는 첫번째 포도주 잔부터 안마 or 마,
    다음에는 안마안마, 안마마, 마안마, 마마
    이런 식으로 2^n으로 끌고 가려고 했다.
(2)
    그런데 직관적으로 2차원 배열을 정의해서, maxAmount[k][0 ~ 2]를 구성할 때
    [k][0]은 [k - 1][0 ~ 2]에서 가장 큰 거
    [k][1]은 [k - 1][0] + amount[k]
    [k][2]은 [k - 1][1] + amount[k]로
    했더니 통과했다...
    아쉽게도 정확한 이유는 모르겠다 ...
 */

import java.io.*;

public class WineDrinking_2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int n = Integer.parseInt(br.readLine());
        int[] amount = new int[n];
        int[][] maxAmount = new int[n][3];

        for (int i = 0; i < n; i++)
            amount[i] = Integer.parseInt(br.readLine());

        maxAmount[0][0] = 0;
        maxAmount[0][1] = amount[0];

        for (int i = 1; i < n; i++) {
            maxAmount[i][0] = max(maxAmount[i - 1]);
            maxAmount[i][1] = maxAmount[i - 1][0] + amount[i];
            maxAmount[i][2] = maxAmount[i - 1][1] + amount[i];
        }

        result.append(max(maxAmount[n - 1]));
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int max(int[] list) {
        int max = 0;
        for (int i : list)
            if (max < i) max = i;

        return max;
    }
}
