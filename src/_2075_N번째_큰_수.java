import java.io.*;
import java.util.PriorityQueue;

public class _2075_N번째_큰_수 {

    private static int n;
    private static int[][] matrix;
    private static PriorityQueue<Integer> numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // [n][c]에 있는 값이 최고 값으로 채택되면, 그 위치에 [n][c-1]을 넣으면 될 것 같다.
        n = Integer.parseInt(reader.readLine());
        matrix = new int[n][n];
        numbers = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(inputs[j]);
                matrix[i][j] = number;

                if (numbers.size() < n) {
                    numbers.add(number);
                }
                else if (number > numbers.peek()){
                    numbers.poll();
                    numbers.add(number);
                }
            }
        }

        result.append(numbers.peek());
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
