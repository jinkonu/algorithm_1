package soptrithm.week_2;

/*
 * 최단 거리를 찾는 문제다.
 * BFS를 통해 최단 거리를 찾는다.
 * */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class _14496_그대_그머가_되어 {

    static int N;
    static int M;
    static boolean[][] connected;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START

        String[] input = reader.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        connected = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            input = reader.readLine().split(" ");
            connected[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = true;
            connected[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = true;
        }

        bfs(x, y);
        result.append(min);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void bfs(int x, int y) {
        boolean[] visited = new boolean[N + 1];
        visited[x] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, x));

        while (!queue.isEmpty()) {
            Point currPoint = queue.poll();

            if (currPoint.location == y) {
                min = Math.min(min, currPoint.distance);
                continue;
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && connected[currPoint.location][i]) {
                    visited[i] = true;
                    queue.add(new Point(currPoint.distance + 1, i));
                }
            }
        }

        if (min == Integer.MAX_VALUE)
            min = -1;
    }
}

class Point {
    int location;
    int distance;

    public Point(int distance, int location) {
        this.distance = distance;
        this.location = location;
    }
}