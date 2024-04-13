package soptrithm.week_1;

// stack 자료를 사용한다.
// stack이 비어 있으면, push(index)
// stack이 비어있지 않고, heights.get(index)가 heights.get(stack.top)보다 크거나 같으면 pop() and +1 and push()
// stack이 비어있지 않고, push()할 수가 top보다 작으면 +1 and push()

// 위의 내 풀이와 달리, 답안에서는 heights 같은 자료를 유지하지 않아도 된다.
// 인덱스를 유지할 필요없이, 그때그때 total += stack.size()로 더해간다.

import java.io.*;
import java.util.*;

public class _6918_옥상_정원_꾸미기 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        long benchmark = 0;
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(reader.readLine());

            while (!stack.isEmpty()) {
                if (stack.peek() <= height)
                    stack.pop();
                else
                    break;
            }

            benchmark += stack.size();
            stack.push(height);
        }

        result.append(benchmark);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}