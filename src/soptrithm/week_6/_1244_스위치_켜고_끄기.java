package soptrithm.week_6;

import java.io.*;

public class _1244_스위치_켜고_끄기 {

    static int n;
    static boolean[] switches;

    static int numberOfStudents;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * 더 빠른 알고리즘이 있을 것 같지는 않다.
        * 일단 해봐야 알 것 같다.
        * */
        n = Integer.parseInt(reader.readLine());
        switches = new boolean[n + 1];

        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            switches[i + 1] = input[i].equals("1");
        }

        numberOfStudents = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfStudents; i++) {
            input = reader.readLine().split(" ");
            int number = Integer.parseInt(input[1]);

            Student student = new Student(input[0].equals("1"), number);
            operate(student);
        }

        print(result);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void print(StringBuilder result) {
        for (int i = 1; i <= n; i++) {
            if (switches[i])
                result.append("1").append(" ");
            else
                result.append("0").append(" ");

            if (i % 20 == 0)
                result.append("\n");
        }
    }

    private static void operate(Student student) {
        if (student.isMan)
            manOperate(student.number);

        else
            womanOperate(student.number);
    }

    private static void manOperate(int number) {
        for (int i = number; i <= n; i += number) {
            switches[i] = !switches[i];
        }
    }

    private static void womanOperate(int number) {
        int size = 0;

        while (true) {
            int start = number - size;
            int end = number + size;

            if (start >= 1 && end <= n)
                if (switches[start] == switches[end]) {
                    ++size;
                    continue;
                }

            break;
        }

        size -= 1;
        for (int i = number - size; i <= number + size; i++) {
            switches[i] = !switches[i];
        }
    }
}

class Student {

    boolean isMan;
    int number;

    public Student(boolean isMan, int number) {
        this.isMan = isMan;
        this.number = number;
    }
}