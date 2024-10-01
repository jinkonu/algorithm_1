package tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _4803_트리 {

    static int caseNumber;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int numberOfTrees;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // List<List<Integer>> tree: 노드 간 연결
        // int[N] visited: 모두 방문할 때까지
        caseNumber = 1;

        while (true) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            if (n == 0 && m == 0)
                break;

            graph = new ArrayList<>();
            visited = new boolean[n + 1];
            numberOfTrees = 0;

            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                inputs = reader.readLine().split(" ");
                int x = Integer.parseInt(inputs[0]);
                int y = Integer.parseInt(inputs[1]);

                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i])
                    if (bfs(i))
                        ++numberOfTrees;
            }

            print();
            ++caseNumber;
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static boolean bfs(int root) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(root);
        visited[root] = true;
        int node = 0, edge = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            node++;
            visited[current] = true;

            for (int neighbor : graph.get(current)) {
                edge++;

                if (!visited[neighbor])
                    queue.add(neighbor);
            }
        }

        return (node - 1) * 2 == edge;
    }

    private static void print() {
        switch (numberOfTrees) {
            case 0 -> System.out.printf("Case %d: No trees.\n", caseNumber);
            case 1 -> System.out.printf("Case %d: There is one tree.\n", caseNumber);
            default -> System.out.printf("Case %d: A forest of %d trees.\n", caseNumber, numberOfTrees);
        }
    }
}
