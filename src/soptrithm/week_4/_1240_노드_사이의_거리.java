package soptrithm.week_4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class _1240_노드_사이의_거리 {

    static int n;
    static int m;

    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * 다익스트라나 플로이드-워셜을 생각했는데,
        * 일부 쌍에 대해서만 찾는다면 bfs나 dfs로 충분히 해결 가능한 것 같다.
        * */
        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n - 1; i++) {
            input = reader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int d = Integer.parseInt(input[2]);

            dist[x][y] = d;
            dist[y][x] = d;
        }

        for (int i = 1; i <= m; i++) {
            input = reader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);


            result.append(bfs(x, y)).append("\n");
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static int bfs(int x, int y) {
        int minDistance = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n + 1];
        Queue<Node> queue = new LinkedList<>();

        visited[x] = true;
        queue.add(new Node(x, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.index == y)
                minDistance = Math.min(minDistance, node.distance);

            for (int i = 1; i <= n; i++)
                if (isReachable(node.index, i, visited)) {
                    visited[i] = true;
                    queue.add(new Node(i, node.distance + dist[node.index][i]));
                }
        }

        return minDistance;
    }

    private static boolean isReachable(int node, int near, boolean[] visited) {
        return dist[node][near] > 0 && !visited[near];
    }
}

class Node {
    int index;
    int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
}