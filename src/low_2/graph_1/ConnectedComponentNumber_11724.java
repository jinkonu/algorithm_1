package low_2.graph_1;

/*
2023년 9월 28일 목요일
(1)
    dfs를 가지고 사이클의 개수를 결정하는 문제다.
    원래는 edge를 저장하는 자료구조로 LinkedList<Integer>를 사용했으나,
    조금 느리다고 판단되어 기본형인 int[][]로 바꿔봤다.
 */

import java.io.*;

import static java.lang.Integer.*;

public class ConnectedComponentNumber_11724 {
    static int N;
    static boolean[][] edge;
    static boolean[] visited;

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] line = br.readLine().split(" ");

        N = parseInt(line[0]);
        int M = parseInt(line[1]);
        edge = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        int count = 0;

        // union-find
        parent = new int[N + 1];
        rank = new int[N + 1];

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int u = parseInt(input[0]);
            int v = parseInt(input[1]);

            edge[u][v] = edge[v][u] = true;
        }

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // dfs
        for (int i = 1; i <= N; i++)
            if (!visited[i]) {
                ++count;
                dfs(i);
            }

        result.append(count);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dfs(int v) {
        visited[v] = true;

        for (int u = 1; u <= N; u++)
            if (edge[v][u] && !visited[u]) dfs(u);
    }
}
