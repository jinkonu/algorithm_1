package low_2.graph_1;

/*
2023년 10월 4일 수요일
(1)
    7562번 문제와 유사한 dfs 길찾기 문제다.
    다만, 7576번 문제와 달리 체스의 나이트가 움직이기 때문에, 그에 맞게 dx[]와 dy[]를 수정해줘야 한다.
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.parseInt;

public class MoveKnight_7562 {
    static StringBuilder result;
    static int length;
    static boolean[][] visited;
    static int startX; static int startY;
    static int endX; static int endY;

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        int T = parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            length = parseInt(br.readLine());
            visited = new boolean[length][length];

            String[] line1 = br.readLine().split(" ");
            startX = parseInt(line1[0]);
            startY = parseInt(line1[1]);

            String[] line2 = br.readLine().split(" ");
            endX = parseInt(line2[0]);
            endY = parseInt(line2[1]);

            if (startX == endX && startY == endY) result.append(0).append("\n");
            else find();
        }

        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH
        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void find() {
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] poll = queue.poll();

                if (poll[0] == endX && poll[1] == endY) {
                    result.append(cnt).append("\n");
                    return;
                }

                for (int j = 0; j < 8; j++) {
                    int newX = poll[0] + dx[j];
                    int newY = poll[1] + dy[j];

                    if (isValid(newX, newY) && !visited[newX][newY]) {
                        queue.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }

            ++cnt;
        }
    }

    private static void print() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (visited[i][j] )System.out.print(1 + " ");
                else System.out.print(0 + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < length && y >= 0 && y < length;
    }
}
