package low.dataStructure_3;

/*
2023년 8월 21일 월요일
(1)
    이 문제의 포인트는 암호화에 대한 힌트를 input과 output만 제공하는 데에 있다.
    그래서 이를 파악하고, 이 패키지의 여타 문제들처럼 아스키 코드 index 값을 활용해서 처리했다.
 */

import java.io.*;

public class ROT13_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        char[] input = br.readLine().toCharArray();
        int index;
        for (char c : input) {
            if ((int)c == 32) {             // blank space
                result.append(" ");
                continue;
            }

            if (Character.isDigit(c)) {     // number
                result.append(c);
                continue;
            }

            if (Character.isLowerCase(c))   // lower case
                index = c - 97;

            else                            // upper case
                index = c - 65;

            if (index < 13)
                result.append((char)(c + 13));
            else
                result.append((char)(c - 13));
        }
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
