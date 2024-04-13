package soptrithm.week_1;

/*
*
* 스택을 이용하는 방식은 맞았다.
* 다만, 자기보다 낮거나 같은 것이 나왔을 때 넓이를 계산하는 방식이 틀렸다.
* i는 현재 자기보다 낮은 것이기 때문에 제외해야 한다.
* stack.peek()도 자신보다 낮기 때문에 제외해야 한다.
* 따라서, 그 사이의 넓이는 i - stack.peek() - 1이 된다.
* */

import java.io.*;
import java.util.Stack;

public class _6549_히스토램에서_가장_큰_직사각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        while (true) {
            String[] line = reader.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            if (n == 0) break;

            int[] numbers = getNumbersfrom(line, n);
            result.append(getBiggestAreaOf(numbers)).append("\n");
        }

        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    static long getBiggestAreaOf(int[] numbers) {
        long max = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            if (stack.isEmpty() || numbers[stack.peek()] < numbers[i])
                stack.push(i);

            else {
                while (numbers[stack.peek()] >= numbers[i]) {
                    int index = stack.pop();
                    int height = numbers[index];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    max = compare(max, numbers[index], width);

                    if (stack.isEmpty()) break;
                }

                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();int height = numbers[index];
            int width = stack.isEmpty() ? numbers.length : numbers.length - stack.peek() - 1;
            max = compare(max, numbers[index], width);
        }

        return max;
    }

    static long compare(long max, int height, int width) {
        long area = (long) height * width;

        return Math.max(max, area);
    }

    static int[] getNumbersfrom(String[] line, int n) {
        int[] numbers = new int[n];

        for (int i = 1; i <= n; i++)
            numbers[i - 1] = Integer.parseInt(line[i]);

        return numbers;
    }
}
