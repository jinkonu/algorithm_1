package low_2.graph_1;

import java.io.*;
import java.util.LinkedList;

import static java.lang.Integer.*;

public class ConnectedComponentNumber_11724 {
    static LinkedList<Integer>[] adjList;
    static boolean[] visited;

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] line = br.readLine().split(" ");

        int N = parseInt(line[0]);
        int M = parseInt(line[1]);
        adjList = new LinkedList[N + 1];
        visited = new boolean[N + 1];
        int count = 0;

        // union-find
        parent = new int[N + 1];
        rank = new int[N + 1];

        for (int i = 1; i < N + 1; i++)
            adjList[i] = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int u = parseInt(input[0]);
            int v = parseInt(input[1]);

            adjList[u].add(v);
            adjList[v].add(u);
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

        for (Integer adj : adjList[v]) {
            if (!visited[adj]) {
                dfs(adj);
            }
        }
    }
}
