package low.dataStructure_3;

/*
2023년 8월 21일 월요일
(1)
    원래는 HashMap<Character, Integer>로 출현 빈도를 저장하려고 했으나,
    아예 출현하지 않는 알파벳까지 일일이 key로 등록할 방법이 불편해서 int[]로 수정했다.
    기본형으로 변경한 덕분인지 처리 속도가 되게 빠른 것 같은 느낌.
(2)
    알파벳과 freqList의 인덱스는 아스키 문자 index에서 'a'가 97이라는 점을 활용했다.
*/

import java.io.*;

public class AlphabetNumber_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        char[] input = br.readLine().toCharArray();
        int[] freqList = new int[26];

        for (char c : input) {
            freqList[c - 97]++;
        }

        for (int i : freqList) {
            result.append(i).append(" ");
        }

        // LOGIC FINISH

        bw.write(result.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
