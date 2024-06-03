package soptrithm.week_7;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class _17836_공주님을_구해라 {

    static int r;
    static int c;
    static int t;
    static int[][] map;

    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * 최단 거리를 구하는 것이니까 bfs가 편할 것 같다.
        * */

        String[] input = reader.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        t = Integer.parseInt(input[2]);
        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            input = reader.readLine().split(" ");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int minDistance = bfs();

        if (minDistance > t)
            result.append("Fail");
        else
            result.append(minDistance);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static int bfs() {
        int minDistance = t + 1;
        Queue<Knight> queue = new LinkedList<>();

        map[0][0] = 1;
        queue.add(new Knight(0, 0, 0, false));

        while (!queue.isEmpty()) {
            Knight knight = queue.poll();

            if (knight.hasSword) {
                minDistance = Math.min(minDistance, knight.time + Math.abs(r - 1 - knight.y) + Math.abs(c - 1 - knight.x));
                continue;
            }

            if (isEndPoint(knight)) {
                minDistance = Math.min(minDistance, knight.time);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                Knight next = new Knight(knight.y + dy[i], knight.x + dx[i], knight.time + 1, false);

                if (isReachable(next.y, next.x) && next.time <= t) {
                    if (map[next.y][next.x] == 2) {
                        next.hasSword = true;
                    }

                    map[next.y][next.x] = 1;
                    queue.add(next);
                }
            }
        }

        return minDistance;
    }

    private static boolean isReachable(int y, int x) {
        return y >= 0 && x >= 0
                && y < r && x < c
                && map[y][x] != 1;
    }

    private static boolean isEndPoint(Knight knight) {
        return knight.y == r - 1 && knight.x == c - 1;
    }
}

class Knight {
    int y;
    int x;
    int time;
    boolean hasSword;

    public Knight(int y, int x, int time, boolean hasSword) {
        this.y = y;
        this.x = x;
        this.time = time;
        this.hasSword = hasSword;
    }
}