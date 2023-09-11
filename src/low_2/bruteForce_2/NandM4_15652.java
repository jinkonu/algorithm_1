package low_2.bruteForce_2;

import java.io.*;

public class NandM4_15652 {
    static StringBuilder result;
    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        arr = new int[M];

        for (int i = 1; i <= N; i++) {
            arr[0] = i;
            recursive(1, i);
        }

        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void recursive(int index, int lastNum) {
        if (index == M) {
            for (int i = 0; i < M; i++)
                result.append(arr[i]).append(" ");
            result.append("\n");
        }

        else {
            for (int i = lastNum; i <= N; i++) {
                arr[index] = i;
                recursive(index + 1, i);
            }
        }
    }
}
