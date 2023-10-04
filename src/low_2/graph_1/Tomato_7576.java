package low_2.graph_1;

/*
2023년 10월 4일
(1)
    bfs 관련 문제다.
    성능이 안 나와서 다른 답안을 참조하니 int[][]형 대신 클래스를 정의하는 부분이 있었다.
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.parseInt;

public class Tomato_7576 {
    static int N;
    static int M;
    static int[][] matrix;
    static int[][] rotten;
    static int rottenCnt;
    static int numOfZero;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] meta = br.readLine().split(" ");
        N = parseInt(meta[1]);
        M = parseInt(meta[0]);
        matrix = new int[N][M];
        rotten = new int[N * M][2];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                switch (line[j]) {
                    case "-1" -> {
                        matrix[i][j] = -1;
                    }
                    case "0"  -> {
                        matrix[i][j] =  0;
                        ++numOfZero;
                    }
                    case "1"  -> {
                        matrix[i][j] =  1;
                        rotten[rottenCnt][0] = i; rotten[rottenCnt][1] = j;
                        ++rottenCnt;
                    }
                }
            }
        }

        result.append(bfs());
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs() {
        int cnt = 1;

        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        Queue<Integer> queueX2 = new LinkedList<>();
        Queue<Integer> queueY2 = new LinkedList<>();

        if (numOfZero == 0) return 0;

        for (int i = 0; i < rottenCnt; i++) {
            queueX.add(rotten[i][0]);
            queueY.add(rotten[i][1]);

            matrix[rotten[i][0]][rotten[i][1]] = -1;
        }

        while (!queueX.isEmpty()) {
            int x = queueX.poll();
            int y = queueY.poll();

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (isValid(newX, newY)) {
                    queueX2.add(newX); queueY2.add(newY);
                    matrix[newX][newY] = -1;

                    --numOfZero;
                }
            }

            if (numOfZero == 0)
                return cnt;

            if (queueX.isEmpty()) {
                queueX.addAll(queueX2); queueY.addAll(queueY2);
                queueX2.clear(); queueY2.clear();

                ++cnt;
            }
        }

        return -1;
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && matrix[x][y] != -1;
    }
}
