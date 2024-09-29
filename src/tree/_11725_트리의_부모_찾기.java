package tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _11725_트리의_부모_찾기 {

    static List<List<Integer>> tree;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // List<List<Integer>>로 edge를 저장한다.
        // dfs로 root부터 인접 노드를 찾으면서 자식을 찾아, 자식의 부모를 저장해준다.
        // 인접 노드를 통해 다음 자식 노드를 찾을 때, 부모 자신을 제외해야 한다.
        int N = Integer.parseInt(reader.readLine());
        tree = new ArrayList<>();
        parents = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] inputs = reader.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);

            tree.get(x).add(y);
            tree.get(y).add(x);
        }

        dfs(1, -1);

        for (int i = 2; i <= N; i++) {
            result.append(parents[i]).append("\n");
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dfs(int current, int parent) {
        parents[current] = parent;

        for (Integer children : tree.get(current)) {
            if (children != parent) {
                dfs(children, current);
            }
        }
    }
}
