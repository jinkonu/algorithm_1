package soptrithm.week_8;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.Collections.reverseOrder;

public class _23757_아이들과_선물_상자 {

    static int n;
    static int m;
    static Queue<Integer> presents = new PriorityQueue<>(reverseOrder());
    static int[] children;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * 우선순위 큐를 두고, 시뮬레이션을 직접 돌려보는 수밖에 없는 것 같다.
        * */
        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        children = new int[m];

        input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            presents.add(Integer.parseInt(input[i]));
        }

        input = reader.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            children[i] = Integer.parseInt(input[i]);
        }

        if (simulation())
            result.append(1);
        else
            result.append(0);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static boolean simulation() {
        for (int child : children) {
            int present = presents.poll();

            if (child > present)
                return false;

            presents.add(present - child);
        }

        return true;
    }
}
