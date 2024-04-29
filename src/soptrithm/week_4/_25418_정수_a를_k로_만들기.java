package soptrithm.week_4;

/*
 * bfs를 활용한다.
 * 현재 수와 수가 되기까지의 연산 횟수를 저장한다.
 * visited 대신에, 연산 횟수가 0인 경우 방문하지 않은 것으로 간주한다.
 * */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class _25418_정수_a를_k로_만들기 {

    static int a;
    static int k;
    static int[] ops;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] input = reader.readLine().split(" ");
        a = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        ops = new int[k + 1];

        dp();
        result.append(ops[k]);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dp() {
        queue.add(a);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == k) {
                ops[k] = ops[current];
                return;
            }

            int mul = current * 2;
            int add = current + 1;

            checkAndAdd(current, mul);
            checkAndAdd(current, add);
        }
    }

    private static void checkAndAdd(int current, int number) {
        if (number <= k && ops[number] == 0) {
            ops[number] = ops[current] + 1;
            queue.add(number);
        }
    }
}
