package low.dynamicProgramming_1;

/*
2023년 8월 29일 화요일
(1)
    15990번 문제처럼 연속하는 수가 없도록 수를 배열하는 문제다.
    stairs[1]은 초기값으로 직접 각 엔트리를 1로 설정해줬다.
(2)
    stairs[2]부터는 dp를 이용했는데,
    i는 계단 수 k를 뜻하고, j는 k를 시작하는 수를 뜻한다.
(3)
    stairs[i][j] = stairs[i - 1][j - 1] + stairs[i - 1][j + 1]이다.
    즉, 3개짜리 계단의 3으로 시작하는 경우에는, 2개짜리 계단의 2와 4로 시작하는 경우의 수를 합한 것이다.
 */

import java.io.*;

public class EasyStairNum_10844 {
    static long[][] stairs;
    static long div = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(br.readLine());
        stairs = new long[N + 1][10];

        for (int i = 1; i <= 9; i++)
            stairs[1][i] = 1;

        for (int i = 2; i <= N; i++)
            for (int j = 0; j <= 9; j++)
                stairs[i][j] = stairs(i, j);

        long num = 0;
        for (int i = 0; i <= 9; i++)
            num += (stairs[N][i] % div);

        result.append(num % div);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static long stairs(int i, int j) {
        if (j == 0) return stairs[i - 1][j + 1];
        if (j == 9) return stairs[i - 1][j - 1];

        return (stairs[i - 1][j - 1] + stairs[i - 1][j + 1]) % div;
    }
}
