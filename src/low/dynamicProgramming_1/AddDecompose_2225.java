package low.dynamicProgramming_1;

/*
2023년 8월 30일 수요일
(1)
    cases는 [남은 길이][빼야할 수]를 인덱스로 가지며, 그 값은 뺄 수 있는 가짓 수가 된다.
    dp를 통해 남은 길이가 2일 때부터 쌓아나갔다.
(2)
    처음에는 for loop를 3중으로 쌓았는데, 2중으로 줄여서 퍼포먼스를 대폭 향상시킬 수 있었다.
    원래는 int k = 0부터 j까지 cases[i][j] = cases[i - 1][k]를 했었지만,
    어차피 cases[i][j] = cases[i][j - 1] + cases[i - 1][j]와 동일하다는 것을 깨닫고 for loop를 하나 줄였다.
 */

import java.io.*;

public class AddDecompose_2225 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        long div = 1_000_000_000;
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        long[][] cases = new long[K + 1][N + 1];

        for (int i = 0; i <= N; i++)
            cases[1][i] = 1;

        for (int i = 2; i < K; i++)
            for (int j = 0; j <= N; j++) {
                if (j == 0) cases[i][j] = 1;
                else cases[i][j] = (cases[i][j - 1] + cases[i - 1][j]) % div;
            }

        for (int i = 0; i <= N; i++)
            cases[K][N] = (cases[K][N] + cases[K - 1][i]) % div;

        result.append(cases[K][N]);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}

//        if (K == 1)
//            for (int i = 0; i <= N; i++) {
//                cases[1][i] = 1;
//            }
//
//        else
//            for (int i = 0; i <= N; i++) {
//                cases[1][i] = 1;
//                cases[2][i] = i + 1;
//            }
//
//        for (int i = 3; i < K; i++)
//            for (int j = 0; j <= N; j++) {
//                if (j == 0) cases[i][j] = 1;
//                else cases[i][j] = (cases[i][j - 1] + cases[i - 1][j]) % div;
//            }
//
//        if (K > 2)
//            for (int i = 0; i <= N; i++)
//                cases[K][N] = (cases[K][N] + cases[K - 1][i]) % div;
