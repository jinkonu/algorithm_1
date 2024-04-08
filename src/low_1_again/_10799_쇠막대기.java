package low_1_again;

import java.io.*;

/*
 *   "(" -> push
 *   ")" -> pop && +1
 *   "()" -> +stack.count()
*/

public class _10799_쇠막대기 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // "(" -> push
        // "()" -> +stack.count()
        // ")" -> pop && +1
        char[] input = reader.readLine().toCharArray();
        int stack = 0;
        int index = 0;
        int count = 0;

        while (index != input.length) {
            if (index < input.length - 1 && input[index] == '(' && input[index + 1] == ')') {
                count += stack;

                index += 2;
                continue;
            }

            if (input[index] == '(') {
                ++stack;

                ++index;
                continue;
            }

            if (input[index] == ')') {
                --stack;
                ++count;

                ++index;
                continue;
            }
        }

        result.append(count);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
