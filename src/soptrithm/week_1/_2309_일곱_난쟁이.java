package soptrithm.week_1;

/*
* 핵심은 매번 총합을 더해서 100이 되는지 확인하기보다는,
* 반대로 7C2해서 total에서 두 개를 빼고 난 것이 100이 되는지 확인하는게 효율적이라는 것이다.
* 덩으로, 중첩문을 통해 total에서 input[i] 하나를 뺀 상태를 유지하면 연산 중복이 더 줄어든다.
*
* */

import java.io.*;
import java.util.Arrays;

public class _2309_일곱_난쟁이 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START


        int numberOfShort = 9;
        int correctNumber = 100;
        int total = 0;
        int[] input = new int[numberOfShort];

        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(reader.readLine());
            total += input[i];
        }

        Arrays.sort(input);

        for (int i = 0; i < input.length; i++) {
            total -= input[i];

            for (int j = i + 1; j < input.length; j++) {
                if (total - input[j] == correctNumber) {
                    printCorrectShorts(i, j, input);
                    return;
                }
            }

            total += input[i];
        }

        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void printCorrectShorts(int i, int j, int[] shorts) {
        for (int k = 0; k < shorts.length; k++)
            if (k != i && k != j)
                System.out.println(shorts[k]);
    }
}
