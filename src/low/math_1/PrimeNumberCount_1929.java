package low.math_1;

/*
2023년 8월 23일 수요일
(1)
    PrimeNumberCheck_1928에서 했던 내용을 거의 그대로 쓴다.
    다만, 해당 수가 소수인지 체크하는 게 아니고 주어진 범위 내의 소수를 출력해야 한다.

(2)
 */

import java.io.*;
import java.util.Arrays;

public class PrimeNumberCount_1929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        boolean[] flag = new boolean[y];

        flag[0] = true;                                         // 1은 소수가 아니다.
        for (int i = 2; i <= Math.sqrt(y); i++) {
            for (int j = i * 2; j <= y; j += i)                 // j 초기값이 i * 2인 이유는, 2나 3 같은 자기 자신은 소수일 수 있기 때문에
                if (!flag[j - 1])
                    flag[j - 1] = true;                         // 소수가 아니면 true다.
        }

        int count = 0;
        for (int i = x - 1; i < y; i++) {
            if (!flag[i]) result.append(i + 1).append("\n");    // flag 값이 false이면 소수 개수에 추가해준다.
        }
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
