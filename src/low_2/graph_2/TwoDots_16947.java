package low_2.graph_2;

/*
2023년 10월 8일
(1)
    dfs나 bfs로 사이클을 찾고, 사이클 이외 정점의 사이클에 대한 길이를 구해야 한다.
    나름 정확하게 구한 것 같고, 테스트 케이스는 전부 통과하는데 정작 제출하면 틀린다.
    반례도 도저히 찾을 수가 없으므로 잠시 여기서 중지한다.
 */

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;

public class TwoDots_16947 {
    static int N;
    static List<Integer>[] edges;
    static boolean[] visited;
    static Queue<Integer> cycle;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        N = parseInt(br.readLine());
        edges = new List[N + 1];
        visited = new boolean[N + 1];
        cycle = new LinkedList<>();
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");

            int u = parseInt(line[0]);
            int v = parseInt(line[1]);

            edges[u].add(v);
            edges[v].add(u);
        }

        for (int i = 1; i <= N; i++)
            if (!visited[i])
                if (dfs(i, -1, new ArrayList<>())) break;

        // dist -1로 초기화
        for (int i = 1; i <= N; i++)
            dist[i] = -1;

        // cycle 내 수는 0으로
        for (Integer c : cycle) {
            dist[c] = 0;
        }

        // cycle 외 수에 대해 결정
        while (!cycle.isEmpty()) {
            int num = cycle.poll();

            for (Integer adj : edges[num]) {
                if (dist[adj] == -1 && !cycle.contains(adj)) {
                    dist[adj] = dist[num] + 1;
                    cycle.add(adj);
                }
            }
        }

        // 출력
        for (int i = 1; i <= N; i++)
            result.append(dist[i]).append(" ");
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean dfs(int v, int p, List<Integer> list) {
        boolean retVal = false;
        visited[v] = true;
        list.add(v);

        for (Integer adj : edges[v])
            if (adj != p && list.contains(adj)) {
                if (list.size() > 1) cycle.addAll(list.subList(list.indexOf(adj), list.size()));
                return true;
            }

        for (Integer adj : edges[v]) {
            if (adj != p) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    retVal = dfs(adj, v, list);
                } else
                    retVal = true;
            }
        }

        return retVal;
    }
}
