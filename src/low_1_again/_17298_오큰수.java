package low_1_again;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
*   스택을 하나 두고,
*   스택이 비어 있거나 top에 있는 수가 현재 인덱스의 수보다 클 경우 push한다.
*   top에 있는 수가 현재 인덱스의 수보다 작을 경우 그 조건을 위반할 때까지 pop한다.
*
* */

public class _17298_오큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(reader.readLine());
        List<Integer> sequence = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Stack<Integer> indexStack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        int index = 0;
        int[] output = new int[N];

        while (index != N) {
            if (indexStack.isEmpty() || valueStack.peek() >= sequence.get(index)) {
                indexStack.push(index);
                valueStack.push(sequence.get(index));

                ++index;
                continue;
            }

            while (!indexStack.isEmpty() && valueStack.peek() < sequence.get(index)) {
                valueStack.pop();
                int i = indexStack.pop();
                output[i] = sequence.get(index);
            }
        }

        while (!indexStack.isEmpty() && !valueStack.isEmpty()) {
            valueStack.pop();
            int i = indexStack.pop();

            output[i] = -1;
        }

        for (int x : output) {
            result.append(x).append(" ");
        }
        result.append("\n");
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
