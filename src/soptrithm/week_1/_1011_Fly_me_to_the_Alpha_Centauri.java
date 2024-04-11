package soptrithm.week_1;

// 9 -> 1 2 3 2 1 -> 최댓값 3 -> 3 * 2 - 1
// 10 -> 1 2 3 2 1 1 -> 최댓값 3 -> 3 * 2
// 11 -> 1 2 3 2 2 1 -> 최댓값 3 -> 3 * 2
// 12 -> 1 2 3 3 2 1 -> 최댓값 3 -> 3 * 2
// 13 -> 1 2 3 3 2 1 1 -> 최댓값 3 -> 3 * 2 + 1
// 14 -> 1 2 3 3 2 2 1 -> 최댓값 3 -> 3 * 2 + 1
// 15 -> 1 2 3 3 3 2 1 -> 최댓값 3 -> 3 * 2 + 1
// 16 -> 1 2 3 4 3 2 1 ->  최댓값 4 -> 4 * 2 - 1

import java.io.*;

public class _1011_Fly_me_to_the_Alpha_Centauri {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START

        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) {
            String[] line = reader.readLine().split(" ");
            int distance = Integer.parseInt(line[1]) - Integer.parseInt(line[0]);

            int max = (int) Math.sqrt(distance);

            if (distance == max * max)
                result.append(max * 2 - 1).append("\n");
            else if (distance <= max * max + max)
                result.append(max * 2).append("\n");
            else
                result.append(max * 2 + 1).append("\n");
        }

        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
