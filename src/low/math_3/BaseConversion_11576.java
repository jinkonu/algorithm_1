package low.math_3;

/*
2023년 8월 26일 토요일
(1)
    A진법에서 B진법으로 바꾸는 문제다.
    간단하게 10진법을 거쳐서 B진법으로 변환했다.
 */

import java.io.*;

public class BaseConversion_11576 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] line = br.readLine().split(" ");
        int A = Integer.parseInt(line[0]);
        int B = Integer.parseInt(line[1]);
        int digit = Integer.parseInt(br.readLine());
        long decimal = 0;

        String[] input = br.readLine().split(" ");
        // A -> 10
        for (int i = 0; i < digit; i++)
            decimal += Math.pow(A, digit - i - 1) * Integer.parseInt(input[i]);

        // 10 -> B
        while (decimal != 0) {
            int remainder = (int) decimal % B;
            decimal /= B;
            result.insert(0, " " + remainder);
        }

        result.deleteCharAt(0);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
