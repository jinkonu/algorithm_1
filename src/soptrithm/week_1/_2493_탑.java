package soptrithm.week_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // 왼쪽에 있는 수 중 자기보다 큰 가장 가까운 인덱스를 찾아야 한다.
        // 스택 자료구조를 유지한다.
        // 스택이 비어있으면, append(0) -> push(tower)
        // 스택의 탑보다 작은 경우, append(top.index) -> push(tower)
        // 스택의 탑보다 큰 경우, while(!stack.isEmpty() && stack.top().height < tower.height) stack.pop() -> append(top.index) or append(0) -> push(tower)
        Stack<Tower> stack = new Stack<>();

        int N = Integer.parseInt(reader.readLine());
        String[] line = reader.readLine().split(" ");
        List<Tower> towers = new ArrayList<>();

        for (int i = 0; i < N; i++)
            towers.add(new Tower(i, Integer.parseInt(line[i])));

        for (Tower tower : towers) {
            if (stack.isEmpty()) {
                result.append(0).append(" ");
                stack.push(tower);
            }

            else if (stack.peek().height > tower.height) {
                result.append(stack.peek().index + 1).append(" ");
                stack.push(tower);
            }

            else {
                popUntilFindBigger(stack, tower);

                if (stack.isEmpty())
                    result.append(0).append(" ");
                else
                    result.append(stack.peek().index + 1).append(" ");

                stack.push(tower);
            }
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void popUntilFindBigger(Stack<Tower> stack, Tower tower) {
        while (!stack.isEmpty() && stack.peek().height < tower.height)
            stack.pop();
    }
}

class Tower {
    int index;
    int height;

    public Tower(int index, int height) {
        this.index = index;
        this.height = height;
    }
}
