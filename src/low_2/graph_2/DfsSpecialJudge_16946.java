package low_2.graph_2;

/*
2023년 10월 9일 월요일
(1)
    주어진 입력값이 DFS인지 확인해야 하는 문제다.
    leaf 정점에 걸렸을 때, 이것이 과연 회귀가 필요한 leaf인지, 다른 후보 정점이 있기 때문에 DFS에 실패하는지 찾기 매우 어려웠다.
(2)
    다른 답안을 보니, visited와 HashSet을 활용해서 미방문 인접 정점을 빠르게 모아서
    DFS 탐색을 더 할 수 있는지, 회귀해야 하는지, DFS에 실패했는지 세 가지 갈래 중에서 빠르게 판단하고 있다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static java.lang.Integer.*;

public class DfsSpecialJudge_16946 {
    static int N;
    static int[] input;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int idx = 1;
    static boolean flag = true;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        N = parseInt(br.readLine());
        input = new int[N + 1];
        adjList = new List[N + 1];
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

        // 입력값 받기
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            input[i] = parseInt(line[i]);

        // 입력값 첫 값이 1이 아니면 오답
        if (input[0] != 1) {
            System.out.println("0");
            return;
        }

        dfs(1);

        // dfs check
        if (flag) {
            System.out.print("1");
            return;
        }

        System.out.print("0");
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dfs(int i) {
        // 정점 방문
        visited[i] = true;

        // 정점에 인접한 정점들을 모은다
        HashSet<Integer> set = new HashSet<>();
        for (Integer adj : adjList[i]) {
            if (visited[adj]) continue;
            set.add(adj);
        }

        // 정점이 leaf인 경우
        if (set.size() == 0) return;

        // i 정점에서 인접한 정점 중 입력값이 있을 때 (재방문 포함)
        if (set.contains(input[idx]))
            dfs(input[idx++]);
        // i 정점에서 인접한 정점 중 입력값이 없을 때
        else
            flag = false;
    }
}
