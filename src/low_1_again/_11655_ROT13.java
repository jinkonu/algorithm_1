package low_1_again;

/*
* Map<char, char> lower = 키와 값 -> 65 ~ 90
  Map<char, char> upper = 키와 값 -> 97 ~ 122
  각 키에 대한 값으로 채운다.
  중간값보다 작을 경우 +, 중간값보다 클 경우 -
  *
  * 핵심은, 복호화 카드를 만들어두고 쓴다는 것!
* */

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class _11655_ROT13 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START

        Map<Character, Character> rot13 = new HashMap<>();
        double upperMidValue = (65 + 90) / 2.0;
        double lowerMidValue = (97 + 122) / 2.0;

        for (int i = 65; i <= 90; i++) {
            if (i < upperMidValue)
                rot13.put((char) i, (char) (i + 13));

            else
                rot13.put((char) i, (char) (i - 13));
        }

        for (int i = 97; i <= 122; i++) {
            if (i < lowerMidValue)
                rot13.put((char) i, (char) (i + 13));

            else
                rot13.put((char) i, (char) (i - 13));
        }

        char[] input = reader.readLine().toCharArray();
        for (char c : input) {
            if ((65 <= c && c <= 90) || (97 <= c && c <= 122))
                result.append(rot13.get(c));

            else
                result.append(c);
        }

        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
