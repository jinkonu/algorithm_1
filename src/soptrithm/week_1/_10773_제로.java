package soptrithm.week_1;

/*
* 스택을 사용한다.
* 읽은 수가 0이면 pop()
* 0이 아니면 push()
* 마지막에 합산
* */

import java.io.*;
import java.util.Stack;

public class _10773_제로 {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(reader.readLine());
        Stack<Long> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            long number = Long.parseLong(reader.readLine());

            if (number == 0 && !stack.isEmpty())
                stack.pop();
            else
                stack.push(number);
        }

        long total = stack.stream()
                .mapToLong(Long::longValue)
                .sum();

        result.append(total);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
