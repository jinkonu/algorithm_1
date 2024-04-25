package soptrithm.week_3;

/*
 * 그리디 알고리즘을 적용해야 한다.
 * 빠르게 끝내야 하는 일 먼저 순서대로 정렬한다.
 * 붙여놓고 실패하면 -1을 출력한다.
 * 성공하면, 하나씩 뒤로 미루면서 최대 시작 시간을 구한다.
 * */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _6068_시간_관리하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(reader.readLine());
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = reader.readLine().split(" ");
            tasks.add(new Task(
                    Integer.parseInt(input[1]),
                    Integer.parseInt(input[0])
            ));
        }

        tasks.sort(Task::compareTo);

        int latest = 0;
        while (isValid(tasks, latest))
            ++latest;

        result.append(latest - 1);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static boolean isValid(List<Task> tasks, int latest) {
        for (Task task : tasks) {
            latest += task.size;

            if (latest > task.end)
                return false;
        }

        return true;
    }
}

class Task implements Comparable<Task> {
    int size;
    int end;

    public Task(int end, int size) {
        this.end = end;
        this.size = size;
    }

    @Override
    public int compareTo(Task task) {
        return this.end - task.end;
    }

    @Override
    public String toString() {
        return "Task{" +
                "end=" + end +
                ", size=" + size +
                '}';
    }
}