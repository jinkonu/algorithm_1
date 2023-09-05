package low_2.bruteForce;

/*
2023년 9월 5일 화요일
(1)
    brute force 문제다.
    그렇다고 하더라도 중복을 최대한 줄여야 하긴 한다.
(2)
    row 기준으로 잡고 가로로 쭉 돌려보고 싶었다.
    그래서 matrix와 transpose 하나씩 만들어서 둘 다 가로로 돌렸다.
    그러면, transpose를 통해 세로까지 돌려볼 수 있게 된다.

    즉, 가로와 세로로 총 두 번 행렬을 모두 훑으면서 인접한 두 개가 서로 다르면 바꾼 다음에,
    바뀐 부분의 행과 열만( 총 세 개 ) 탐색했다.
    그리고 다시 swap()해서 돌려놓는다.
 */

import java.io.*;

import static java.lang.Math.*;

public class Bomboni_3085 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(br.readLine());
        char[][] matrix = new char[N][N];
        char[][] transpose = new char[N][N];
        int max = 0;

        for (int i = 0; i < N; i++)
            matrix[i] = br.readLine().toCharArray();

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                transpose[j][i] = matrix[i][j];

        for (int i = 0; i < N; i++) {
            max = max(max, find(matrix[i]));
            max = max(max, find(transpose[i]));
        }

        for (int i = 0; i < N; i++)
            for (int j = 1; j < N; j++) {
                if (matrix[i][j] != matrix[i][j - 1]) {
                    swap(matrix, i, j, i, j - 1);
                    swap(transpose, j, i, j - 1, i);

                    max = max(max, find(matrix[i]));
                    max = max(max, find(transpose[j - 1]));
                    max = max(max, find(transpose[j]));

                    swap(matrix, i, j, i, j - 1);
                    swap(transpose, j, i, j - 1, i);
                }
            }

        for (int i = 0; i < N; i++)
            for (int j = 1; j < N; j++) {
                if (transpose[i][j] != transpose[i][j - 1]) {
                    swap(transpose, i, j, i, j - 1);
                    swap(matrix, j, i, j - 1, i);

                    max = max(max, find(transpose[i]));
                    max = max(max, find(matrix[j - 1]));
                    max = max(max, find(matrix[j]));

                    swap(transpose, i, j, i, j - 1);
                    swap(matrix, j, i, j - 1, i);
                }
            }

        result.append(max);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int find(char[] line) {
        int retVal = 1;
        int tmpMax = 1;

        for (int i = 1; i < line.length; i++) {
            if (line[i] == line[i - 1]) ++tmpMax;
            else {
                retVal = max(retVal, tmpMax);
                tmpMax = 1;
            }

            if (i == line.length - 1) {
                retVal = max(retVal, tmpMax);
                tmpMax = 1;
            }
        }

        return retVal;
    }

    static void swap(char[][] mat, int ai, int aj, int bi, int bj) {
        char tmp = mat[ai][aj];
        mat[ai][aj] = mat[bi][bj];
        mat[bi][bj] = tmp;
    }
}

//for (int i = 0; i < N; i++) {
//        for (int j = 0; j < N; j++)
//        System.out.print(matrix[i][j] + " ");
//        System.out.println();
//        }
//
//        for (int i = 0; i < N; i++) {
//        for (int j = 0; j < N; j++)
//        System.out.print(transpose[i][j] + " ");
//        System.out.println();
//        }