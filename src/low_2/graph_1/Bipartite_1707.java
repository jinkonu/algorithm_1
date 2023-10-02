package low_2.graph_1;

/*
2023년 10월 2일 월요일
(1)
    오랜만에 돌아왔다...
    bipartite 여부를 찾는 문제다.
(2)
    bfs로 탐색하면서 모든 vertex마다 -1 혹은 1의 값을 할당했다.
    그 과정에서 서로 인접한 vertex가 동일한 값을 가지고 있는 경우 bipartite가 불가능하므로 NO를 출력한다.
(3)
    처음에는 홀수 길이의 사이클을 찾는 데에만 혈안이 되어 있어서 시도했으나 메모리 초과가 발생했다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.Integer.*;

public class Bipartite_1707 {
    static int V;
    static int E;
    static List<Integer>[] edges;
    static int[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int K = parseInt(br.readLine());

        outer :
        for (int i = 0; i < K; i++) {
            String[] line = br.readLine().split(" ");
            V = parseInt(line[0]);
            E = parseInt(line[1]);
            edges = new List[V + 1];
            colors = new int[V + 1];
            boolean retVal = false;

            // edges 초기화
            for (int j = 1; j <= V; j++)
                edges[j] = new ArrayList<>();

            // edge 입력값 받기
            for (int j = 0; j < E; j++) {
                line = br.readLine().split(" ");
                int u = parseInt(line[0]);
                int v = parseInt(line[1]);

                edges[u].add(v);
                edges[v].add(u);
            }

            // 모든 vertex에 대해 bfs 실시
            for (int j = 1; j <= V; j++) {
                if (colors[j] == 0) retVal = bfs(j, -1);
                if (!retVal) break;
            }

            // bfs 결과값 출력
            if (retVal) result.append("YES").append("\n");
            else result.append("NO").append("\n");
        }

        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean bfs(int src, int color) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);
        colors[src] = color;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (Integer adj : edges[curr]) {
                if (colors[curr] == colors[adj]) {
                    return false;
                }

                if (colors[adj] == 0) {
                    colors[adj] = colors[curr] * -1;
                    queue.add(adj);
                }
            }
        }

        return true;
    }
}
