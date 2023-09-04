package low_1.dynamicProgramming_2;

import java.io.*;

import static java.lang.Math.*;

public class Sticker_9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] input = new int[2][n + 1];
            int[][] matrix = new int[n + 1][3];
            int max = 0;

            for (int j = 0; j < 2; j++) {
                String[] line = br.readLine().split(" ");
                for (int k = 1; k <= n; k++)
                    input[j][k] = Integer.parseInt(line[k - 1]);
            }

            matrix[1][1] = input[0][1];
            matrix[1][2] = input[1][1];

            for (int j = 2; j <= n; j++) {
                matrix[j][0] = max(matrix[j - 1][1], matrix[j - 1][2]);
                matrix[j][1] = max(matrix[j - 1][0], matrix[j - 1][2]) + input[0][j];
                matrix[j][2] = max(matrix[j - 1][0], matrix[j - 1][1]) + input[1][j];
            }

            for (int j : matrix[n])
                if (max < j) max = j;

            result.append(max).append("\n");
        }


        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
