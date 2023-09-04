package low_1.math_1;

/*
2023년 8월 23일 수요일
(1)
    같은 패키지의 GcdLcm_2609에서 이미 수행했던 부분이다.
    그래서 혹시 최소공배수만 구하는 경우에는 좀 더 효율적인 알고리즘이 있을까 생각해봤지만,
    막상 돌려보니까 그렇지는 않은 것 같다. 그래서 그냥 그대로 참고했다.
 */

import java.io.*;

public class Lcm_1934 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int inputSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputSize; i++) {
            String[] input = br.readLine().split(" ");
            Integer x = Integer.parseInt(input[0]);
            Integer y = Integer.parseInt(input[1]);

            int gcdX = x;
            int gcdY = y;
            if (x < y) {
                int tmp = gcdX;
                gcdX = gcdY;
                gcdY = tmp;
            }

            while (gcdY != 0) {
                int remainder = gcdX % gcdY;
                gcdX = gcdY;
                gcdY = remainder;
            }
            result.append((x * y) / gcdX).append("\n");
        }
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
