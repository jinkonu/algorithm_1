package low_1_again;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
*   수열의 현재 인덱스에 있는 숫자 = x
*   스택의 top에 있는 숫자 = y
*
*   if (x < y) -> FAIL
*   if (x = y) -> x와 y pop
*   if (x > y) -> y에 push(currentNumber) && ++currentNumber
*/

public class _1784_후위_표기식_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int number = Integer.parseInt(reader.readLine());

        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < number; i++)
            sequence.add(Integer.parseInt(reader.readLine()));

        Stack<Integer> numbers = new Stack<>();
        int currentNumber = 1;

        while (!sequence.isEmpty()) {
            if (!numbers.isEmpty() && sequence.get(0) < numbers.peek()) {
                System.out.println("NO");
                return;
            }

            while (sequence.get(0) >= currentNumber) {
                numbers.push(currentNumber);
                result.append("+").append("\n");

                ++currentNumber;
            }

            sequence.remove(0);
            numbers.pop();
            result.append("-").append("\n");
        }

        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}