package soptrithm.week_2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class _1260_DFS와_BFS {

    static int N;
    static boolean[] DFS;
    static boolean[] BFS;
    static boolean[][] edges;
    static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        // DFS -> 재귀 함수 -> 현재 정점 출력 후 방문하지 않은 근처 정점 있으면 호출
        // BFS -> Queue 활용 -> 현재 정점 출력 후 방문하지 않은 모든 근처 정점들을 출력 및 Queue에 -> Queue에서 꺼내서 반복
        String[] metaLine = reader.readLine().split(" ");
        N = Integer.parseInt(metaLine[0]);
        int M = Integer.parseInt(metaLine[1]);
        int V = Integer.parseInt(metaLine[2]);

        DFS = new boolean[N + 1];
        BFS = new boolean[N + 1];
        edges = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            String[] line = reader.readLine().split(" ");

            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            edges[x][y] = true;
            edges[y][x] = true;
        }

        dfs(V);
        result.append("\n");
        bfs(V);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dfs(int v) {
        if (!DFS[v]) {
            DFS[v] = true;
            result.append(v).append(" ");

            for (int i = 1; i <= N; i++)
                if (!DFS[i] && edges[v][i])
                    dfs(i);
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        BFS[v] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            result.append(currentNode).append(" ");

            for (int i = 1; i <= N; i++) {
                if (edges[currentNode][i] && !BFS[i]) {
                    BFS[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
