package low_1_again;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2751_수_정렬하기_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        List<Integer> numbers = new ArrayList<>();
        int N = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++)
            numbers.add(Integer.parseInt(reader.readLine()));

        numbers.sort(Integer::compareTo);

        for (Integer n : numbers)
            result.append(n).append("\n");
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void quickSort(List<Integer> numbers, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(numbers, start, end);

            quickSort(numbers, start, pivotIndex - 1);
            quickSort(numbers, pivotIndex, end);
        }
    }

    private static int partition(List<Integer> numbers, int start, int end) {
        int pivot = numbers.get(end);
        int pivotIndex = start - 1;

        for (int j = start; j < end; j++) {
            if (numbers.get(j) <= pivot) {
                ++pivotIndex;
                Collections.swap(numbers, pivotIndex, j);
            }
        }

        ++pivotIndex;
        Collections.swap(numbers, pivotIndex, end);
        return pivotIndex;
    }
}
