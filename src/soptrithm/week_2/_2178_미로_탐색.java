package soptrithm.week_2;

/*
* BFS를 활용해서 현재 지점에서 동, 남, 서, 북을 큐에 추가한다.
* 큐에서 꺼내서 현재 지점으로 활용한다.
* 현재 지점이 도착 지점이면, 자신이 가진 거리가 최소인지 비교하여 수정한다.
*
* */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class _2178_미로_탐색 {

    static int min = Integer.MAX_VALUE;
    static boolean[][] maze;
    static boolean[][] visited;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] metaLine = reader.readLine().split(" ");
        n = Integer.parseInt(metaLine[0]);
        m = Integer.parseInt(metaLine[1]);

        maze = new boolean[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] line = reader.readLine().toCharArray();

            for (int j = 0; j < m; j++)
                if (line[j] == '1')
                    maze[i][j] = true;
        }

        bfs();
        result.append(min);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void bfs() {
        Queue<Location> queue = new LinkedList<>();

        queue.offer(new Location(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            checkIfArrived(location);

            checkIfVisited(location.x + 1, location.y, location.distance, queue);
            checkIfVisited(location.x, location.y + 1, location.distance, queue);
            checkIfVisited(location.x - 1, location.y, location.distance, queue);
            checkIfVisited(location.x, location.y - 1, location.distance, queue);
        }
    }

    private static void checkIfVisited(int x, int y, int distance, Queue<Location> queue) {
        if (0 <= x && x < n && 0 <= y && y < m)
            if (maze[x][y] && !visited[x][y]) {
                visited[x][y] = true;
                queue.offer(new Location(x, y, distance + 1));
            }
    }

    private static void checkIfArrived(Location location) {
        if (location.x == (n - 1) && location.y == (m - 1))
            min = Math.min(min, location.distance);
    }
}

class Location {
    int x;
    int y;
    int distance;

    public Location(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
