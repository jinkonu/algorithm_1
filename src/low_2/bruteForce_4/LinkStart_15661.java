package low_2.bruteForce_4;

/*
2023년 9월 22일 금요일
(1)
    14889번과 유사한 brute force 문제다.
    다만 팀원수가 정확히 반반으로 나뉘지 않아도 된다는 점에서 combination()의 내용을 수정할 필요가 있었다.
    원래는 if (r == 0)일 때만 합산을 구했는데, 이제는 r >= 0, 즉 nC1부터 nCr까지 다 구해봐야 한다.
 */

import java.io.*;

import static java.lang.Integer.*;

public class LinkStart_15661 {
    static int N;
    static int[][] matrix;
    static int min = MAX_VALUE;
    static int[] statsum;

    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        N = parseInt(br.readLine());
        matrix = new int[N][N];
        boolean[] visited = new boolean[N];
        statsum = new int[N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int tmp = parseInt(line[j]);
                matrix[i][j] = tmp;
                total += tmp;
            }
        }

        for (int i = 0; i < N; i++) {
            int tmp = 0;
            for (int j = 0; j < N; j++)
                tmp += matrix[i][j] + matrix[j][i];
            statsum[i] = tmp;
        }

        combination(visited, 0, N, N / 2);
        result.append(min);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void combination(boolean[] visited, int start, int n, int r) {
        if(r >= 0) {
            int sum = 0;

            for (int i = 0; i < N; i++)
                if (visited[i])
                    sum += statsum[i];

            min = Math.min(min, Math.abs(total - sum));

            for (int i = start; i < n; i++) {
                visited[i] = true;
                combination(visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }

        else
            return;
    }
}
