package low_1.math_1;

/*
2023년 8월 23일 수요일
(1)
    최대공약수와 최소공배수를 구해야 한다.
(2)
    반복문을 통해 최대공약수를 구하는 공식은 다음과 같다.
    1> 더 큰 수를 왼쪽에 둔다.
    2> 오른쪽 수가 0이 될 때까지 아래 과정을 반복한다.
    3> 나머지를 구한다.
    4> 왼쪽 수에 오른쪽 수를 대입한다.
    5> 오른쪽 수에 나머지를 대입한다.
(3)
    최소공배수를 구하는 공식은 "두 수의 곱 / 최대공약수"이다.
    따라서 최대공약수만 (2)의 방식으로 구한다면, 최소공배수는 딸려 나온다.
 */

import java.io.*;

public class GcdLcm_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
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
        result.append(gcdX).append(" ");
        result.append((x * y) / gcdX);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
