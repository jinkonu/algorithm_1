package soptrithm.week_5;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _3187_양치기_꿍 {

    static int N;
    static int M;

    static boolean[][] visited;
    static int[][] ranch;
    static int sheepNumber = 0;
    static int wolfNumber = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * BFS를 통해 각 울타리 영역을 모두 탐색한다.
        * 각 울타리 영역에 해당하는 k와 v의 개수를 비교한다.
        * 0 = 울타리, 1 = 비어 있음, 2 = 양, 3 = 늑대
        * */

        String[] input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        visited = new boolean[N][M];
        ranch = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = reader.readLine();

            for (int j = 0; j < M; j++) {
                switch (line.charAt(j)) {
                    case '#' -> {
                        ranch[i][j] = 0;
                        visited[i][j] = true;
                    }
                    case '.' -> ranch[i][j] = 1;
                    case 'k' -> ranch[i][j] = 2;
                    default ->  ranch[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ranch[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        result.append(sheepNumber).append(" ").append(wolfNumber);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void bfs(int y, int x) {
        Map<Integer, Integer> sheepAndWolves = new HashMap<>();
        sheepAndWolves.put(2, 0);
        sheepAndWolves.put(3, 0);

        Queue<Point> queue = new LinkedList<>();

        visited[y][x] = true;
        queue.add(new Point(y, x));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            check(ranch[point.y][point.x], sheepAndWolves);

            for (int i = 0; i < 4; i++) {
                Point near = new Point(point.y + dy[i], point.x + dx[i]);

                if (isReachable(near)) {
                    visited[near.y][near.x] = true;
                    queue.add(near);
                }
            }
        }

        int sheep = sheepAndWolves.get(2);
        int wolves = sheepAndWolves.get(3);

        if (sheep > wolves)
            sheepNumber += sheep;
        else
            wolfNumber += wolves;
    }

    private static void check(int key, Map<Integer, Integer> sheepAndWolves) {
        if (sheepAndWolves.containsKey(key))
            sheepAndWolves.put(key, sheepAndWolves.get(key) + 1);
    }


    private static boolean isReachable(Point point) {
        return 0 <= point.y && point.y < N
                && 0 <= point.x && point.x < M
                && !visited[point.y][point.x];
    }
}

class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.x = x;
        this.y = y;
    }
}