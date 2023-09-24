package low_2.bruteForce_5;

/*
2023년 9월 24일 일요일
(1)
    brute force 문제다.
    bitmask를 활용해야 한다고 해서 했지만, 여전히 성능이 별로다...
 */

import java.io.*;
import java.util.BitSet;

import static java.lang.Integer.*;

public class Set_11723 {
    static StringBuilder result;
    static int M;
    static BitSet bitmask;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        M = parseInt(br.readLine());
        bitmask = new BitSet(20);

        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            String command = line[0];
            int num = 0;
            if (!command.equals("empty") && !command.equals("all"))
                num = parseInt(line[1]);

            operation(command, num);
        }

        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void operation(String command, int num) {
        switch (command) {
            case "add" -> bitmask.set(num - 1);

            case "remove" -> bitmask.clear(num - 1);

            case "check" -> {
                if (bitmask.get(num - 1)) result.append(1).append("\n");
                else result.append(0).append("\n");
            }

            case "toggle" -> {
                bitmask.flip(num - 1);
            }

            case "all" -> {
                bitmask.set(0, 21);
            }

            case "empty" -> {
                bitmask.clear(0, 21);
            }
        }
    }
}