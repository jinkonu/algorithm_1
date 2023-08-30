package low.dynamicProgramming_1;

/*
2023년 8월 30일 수요일
(1)
    간단한 dp 문제다.
    1부터 N까지 올라가면서 최소 제곱 합의 수를 형성해가면 된다.
(2)
    그런데 퍼포먼스가 생각보다 너무 안 나와서 다른 코드를 참고했다.
    참고해보니, int[] min을 초기화할 때 굳이 min[i] == 0으로 조건을 걸기보다는 min[i] = i로 시작하면 되었다.
    이 부분만 교체했는데도 퍼포먼스가 급격히 상승했다.
 */

import java.io.*;

import static java.lang.Math.*;

public class PowAdd_1699 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(br.readLine());
        int[] min = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            min[i] = i;
            for (int j = 1; j <= sqrt(i); j++) {
                min[i] = min(min[i], 1 + min[i - j * j]);
            }
        }

        result.append(min[N]);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
