import java.io.*;

public class _1157_단어_공부 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // ASCII로 int[] frequency 운용하자
        // 개수는 boolean[length]로 운용해서 if true, than "?"
        // 소문자 97 ~ 122
        // equals를 다룰 때 flag처럼 활용했는데, 최대 빈도가 아닌 빈도를 가진 2개 알파벳이 겹치면 "?"로 결론을 내고 종료되는 문제가 있었다.
        char[] input = reader.readLine().toLowerCase().toCharArray();
        int[] frequencies = new int[26];
        int[] equals = new int[input.length + 1];
        int maxFrequency = 0;
        int maxCharIdx = -1;

        if (input.length == 0) {
            System.out.println("?");
            return;
        }

        for (char c : input) {
            ++frequencies[c - 'a'];
        }

        for (int i = 0; i < frequencies.length; i++) {
            int frequency = frequencies[i];

            if (frequency > 0) {
                ++equals[frequency];

                if (maxFrequency < frequency) {
                    maxFrequency = frequency;
                    maxCharIdx = i;
                }
            }
        }

        if (equals[maxFrequency] > 1) {
            result.append("?");
        }
        else {
            result.append((char) (65 + maxCharIdx));
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
