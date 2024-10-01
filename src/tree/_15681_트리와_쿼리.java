package tree;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15681_트리와_쿼리 {

    static int N, R, Q;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] childrenCount;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // 서브트리는 dfs로 개수를 찾는다.
        // dfs로 leaf까지 내려가고, 아래에서 위로 반환이 올라가면서 childrenCount를 더해가면 root까지 찾을 수 있다.
        String[] inputs = reader.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        R = Integer.parseInt(inputs[1]);
        Q = Integer.parseInt(inputs[2]);

        childrenCount = new int[N + 1];
        Arrays.fill(childrenCount, 1);

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            inputs = reader.readLine().split(" ");
            int u = Integer.parseInt(inputs[0]);
            int v = Integer.parseInt(inputs[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(R, -1);

        for (int i = 0; i < Q; i++) {
            int index = Integer.parseInt(reader.readLine());
            result.append(childrenCount[index]).append("\n");
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dfs(int current, int parent) {
        for (int child : graph.get(current)) {
            if (child != parent) {
                dfs(child, current);
            }
        }

        if (parent != -1)
            childrenCount[parent] += childrenCount[current];
    }
}