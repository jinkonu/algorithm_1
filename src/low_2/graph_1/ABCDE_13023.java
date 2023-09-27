package low_2.graph_1;

/*
2023년 9월 27일 수요일
(1)
    dfs 문제다.
    linked list를 수작업으로 만들려고 했지만, 한 vertex에 여러 vertex가 줄줄이 있는 건 필요가 없어서
    그냥 LinkedList를 사용했다.
(2)
    그런데 성능이 너무 안 나와서 무슨 문제가 있는지 했는데
    다른 사람의 답안을 봐도 유의미한 코드 차이가 보이지 않는다...
    억까 당했다고 생각하고 다른 문제 풀려고 한다.
 */

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

import static java.lang.Integer.*;

public class ABCDE_13023 {
    static StringBuilder result;
    static int N;
    static int M;
    static LinkedList<Integer>[] vertices;
    static boolean[] visited;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        String[] firstLine = br.readLine().split(" ");

        N = parseInt(firstLine[0]);
        M = parseInt(firstLine[1]);
        vertices = new LinkedList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++)
            vertices[i] = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");

            int u = parseInt(input[0]);
            int v = parseInt(input[1]);

            vertices[u].add(v);
            vertices[v].add(u);
        }

        result.append(0);
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            abcde(0, i);
            visited[i] = false;

            if (found) break;
        }
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void abcde(int sum, int lastIndex) {
        if (sum == 4) {
            result.deleteCharAt(0).append(1);
            found = true;
            return;
        }

        if (vertices[lastIndex].isEmpty())
            return;

        else {
            Iterator<Integer> iterator = vertices[lastIndex].iterator();

            while (iterator.hasNext()) {
                int adj = iterator.next();
                if (!visited[adj]) {
                    visited[adj] = true;
                    abcde(sum + 1, adj);
                    visited[adj] = false;
                }
            }
        }
    }
}