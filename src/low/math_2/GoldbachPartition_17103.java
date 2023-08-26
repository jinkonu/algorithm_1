package low.math_2;

/*
2023년 8월 26일 토요일
(1)
    에라토스테네스의 체 원리만 이해한다면 어렵지 않게 풀 수 있다.
    주어진 테스트 케이스의 범위에 맞춰서 소수와 합성수를 boolean[]으로 가려냈다.
(2)
    파티션은 set 개념이기 때문에 순서가 없고,
    그래서 구할 때 1/2 범위까지만 훑었다.
 */

import java.io.*;

public class GoldbachPartition_17103 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        boolean[] prime = new boolean[1_000_001];
        for (int i = 2; i <= Math.sqrt(1_000_000); i++) {
            if (!prime[i])
                for (int j = i * 2; j <= 1_000_000; j += i)
                    prime[j] = true;
        }

        int inputSize = Integer.parseInt(br.readLine());
        for (int i = 0; i < inputSize; i++) {
            int input = Integer.parseInt(br.readLine());
            int count = 0;

            for (int j = 2; j <= input / 2; j++)
                if (!prime[j] && !prime[input - j])
                    ++count;

            result.append(count).append("\n");
        }

        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
