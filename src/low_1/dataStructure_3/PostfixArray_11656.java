package low_1.dataStructure_3;

/*
2023년 8월 23일 수요일
(1)
    입력 문자열을 쪼개는 방식은 String의 substring()으로 처리했고,
    자료구조는 String[]을 채택했다.
 */

import java.io.*;
import java.util.Arrays;

public class PostfixArray_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String input = br.readLine();
        String[] postfix = new String[input.length()];

        // copy
        for (int i = 0; i < input.length(); i++) {
            postfix[i] = input.substring(i);
        }

        Arrays.sort(postfix);

        for (int i = 0; i < input.length(); i++) {
            result.append(postfix[i]).append("\n");
        }
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
