package low_2.bruteForce_5;

/*
2023년 9월 26일 화요일
(1)
    brute force 문제이다.
    문제를 해결하지 못해서 여러 답안을 참고했다.
(2)
    첫 번째 참고는 findMax()에 드러난다.
    하나도 건드리지 않은 (즉 모두 세로의 형태) 종이조각에서 모두 건드린 (즉 모두 가로의 형태) 종이조각으로 넘어가며 계산한다.
    그리고 한 종이조각에서 다른 종이조각으로는 재귀를 통해 움직인다.
(3)
    그런데 main() 안에서 for 문으로 풀 수 있는 사기적인 방법이 있다.
    k = 0부터 1 << (n * m) - 1까지 달리면 n * m 행렬의 모든 경우의 수를 따질 수 있다...
    처음에는 이 outer for loop의 의미를 이해하기 어려웠다.
 */

import java.io.*;

import static java.lang.Integer.*;

public class PaperFragment_14391 {
    static int n;
    static int m;
    static int[][] matrix;
    static boolean[][] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] line = br.readLine().split(" ");

        n = parseInt(line[0]);
        m = parseInt(line[1]);
        matrix = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++)
                matrix[i][j] = input.charAt(j) - '0';
        }

        for (int k = 0; k < (1 << (n * m)); k++) {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                int curr = 0;
                for (int j = 0; j < m; j++) {
                    if ((k & (1 << i * n + j)) == 0) {
                        curr *= 10;
                        curr += matrix[i][j];
                    } else {
                        sum += curr;
                        curr = 0;
                    }
                }
                sum += curr;
            }

            for (int j = 0; j < m; j++) {
                int curr = 0;
                for (int i = 0; i < n; i++) {
                    if ((k & (1 << i * n + j)) != 0) {
                        curr *= 10;
                        curr += matrix[i][j];
                    } else {
                        sum += curr;
                        curr = 0;
                    }
                }
                sum += curr;
            }

            max = Math.max(max, sum);
        }

        result.append(max);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void findMax(int r, int c) {
        if (r == n) {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                int line = 0;
                for (int j = m - 1; j >= 0; j--)
                    if (visited[i][j]) sum += Math.pow(10, line++) * matrix[i][j];
            }

            for (int j = 0; j < m; j++) {
                int line = 0;
                for (int i = n - 1; i >= 0; i--)
                    if (!visited[i][j]) sum += Math.pow(10, line++) * matrix[i][j];
            }

            max = Math.max(max, sum);
            return;
        }

        if (c == m) {
            findMax(r + 1, 0);
            return;
        }

        visited[r][c] = true;
        findMax(r, c + 1);

        visited[r][c] = false;
        findMax(r, c + 1);
    }
}
