package low.dataStructure_3;

/*
2023년 8월 21일 월요일
(1)
    문제가 쉬워서 빠르게 하는 게 포인트인 것 같았다.
    그래서 Iterator를 쓰면 빠르지 않을까 해서 해보려고 했지만,
    char[]을 List<Character>로 바꾸는 데 실패했다.
 */

import java.io.*;

public class WordLengthCheck_2743 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        char[] input = br.readLine().toCharArray();
        result.append(input.length);

        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
