package low_2.bruteForce_1;

/*
2023년 9월 8일 금요일
(1)
    brute force 문제다.
    그러나 <1, 1>부터 하나씩 늘려가면서 전부 체크하면 시간 초과가 발생한다.
    그래서 최소공배수까지 가면서, x나 y의 작은 놈을 더해주면서 한번에 값을 작은 놈만큼 올라가야 한다.
    그런데 그 과정에서 x가 M인 경우, 혹은 y가 N인 경우 등은 나머지가 0이 나오므로 이를 신경써가면서 코너 케이스를 챙겨야 한다.
 */

import java.io.*;


import static java.lang.Integer.*;

public class KaingCalender_6064 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int T = parseInt(br.readLine());
        int M; int N;
        int x; int y;

        for (int i = 0; i < T; i++) {
            String[] line = br.readLine().split(" ");

            M = parseInt(line[0]);
            N = parseInt(line[1]);
            x = parseInt(line[2]);
            y = parseInt(line[3]);

            int swap;
            int LCM = 1;
            int GCD = 1;
            int count = 0;

            if (M < N) {
                swap = M;
                M = N;
                N = swap;

                swap = x;
                x = y;
                y = swap;
            }

            GCD = gcd(M, N);
            LCM = M * N / GCD;

            if (M == x && N == y) {
                result.append(LCM).append("\n");
                continue;
            }

            if (x < y)
                for (count = x; count < LCM; count += M) {
                    if (x == M && count % M == 0 && count % N == y)
                        break;
                    else if (y == N && count % M == x && count % N == 0)
                        break;
                    else if (count % M == x && count % N == y)
                        break;
                }
            else
                for (count = y; count < LCM; count += N) {
                    if (x == M && count % M == 0 && count % N == y)
                        break;
                    else if (y == N && count % M == x && count % N == 0)
                        break;
                    else if (count % M == x && count % N == y)
                        break;
                }

            if (count >= LCM) result.append(-1).append("\n");
            else result.append(count).append("\n");
        }
        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int gcd(int m, int n) {
        int tmp;

        while (n != 0) {
            tmp = m % n;
            m = n;
            n = tmp;
        }

        return m;
    }
}
