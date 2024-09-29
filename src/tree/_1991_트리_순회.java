package tree;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class _1991_트리_순회 {

    static Map<String, Node> tree;
    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // dfs를 활용해 전위, 중위, 후위 순회를 구현하자.
        // 전위 순회는 출력, left, right
        // 중위 순회는 left, 출력, right
        // 후위 순회는 left, right, 출력
        // left, right를 가지고 있는 Node 객체를 정의한다.
        // Map<String, Node>로 노드들을 관리하여 left, right끼리 참조가 원활하게 이뤄지도록 한다.
        tree = new HashMap<>();
        int N = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++) {
            String[] inputs = reader.readLine().split(" ");

            Node parent, left, right;

            if (tree.containsKey(inputs[0]))
                parent = tree.get(inputs[0]);
            else {
                parent = new Node(inputs[0]);
                tree.put(parent.data, parent);
            }

            if (tree.containsKey(inputs[1]))
                left = tree.get(inputs[1]);
            else {
                left = new Node(inputs[1]);
                tree.put(left.data, left);
            }


            if (tree.containsKey(inputs[2]))
                right = tree.get(inputs[2]);
            else {
                right = new Node(inputs[2]);
                tree.put(right.data, right);
            }

            parent.setLeft(left);
            parent.setRight(right);

            if (parent.data.equals("A"))
                root = parent;
        }

        preOrder(root, result);
        result.append("\n");
        inOrder(root, result);
        result.append("\n");
        postOrder(root, result);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void preOrder(Node node, StringBuilder printer) {
        printer.append(node.data);

        if (!node.left.data.equals("."))
            preOrder(node.left, printer);

        if (!node.right.data.equals("."))
            preOrder(node.right, printer);
    }

    private static void inOrder(Node node, StringBuilder printer) {
        if (!node.left.data.equals("."))
            inOrder(node.left, printer);

        printer.append(node.data);

        if (!node.right.data.equals("."))
            inOrder(node.right, printer);
    }

    private static void postOrder(Node node, StringBuilder printer) {
        if (!node.left.data.equals("."))
            postOrder(node.left, printer);

        if (!node.right.data.equals("."))
            postOrder(node.right, printer);

        printer.append(node.data);
    }
}

class Node {

    String data;
    Node left, right;

    public Node(String data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
