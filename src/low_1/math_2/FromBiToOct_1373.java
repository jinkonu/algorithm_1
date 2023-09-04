package low_1.math_2;

/*
2023년 8월 26일 토요일
(1)
    문제 자체는 어렵지 않았지만 접근 방법을 다양하게 가져가다 보니 계속 실수가 발생했다.
    2진수 세 자리씩 끊어서 8진수 한 자리로 만드는 방법과,
    10진수로 변환한 이후 다시 8진수로 변환하는 방법 사이에서 계속 갈팡질팡했다.
(2)
    결론은, 2진수 세 자리가 분명히 더 쉬운 방식이었고,
    2진수 자리수가 3에 나눠지도록 앞에 0을 offset으로 채워주는 게 가장 현명한 방식이었다.
 */

import java.io.*;

public class FromBiToOct_1373 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        StringBuilder binary = new StringBuilder(br.readLine());
        int offset = 3 - binary.length() % 3;

        if (offset == 1)
            binary.insert(0, "0");
        if (offset == 2)
            binary.insert(0, "00");

        for (int i = 0; i < binary.length(); i += 3)
            result.append(
                    (binary.charAt(i) - '0') * 4 + (binary.charAt(i + 1) - '0') * 2 + (binary.charAt(i + 2) - '0')
            );
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
