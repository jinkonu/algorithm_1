package low.math_1;

/*
2023년 8월 23일 수요일
(1)
    팩토리얼을 구하는 알고리즘이다.
    값을 담는 변수의 초기값을 1로 하고, input이 0이나 1일 경우 반복문을 거치지 않도록 했다.
 */

import java.io.*;
import java.math.BigInteger;

public class Factorial_10872 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int input = Integer.parseInt(br.readLine());
        long output = 1;

        for (int i = 2; i <= input; i++)
            output *= i;

        result.append(output);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
