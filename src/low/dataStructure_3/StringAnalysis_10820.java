package low.dataStructure_3;

/*
2023년 8월 21일 월요일
(1)
    C 수업 때 해봤던 유형인 것 같다.
    소문자, 대문자, 숫자, 공백의 아스키 문자 index를 알아내고 그 범위에 if문을 걸어서 출현 빈도를 구했다.
(2)
    문제는 BufferedReader의 readLine()에 있는데,
    처음에 테스트로 돌렸을 때에는 NullPointerException이 발생했다.
    내 추측으로는 readLine()이 공백 포함해서 전부 받아주기 때문인 것 같다.
    그래서 마지막에는 공백이 들어가는데, 이 공백 input을 for문으로 돌리다가 NullPointerException이 발생한 것 같다.
    그래서 while문에서 null 검사와 isEmpty() 검사를 동시에 했더니 예외가 발생하지 않는다.
 */

import java.io.*;

public class StringAnalysis_10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            char[] input = line.toCharArray();
            int[] freqList = new int[4];

            for (char c : input) {
                // lowercase
                if (97 <= c && c <= 122)
                    freqList[0]++;

                // uppercase
                if (65 <= c && c <= 90)
                    freqList[1]++;

                // number
                if (48 <= c && c <= 57)
                    freqList[2]++;

                // blank space
                if (c == 32)
                    freqList[3]++;
            }

            for (int i : freqList) {
                result.append(i).append(" ");
            }
            result.append("\n");
        }

        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
