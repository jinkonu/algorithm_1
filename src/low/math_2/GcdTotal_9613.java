package low.math_2;

/*
2023년 8월 24일 목요일
(1)
    문제 자체는 매우 쉽다.
    여러 문자들 사이에서 조합으로, 즉 nC2로 GCD를 구하기만 하면 된다.
(2)
    문제는 GCD의 합을 구해야 하는데, n의 값이 커지고 엔트리 숫자들도 커지다 보니 GCD를 int형으로 담기에 무리가 있었다.
    그래서 계속 오버플로우 문제가 발생했었는데, 채점 결과는 "틀렸습니다"만 등장해서 원인을 찾는 데 시간이 걸렸다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GcdTotal_9613 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int inputSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputSize; i++) {
            String[] input = br.readLine().split(" ");
            int testSize = Integer.parseInt(input[0]);

            List<Integer> line = new ArrayList<>();
            for (int j = 1; j <= testSize; j++)
                line.add(Integer.parseInt(input[j]));

            result.append(gcd(line)).append("\n");
        }
        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static long gcd(List<Integer> line) {
        long gcd = 0;

        for (int i = 0; i < line.size() - 1; i++) {
            for (int j = i + 1; j < line.size(); j++) {
                int x = line.get(i);
                int y = line.get(j);

                if (x < y) {
                    int tmp = x;
                    x = y;
                    y = tmp;
                }

                while (y != 0) {
                    int remainder = x % y;
                    x = y;
                    y = remainder;
                }
                gcd += x;
            }
        }

        return gcd;
    }
}
