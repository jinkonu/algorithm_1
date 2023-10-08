package low_2.graph_2;

/*
2023년 10월 8일 일요일
(1)
    입력값이 BFS 탐색 순서에 맞는지 확인하는 문제다.
    나는 입력 수열의 가능한 모든 BFS 순열 중에 입력값이 포함되는지 확인하는 식으로 진행했다.
    그런데 이 부분이 도저히 해결이 안되었고, 방향을 변경했다.
(2)
    아래 방식은 한 정점(X)에 대해 여러 개의 방문하지 않은 정점(Y)이 있을 때를 고려한다.
    BFS는 이 때 여러 케이스로 나뉘게 된다. 그런데 중요한 건 케이스가 나뉘는 게 아니다.
    어차피 이 Y가 들어가야 할 인덱스는 정해져 있다.
    그러니까 입력값에서도 이 인덱스 범위 내에 앎맞은 숫자들만, 즉 Y로만 구성되어 있는지 확인하면 된다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.Integer.*;

public class BfsSpecialJudge_16940 {
    static int N;
    static List<Integer>[] adjList;
    static int[] input;
    static Queue<Integer> queue;
    static boolean[] visited;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        N = parseInt(br.readLine());
        adjList = new List[N + 1];
        input = new int[N + 1];
        queue = new LinkedList<>();
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 1; i <= N - 1; i++) {
            String[] line = br.readLine().split(" ");

            int u = parseInt(line[0]);
            int v = parseInt(line[1]);

            adjList[u].add(v);
            adjList[v].add(u);
        }

        String[] line = br.readLine().split(" ");
        for (int i = 1; i <= N; i++)
            input[i] = parseInt(line[i - 1]);

        if (input[1] != 1) {
            System.out.print("0");
            return;
        }

        // BFS
        bfs(1);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void bfs(int i) {
        queue.offer(i);
        visited[i] = true;
        idx = 2;

        while (!queue.isEmpty()) {
            int v = queue.poll();

            int count = 0;
            for (int adj : adjList[v]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    ++count;
                }
            }

            for (int j = idx; j < idx + count; j++) {
                if (!visited[input[i]]) {
                    System.out.printf("0");
                    return;
                }

                else
                    queue.offer(j);
            }

            idx += count;
        }

        System.out.println("1");
    }
}
