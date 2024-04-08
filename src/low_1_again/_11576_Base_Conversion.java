package low_1_again;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _11576_Base_Conversion {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // A가 B의 2이상 제곱인지 확인한다.
        // 총 m자리에 해당하는 수의 k 자리와 그 자리의 수 x에 대해,
        // x번 반복하여 (k / B) + (k % B)를 반복한다.

        List<Integer> numerals = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int A = numerals.get(0);
        int B = numerals.get(1);
        int m = Integer.parseInt(reader.readLine());

        List<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> resultNumbers = new ArrayList<>();

        int tmpA = A;
        int powNum = 0;
        while (tmpA >= B) {
            tmpA /= B;
            ++powNum;
        }

        int mod = 0;
        for (int i = m - 1; i >= 0; i--) {

        }

        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
