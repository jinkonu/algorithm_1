package low_2.graph_2;

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;

public class SubwaySecondLine_16947 {
    static int N;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        N = parseInt(br.readLine());
        adjList = new List[N + 1];
        visited = new boolean[N + 1];
        List<Integer> cycle = new ArrayList<>();
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");

            int u = parseInt(line[0]);
            int v = parseInt(line[1]);

            adjList[u].add(v);
            adjList[v].add(u);
        }

        for (int i = 1; i <= N; i++)
            if (!visited[i]) {
                cycle = bfs(i);
                if (cycle.size() > 1) break;
            }

        System.out.println("cycle = " + cycle);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static List<Integer> bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> cycle = new ArrayList<>();

        queue.add(v);
        visited[v] = true;

        outer:
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (Integer adj : adjList[curr]) {
                if (!visited[adj]) {
                    queue.add(adj);
                    visited[adj] = true;
                    parent[adj] = curr;
                } else if (parent[curr] != adj) {
                    cycle.add(adj);
                    int node = curr;
                    while (node != adj) {
                        cycle.add(node);
                        node = parent[node];
                    }
                }
            }
        }

        return cycle;
    }
}
