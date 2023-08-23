package low.dataStructure_3;

/*
2023년 8월 21일 월요일
(1)
    문제 스펙만 들었을 때에는 굉장히 쉬워 보이는 문제다.
    그러나 A와 B 두 수를 이었을 때의 크기가 int나 long이 담을 수 있는 범위를 넘을 때 문제가 발생한다.
    그래서 처음 제출했을 때는 NumberFormatException이 발생했었다.
(2)
    아무튼 이 문제를 BigInteger를 활용해 해결할 수 있었다.
 */

import java.io.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

public class FourNumber_10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] input = br.readLine().split(" ");
        BigInteger x = BigInteger.valueOf(Long.parseLong(input[0].toString() + input[1].toString()));
        BigInteger y = BigInteger.valueOf(Long.parseLong(input[2].toString() + input[3].toString()));

        result.append(x.add(y));
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
