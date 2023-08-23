package low.dataStructure_1;

/*
2023년 8월 19일 토요일
 */

import java.io.*;
import java.util.LinkedList;

public class Deque_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        LinkedList<Integer> deque = new LinkedList<Integer>();

        int cmdNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < cmdNum; i++) {
            String cmd = br.readLine();

            if (cmd.contains(" ") && cmd.substring(0, 10).equals("push_front")) {
                int num = Integer.parseInt(cmd.split(" ")[1]);
                deque.addFirst(num);
            }

            if (cmd.contains(" ") && cmd.substring(0, 9).equals("push_back")) {
                int num = Integer.parseInt(cmd.split(" ")[1]);
                deque.addLast(num);
            }

            if (cmd.equals("pop_front")) {
                if (deque.isEmpty()) result.append(-1).append("\n");
                else result.append(deque.removeFirst()).append("\n");
            }

            if (cmd.equals("pop_back")) {
                if (deque.isEmpty()) result.append(-1).append("\n");
                else result.append(deque.removeLast()).append("\n");
            }

            switch (cmd) {
                case "size" :
                    result.append(deque.size()).append("\n");
                    break;
                case "empty" :
                    if (deque.isEmpty()) result.append(1).append("\n");
                    else result.append(0).append("\n");
                    break;
                case "front" :
                    if (deque.isEmpty()) result.append(-1).append("\n");
                    else result.append(deque.getFirst()).append("\n");
                    break;
                case "back" :
                    if (deque.isEmpty()) result.append(-1).append("\n");
                    else result.append(deque.getLast()).append("\n");
                    break;
            }
        }

        bw.write(result.toString());
        bw.flush();
    }
}
