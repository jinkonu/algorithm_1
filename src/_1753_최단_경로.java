import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _1753_최단_경로 {

    static int MAX = 10000;

    static int V;
    static int E;
    static int K;

    static List<Node>[] edges;
    static int[] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] inputs = reader.readLine().split(" ");
        V = Integer.parseInt(inputs[0]);
        E = Integer.parseInt(inputs[1]);
        K = Integer.parseInt(reader.readLine());

        edges = new ArrayList[V + 1];
        distances = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            edges[i] = new ArrayList<>();
        }
        Arrays.fill(distances, MAX);

        for (int i = 0; i < E; i++) {
            inputs = reader.readLine().split(" ");
            int u = Integer.parseInt(inputs[0]);
            int v = Integer.parseInt(inputs[1]);
            int w = Integer.parseInt(inputs[2]);

            edges[u].add(new Node(v, w));
        }

        dijkstra();

        for (int i = 1; i <= V; i++) {
            if (distances[i] == MAX) {
                result.append("INF").append("\n");
            }
            else {
                result.append(distances[i]).append("\n");
            }
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];

        queue.add(new Node(K, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int current = node.end;

            if (visited[current]) {
                continue;
            }
            visited[current] = true;

            for (Node neighbor : edges[current]) {
                if (distances[neighbor.end] > distances[current] + neighbor.weight) {
                    distances[neighbor.end] = distances[current] + neighbor.weight;
                    queue.add(new Node(neighbor.end, distances[neighbor.end]));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int end, weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}