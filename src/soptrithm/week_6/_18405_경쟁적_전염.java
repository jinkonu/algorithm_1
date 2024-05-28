package soptrithm.week_6;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _18405_경쟁적_전염 {

    static int n;
    static int k;
    static int s;
    static int x;
    static int y;

    static int[][] matrix;
    static List<Point>[] initials;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * bfs로 S초까지 시험관을 모두 채우고 나서 (X, Y) 위치의 값을 알아내는 것이 편할 것 같다.
        * */
        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        matrix = new int[n + 1][n + 1];
        initials = new ArrayList[k + 1];

        for (int i = 1; i <= k; i++) {
            initials[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            input = reader.readLine().split(" ");

            for (int j = 1; j <= n; j++) {
                matrix[i][j] = Integer.parseInt(input[j - 1]);

                if (matrix[i][j] > 0)
                    initials[matrix[i][j]].add(new Point(i, j));
            }
        }

        input = reader.readLine().split(" ");
        s = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);
        x = Integer.parseInt(input[2]);

        result.append(bfs());
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static int bfs() {
        int seconds = 0;
        Queue<Point> queue = new LinkedList<>();

        for (int i = 1; i <= k; i++) {
            queue.addAll(initials[i]);
        }

        while (seconds < s) {
            Queue<Point> nears = new LinkedList<>();

            for (Point point : queue) {
                for (int i = 0; i < 4; i++) {
                    Point near = new Point(point.y + dy[i], point.x + dx[i]);

                    if (isReachable(near)) {
                        nears.add(near);
                        matrix[near.y][near.x] = matrix[point.y][point.x];
                    }
                }
            }

            queue = nears;
            seconds++;
        }

        return matrix[y][x];
    }

    private static boolean isReachable(Point point) {
        return 1 <= point.y && point.y <= n &&
                1 <= point.x && point.x <= n &&
                matrix[point.y][point.x] == 0;
    }

    private static void print() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}