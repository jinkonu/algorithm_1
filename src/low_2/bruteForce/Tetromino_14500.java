package low_2.bruteForce;

import java.io.*;

/*
2023년 9월 7일 목요일
(1)
    brute force 문제다.
    대칭과 회전까지 신경써야 한다는 점이 걸렸지만,
    다섯 가지 블록 모양 중 세 가지는 2*3 or 3*2 블록에서 두 블록을 제거한 셈이라는 것을 깨닫고,
    동일한 for loop에서 처리했더니 조금 빨라졌다.
 */

import static java.lang.Integer.*;

public class Tetromino_14500 {
    static int max = 0;
    static int[][] matrix;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] firstLine = br.readLine().split(" ");

        N = parseInt(firstLine[0]);
        M = parseInt(firstLine[1]);
        matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                matrix[i][j] = parseInt(line[j]);
            }
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                line(i, j);
                nieunAndThunerAndFuckYou(i, j);
                nemo(i, j);
            }

        result.append(max);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void line(int i, int j) {
        if (i < N - 3)
            max = Math.max(max, matrix[i][j] + matrix[i + 1][j] + matrix[i + 2][j] + matrix[i + 3][j]);
        if (j < M - 3)
            max = Math.max(max, matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] + matrix[i][j + 3]);
    }

    private static void nieunAndThunerAndFuckYou(int i, int j) {
        if (i < N - 1 && j < M - 2) {
            int garoSix = 0;
            for (int x = i; x < i + 2; x++)
                for (int y = j; y < j + 3; y++)
                    garoSix += matrix[x][y];

            max = Math.max(max, garoSix - (matrix[i + 1][j + 1] + matrix[i + 1][j + 2]));
            max = Math.max(max, garoSix - (matrix[i + 1][j] + matrix[i + 1][j + 1]));
            max = Math.max(max, garoSix - (matrix[i][j + 1] + matrix[i][j + 2]));
            max = Math.max(max, garoSix - (matrix[i][j] + matrix[i][j + 1]));

            max = Math.max(max, garoSix - (matrix[i][j] + matrix[i + 1][j + 2]));
            max = Math.max(max, garoSix - (matrix[i + 1][j] + matrix[i][j + 2]));

            max = Math.max(max, garoSix - (matrix[i + 1][j] + matrix[i + 1][j + 2]));
            max = Math.max(max, garoSix - (matrix[i][j] + matrix[i][j + 2]));
        }

        if (i < N - 2 && j < M - 1) {
            int seroSix = 0;
            for (int x = i; x < i + 3; x++)
                for (int y = j; y < j + 2; y++)
                    seroSix += matrix[x][y];

            max = Math.max(max, seroSix - (matrix[i][j + 1] + matrix[i + 1][j + 1]));
            max = Math.max(max, seroSix - (matrix[i][j] + matrix[i + 1][j]));
            max = Math.max(max, seroSix - (matrix[i + 1][j + 1] + matrix[i + 2][j + 1]));
            max = Math.max(max, seroSix - (matrix[i + 1][j] + matrix[i + 2][j]));

            max = Math.max(max, seroSix - (matrix[i + 2][j] + matrix[i][j + 1]));
            max = Math.max(max, seroSix - (matrix[i][j] + matrix[i + 2][j + 1]));

            max = Math.max(max, seroSix - (matrix[i][j + 1] + matrix[i + 2][j + 1]));
            max = Math.max(max, seroSix - (matrix[i][j] + matrix[i + 2][j]));
        }
    }

    private static void nieun(int i , int j) {
        if (i < N - 1 && j < M - 2) {
            int garoSix = 0;
            for (int x = i; x < i + 2; x++)
                for (int y = j; y < j + 3; y++)
                    garoSix += matrix[x][y];

            max = Math.max(max, garoSix - (matrix[i + 1][j + 1] + matrix[i + 1][j + 2]));
            max = Math.max(max, garoSix - (matrix[i + 1][j] + matrix[i + 1][j + 1]));
            max = Math.max(max, garoSix - (matrix[i][j + 1] + matrix[i][j + 2]));
            max = Math.max(max, garoSix - (matrix[i][j] + matrix[i][j + 1]));
        }

        if (i < N - 2 && j < M - 1) {
            int seroSix = 0;
            for (int x = i; x < i + 3; x++)
                for (int y = j; y < j + 2; y++)
                    seroSix += matrix[x][y];

            max = Math.max(max, seroSix - (matrix[i][j + 1] + matrix[i + 1][j + 1]));
            max = Math.max(max, seroSix - (matrix[i][j] + matrix[i + 1][j]));
            max = Math.max(max, seroSix - (matrix[i + 1][j + 1] + matrix[i + 2][j + 1]));
            max = Math.max(max, seroSix - (matrix[i + 1][j] + matrix[i + 2][j]));
        }
    }

    private static void thunder(int i, int j) {
        if (i < N - 1 && j < M - 2) {
            int garoSix = 0;
            for (int x = i; x < i + 2; x++)
                for (int y = j; y < j + 3; y++)
                    garoSix += matrix[x][y];

            max = Math.max(max, garoSix - (matrix[i][j] + matrix[i + 1][j + 2]));
            max = Math.max(max, garoSix - (matrix[i + 1][j] + matrix[i][j + 2]));
        }

        if (i < N - 2 && j < M - 1) {
            int seroSix = 0;
            for (int x = i; x < i + 3; x++)
                for (int y = j; y < j + 2; y++)
                    seroSix += matrix[x][y];

            max = Math.max(max, seroSix - (matrix[i + 2][j] + matrix[i][j + 1]));
            max = Math.max(max, seroSix - (matrix[i][j] + matrix[i + 2][j + 1]));
        }
    }

    private static void fuckyou(int i, int j) {
        if (i < N - 1 && j < M - 2) {
            int garoSix = 0;
            for (int x = i; x < i + 2; x++)
                for (int y = j; y < j + 3; y++)
                    garoSix += matrix[x][y];

            max = Math.max(max, garoSix - (matrix[i + 1][j] + matrix[i + 1][j + 2]));
            max = Math.max(max, garoSix - (matrix[i][j] + matrix[i][j + 2]));
        }

        if (i < N - 2 && j < M - 1) {
            int seroSix = 0;
            for (int x = i; x < i + 3; x++)
                for (int y = j; y < j + 2; y++)
                    seroSix += matrix[x][y];

            max = Math.max(max, seroSix - (matrix[i][j + 1] + matrix[i + 2][j + 1]));
            max = Math.max(max, seroSix - (matrix[i][j] + matrix[i + 2][j]));
        }
    }

    private static void nemo(int i, int j) {
        if (i < N - 1 && j < M - 1) {
            int nemo = 0;
            for (int x = i; x < i + 2; x++)
                for (int y = j; y < j + 2; y++)
                    nemo += matrix[x][y];

            max = Math.max(max, nemo);
        }
    }
}
