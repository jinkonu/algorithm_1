package low.math_3;

/*
2023년 8월 26일 토요일
(1)
    n진법에서 10진법으로 바꾸는 문제다.
    {n ^ 자릿수 * 각 자릿수의 수}를 계속 더해서 10진법으로 변환했다.
 */

import java.io.*;

public class RadixChange_2745 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] line = br.readLine().split(" ");
        String input = line[0];
        int radix = Integer.parseInt(line[1]);
        long decimal = 0;

        for (int i = 0; i < input.length(); i++) {
            int tmp = 0;
            char c = input.charAt(i);

            if (48 <= c && c <= 57)
                tmp = c - '0';
            else if (65 <= c && c <= 90)
                tmp = c - 'A' + 10;

            decimal += Math.pow(radix, input.length() - i - 1) * tmp;
        }

        result.append(decimal);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
