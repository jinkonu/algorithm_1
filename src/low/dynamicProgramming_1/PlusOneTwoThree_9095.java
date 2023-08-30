package low.dynamicProgramming_1;

import java.io.*;

public class PlusOneTwoThree_9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int inputSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputSize; i++) {
            int caseNum = recursive(Integer.parseInt(br.readLine()));
            result.append(caseNum).append("\n");
        }


        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int recursive(int n) {
        int cases = 0;

        if (n - 1 >= 0) {
            if (n - 1 == 0) ++cases;
            else cases += recursive(n - 1);
        }

        if (n - 2 >= 0) {
            if (n - 2 == 0) ++cases;
            else cases += recursive(n - 2);
        }

        if (n - 3 >= 0) {
            if (n - 3 == 0) ++cases;
            else cases += recursive(n - 3);
        }

        return cases;
    }
}
