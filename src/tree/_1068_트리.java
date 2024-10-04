package tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _1068_트리 {

    static int N;
    static List<Integer>[] tree;
    static int[] size;
    static int root;
    static int k;
    static int toBeLeaf = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // int[] size: k 노드가 루트인 서브트리의 리프 노드 개수
        // size[0] - size[k]를 구하면 될 듯하다
        // k를 지워서 k의 부모가 leaf가 되는 경우를 고려해야 한다
        N = Integer.parseInt(reader.readLine());
        tree = new ArrayList[N];
        size = new int[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        String[] inputs = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(inputs[i]);

            if (parent != -1)
                tree[parent].add(i);
            else
                root = i;
        }

        k = Integer.parseInt(reader.readLine());

        dfs(root, -1);
        result.append(size[root] - size[k] + toBeLeaf);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dfs(int current, int parent) {
        if (tree[current].isEmpty())
            size[current] = 1;
        else
            for (Integer child : tree[current]) {
                if (child == k && tree[current].size() == 1)
                    toBeLeaf = 1;

                dfs(child, current);
            }

        if (parent != -1) {
            size[parent] += size[current];
        }
    }
}
