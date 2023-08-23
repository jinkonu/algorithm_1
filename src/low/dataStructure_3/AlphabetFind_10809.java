package low.dataStructure_3;

/*
2023년 8월 21일 월요일
(1)
    10808번 문제와 크게 다르지 않았다.
    다만, 26 크기의 리스트를 -1로 초기화하고 시작하기 위해서 List<Integer> 타입을 활용했다.
    Collections.nCopies()는 o로 초기화되어 있는 n 크기의 List를 반환한다.
(2)
    Arrays.fill()을 활용할 수 있음을 깨닫고 이를 활용하는 버전도 작성해봤다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AlphabetFind_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        char[] input = br.readLine().toCharArray();
//        List<Integer> find = new ArrayList<>(Collections.nCopies(26, -1));
        int[] findList = new int[26];
        Arrays.fill(findList, -1);

        for (int i = 0; i < input.length; i++) {
            if (findList[input[i] - 97] == -1)
                findList[input[i] - 97] = i;

//            if (find.get(input[i] - 97) == -1)
//                find.set(input[i] - 97, i);
        }

        for (int i : findList) {
            result.append(i).append(" ");
        }
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
