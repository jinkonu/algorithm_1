import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _1916_최소비용_구하기 {

    static int MAX = 100_000_001;
    static int N;
    static int M;
    static List<City>[] edges;
    static int[] distances;
    static int departure;
    static int destination;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // List<Node>[]를 edges로 운용한다
        // PriorityQueue를 써서 가장 거리가 가까운 다음 노드를 선택하도록 한다
        // BFS와 비슷하다
        // 근데 거리의 최댓값을 잘 설정해야 한다.
        // 한 edge의 weight 최댓값 + 1로 설정할 경우,
        // 1 -> 2, 2 -> 3 사이의 weight가 모두 최댓값이게 되면,
        // distances[3] > distances[2] + weight of (2 -> 3) 식이 성립하지 않게 된다.
        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());
        edges = new List[N + 1];
        distances = new int[N + 1];

        for (int i = 1 ; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        Arrays.fill(distances, MAX);

        String[] inputs;
        for (int i = 0; i < M; i++) {
            inputs = reader.readLine().split(" ");
            int u = Integer.parseInt(inputs[0]);
            int v = Integer.parseInt(inputs[1]);
            int w = Integer.parseInt(inputs[2]);

            edges[u].add(new City(v, w));
        }

        inputs = reader.readLine().split(" ");
        departure = Integer.parseInt(inputs[0]);
        destination = Integer.parseInt(inputs[1]);

        distances[departure] = 0;
        dijkstra();
        result.append(distances[destination]);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dijkstra() {
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<City> queue = new PriorityQueue<>();

        queue.add(new City(departure, 0));
        while (!queue.isEmpty()) {
            City city = queue.poll();
            int current = city.vertex;

            if (visited[current]) {
                continue;
            }
            visited[current] = true;

            for (City neighbor : edges[current]) {
                if (distances[neighbor.vertex] > distances[current] + neighbor.weight) {
                    distances[neighbor.vertex] = distances[current] + neighbor.weight;
                    queue.add(new City(neighbor.vertex, distances[neighbor.vertex]));
                }
            }
        }
    }
}

class City implements Comparable<City> {

    int vertex;
    int weight;

    public City(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(City city) {
        return weight - city.weight;
    }
}