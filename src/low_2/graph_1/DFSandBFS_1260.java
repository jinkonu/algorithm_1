package low_2.graph_1;

/*
2023년 9월 27일 수요일
(1)
    dfs와 bfs를 찾는 문제다.
    어렵진 않은데, dfs와 bfs 원리를 제대로 상기할 겸 인터넷에서 알고리즘을 참고했다.
(2)
    dfs는 재귀 호출이 필요하다. 대신 별다른 자료구조가 필요없다.
    파라미터 인덱스 v를 visit하고,v와 가장 가까운 정점에 대해 호출하는 방식이다.
(3)
    bfs는 재귀 호출이 필요하지 않다. 대신 별도의 자료구조로 Queue가 필요하다.
    시작 인덱스 v를 visit하고 queue에 집어넣는다.
    queue가 빌 때까지 queue의 끝 정점을 빼내서 출력하고, 그 정점과 인접한 모든 정점을 queue에 넣는다.
 */

import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.*;

public class DFSandBFS_1260 {
    static StringBuilder result;
    static int N;
    static int M;
    static int V;
    static LinkedList<Integer>[] adjList;

    static boolean[] visited;
    static Queue<Integer> bfsQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        String[] line = br.readLine().split(" ");

        N = parseInt(line[0]);
        M = parseInt(line[1]);
        V = parseInt(line[2]);
        adjList = new LinkedList[N + 1];

        for (int i = 1; i < N + 1; i++)
            adjList[i] = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int u = parseInt(input[0]);
            int v = parseInt(input[1]);

            adjList[u].add(v);
            adjList[v].add(u);
        }

        for (int i = 1; i < N + 1; i++)
            adjList[i].sort(Comparator.naturalOrder());

        visited = new boolean[N + 1];
        DFS(V);
        result.append("\n");

        visited = new boolean[N + 1];
        bfs(V);

        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void DFS(int v) {
        visited[v] = true;
        result.append(v).append(" ");

        for (Integer adj : adjList[v]) {
            if (!visited[adj]) {
                DFS(adj);
            }
        }
    }

    private static void bfs(int v) {
        bfsQueue.add(V);
        visited[V] = true;

        while (bfsQueue.size() != 0) {
            v = bfsQueue.poll();
            result.append(v).append(" ");

            for (Integer adj : adjList[v]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    bfsQueue.add(adj);
                }
            }
        }
    }
}
