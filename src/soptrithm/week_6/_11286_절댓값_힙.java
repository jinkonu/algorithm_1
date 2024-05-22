package soptrithm.week_6;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

import static java.lang.Math.abs;

public class _11286_절댓값_힙 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * 자동 정렬이 이뤄지는 PriorityQueue를 활용하자.
        * 양수와 음수를 각각 다른 자료 구조에서 운용하자.
        * */
        PriorityQueue<Long> positive = new PriorityQueue<>();
        PriorityQueue<Long> negative = new PriorityQueue<>(Comparator.comparingLong(Long::longValue).reversed());

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(reader.readLine());

            if (x != 0) {
                if (x > 0) positive.add(x);
                else negative.add(x);
            }

            else {
                if (positive.isEmpty() && negative.isEmpty())
                    result.append(0).append("\n");

                else if (positive.isEmpty())
                    result.append(negative.poll()).append("\n");

                else if (negative.isEmpty())
                    result.append(positive.poll()).append("\n");

                else {
                    long pMin = positive.peek();
                    long nMin = negative.element();

                    if (abs(pMin) < abs(nMin)) {
                        result.append(pMin).append("\n");
                        positive.poll();
                    }
                    else if (abs(nMin) < abs(pMin)) {
                        result.append(nMin).append("\n");
                        negative.poll();
                    }
                    else {
                        result.append(nMin).append("\n");
                        negative.poll();
                    }
                }
            }
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
