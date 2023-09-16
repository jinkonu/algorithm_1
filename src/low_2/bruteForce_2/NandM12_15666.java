package low_2.bruteForce_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.parseInt;

public class NandM12_15666 {
    static StringBuilder result;
    static int N;
    static int M;
    static List<Integer> sequence = new ArrayList<>();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");

        N = parseInt(line1[0]);
        M = parseInt(line1[1]);

        for (int i = 0; i < N; i++)
            if (!sequence.contains(parseInt(line2[i])))
                sequence.add(parseInt(line2[i]));

        sequence.sort(Comparator.naturalOrder());

        arr = new int[M];
        recursive(0);
        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void recursive(int index) {
        if (index == M) {
            for (int i = 0; i < M; i++)
                result.append(arr[i]).append(" ");
            result.append("\n");
        }

        else {
            for (Integer i : sequence) {
                if (index == 0 || arr[index - 1] <= i) {
                    arr[index] = i;
                    recursive(index + 1);
                }
            }
        }
    }
}
