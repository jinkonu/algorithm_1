package low_1.dynamicProgramming_2;

/*
2023년 8월 30일 수요일
(1)
    간단한 dp 문제다.
    int[][] tri 2차원 배열에 입력값을 집어넣었다.
    int[]까지만 n으로 초기화하고, int[][]부터는 for loop에서 동적으로 초기화했다.
(2)
    tri의 k(k > 0)번째 엔트리부터 k - 1번째 엔트리를 참고하면서 tri에 값을 덮어썼다.
    tri[k][0]과 tri[k][1 ~ k-1], tri[k][k] 케이스를 분리해서 계산했다.
 */

import java.io.*;

public class IntegerTriangle_1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n][];
        long max = 0;

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            tri[i] = new int[i + 1];
            for (int j = 0; j <= i; j++)
                tri[i][j] = Integer.parseInt(line[j]);
        }

        for (int i = 1; i < n; i++) {
            tri[i][0] += tri[i - 1][0];
            for (int j = 1; j < i; j++)
                tri[i][j] += Math.max(tri[i - 1][j - 1], tri[i - 1][j]);
            tri[i][i] += tri[i - 1][i - 1];
        }

        for (int i = 0; i < n; i++)
            if (tri[n - 1][i] > max) max = tri[n - 1][i];

        result.append(max);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
