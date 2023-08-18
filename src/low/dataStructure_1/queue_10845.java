package low.dataStructure_1;

/*
2023년 8월 18일 금요일
(1)
    pop(), back(), front()에 대해, 큐에 값이 없을 경우를 처리하지 않아서 틀렸었다.
    ***문제 조건을 잘 읽고 풀어보자***
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class queue_10845 {
    static List<Integer> queue = new ArrayList<>();
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cmdNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < cmdNum; i++) {
            String cmd = br.readLine();

            if (cmd.contains(" ") && cmd.substring(0, 4).equals("push"))
                push(Integer.parseInt(cmd.split(" ")[1]));

            switch (cmd) {
                case "pop" -> pop();
                case "size" -> size();
                case "empty" -> empty();
                case "front" -> front();
                case "back" -> back();
            }
        }

        bw.write(result.toString());
        bw.flush();
    }

    private static void back() {
        if (queue.isEmpty())
            result.append(-1).append("\n");
        else
            result.append(queue.get(queue.size() - 1)).append("\n");
    }

    private static void front() {
        if (queue.isEmpty())
            result.append(-1).append("\n");
        else
            result.append(queue.get(0)).append("\n");
    }

    private static void empty() {
        if (queue.isEmpty()) result.append(1).append("\n");
        else result.append(0).append("\n");
    }

    private static void size() {
        result.append(queue.size()).append("\n");
    }

    private static void pop() {
         if (queue.isEmpty())
             result.append(-1).append("\n");
         else
             result.append(queue.remove(0)).append("\n");
    }

    private static void push(int num) {
        queue.add(num);
    }
}
