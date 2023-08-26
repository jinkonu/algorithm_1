package low.math_3;

/*
2023년 8월 26일
(1)
    소인수분해 하는 문제다.
    원래는 테스트 케이스의 가능한 범위에 맞춰서 소수와 합성수를 걸러놨지만,
    그냥 테스트 케이스에 맞춰도 별다른 문제가 없을 것 같아서 수정했다.
(2)
    다른 사람의 코드를 보고 깨달은 것이 있다.
    어차피 2에서 시작하면, 합성수는 소수까지 나오기 전에 이미 다 분해된다는 것...
    그래서 다시 수정했다.
 */

import java.io.*;

public class PrimeFactorization_11653 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int input = Integer.parseInt(br.readLine());

        if (input != 1) {
            int div = 2;
            while (true) {
                if (input % div == 0) {
                    input /= div;
                    result.append(div).append("\n");

                    if (input == 1) break;
                } else ++div;
            }

            result.deleteCharAt(result.length() - 1);
        }

        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
