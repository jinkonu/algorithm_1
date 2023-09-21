package low_2.bruteForce_3;

/*
2023년 9월 21일 목요일
(1)
    brute force 문제다.
(2)
    nCk 찾는 것부터 난항을 겪었다.
    combination()의 파라미터에 n과 r을 넣어놓고, r을 줄여가면서 for 문을 돌렸다.
(3)
    문제는 처음 방식은, r개와 n-r개 조합의 각 총합을 구해서 빼는 방식이었는데 성능이 너무 안 나왔다.
    그래서 다른 제출을 보고 따라했는데, 이 원리를 이해하기가 쉽지 않다.
(4)
    테스트 케이스를 가지고 계산해본 결과, statsum[]으로 nCr 조합(이 조합을 r)끼리 더하면, 이 값은 총합에서 n-r 조합 빼고 n 조합을 더한 값이 된다.
    그리고 이 값을 총합에서 빼면, 결국 n-r 조합과 n 조합의 차가 되는 것이다...
    이걸 어떻게 생각했나...
 */

import java.io.*;
import java.util.List;

import static java.lang.Integer.*;

public class StartLink_14889 {
    static int N;
    static int[][] matrix;
    static int min = MAX_VALUE;
    static int[] statsum;
    static List<Integer> x;

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

        System.out.println(statsum[0]);
        System.out.println(statsum[3]);
        System.out.println(total);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void combination(boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            int sum = 0;

            for (int i = 0; i < N; i++)
                if (visited[i])
                    sum += statsum[i];

            min = Math.min(min, Math.abs(total - sum));
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}
