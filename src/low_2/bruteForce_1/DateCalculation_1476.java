package low_2.bruteForce_1;

/*
2023년 9월 5일 화요일
(1)
    brute force 문제이다.
    E, S, M을 받아놓고 e, s, m이 움직여서 맞춰질 때까지 반복문을 돌리면서 year를 늘려간다.
 */

import java.io.*;

public class DateCalculation_1476 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] line = br.readLine().split(" ");
        int E = Integer.parseInt(line[0]);
        int S = Integer.parseInt(line[1]);
        int M = Integer.parseInt(line[2]);
        int year = 1;

        int e = 1;
        int s = 1;
        int m = 1;

        while (true) {
            if (e == E && s == S && m == M) break;

            ++year;
            if (++e == 16) e = 1;
            if (++s == 29) s = 1;
            if (++m == 20) m = 1;
        }

        result.append(year);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
