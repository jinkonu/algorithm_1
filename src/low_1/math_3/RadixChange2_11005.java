package low_1.math_3;

/*
2023년 8월 26일 토요일
(1)
    10진법 -> N진법 변환은 유클리드 호제법으로 처리가 가능하다.
    다만, StringBuilder의 append()를 썼다가 순서가 뒤바뀌는 바람에 한 번 틀렸다.
    append()는 뒤에서 글자를 더해주는데,
    유클리드 호제법의 나머지 값은 반대로 결과가 나오는 순서에 뒤집어서 출력해줘야 한다.
 */

import java.io.*;

public class RadixChange2_11005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] line = br.readLine().split(" ");
        long N = Long.parseLong(line[0]);
        int S = Integer.parseInt(line[1]);
        String number = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        while (N != 0) {
            int remainder = (int) N % S;
            N /= S;

            result.insert(0, number.charAt(remainder));
        }


        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
