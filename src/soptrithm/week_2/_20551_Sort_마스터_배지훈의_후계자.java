package soptrithm.week_2;

/*
 * 주어진 배열을 정렬해야 한다.
 * 주어진 배열의 입력을 받으면서 boolean[]을 가지고 없는 수를 빠르게 구분한다.
 * 있는 수에 대해서는 binary search를 구현해서 처음 나온 위치를 찾는다.
 * binary search는 low, mid, high 인덱스를 가지고 실행한다.
 * high < low면 없다는 뜻이니 탐색을 멈춘다.
 * n == arr[mid]라면 mid 인덱스를 반환한다.
 * n > arr[mid]면 mid+1, high를 찾는다.
 * n < arr[mid]면 low, mid-1을 찾는다.
 * */

import java.io.*;
import java.util.Arrays;

public class _20551_Sort_마스터_배지훈의_후계자 {

    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] metaLine = reader.readLine().split(" ");
        int N = Integer.parseInt(metaLine[0]);
        int M = Integer.parseInt(metaLine[1]);
        array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(array);

        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(reader.readLine());
            int searchResult = binary_search(number, 0, array.length - 1);

            result.append(searchResult).append("\n");
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static int binary_search(int number, int low, int high) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (number == array[mid])
            return findFirst(mid);

        if (number < array[mid])
            return binary_search(number, low, mid - 1);

        return binary_search(number, mid + 1, high);
    }

    private static int findFirst(int index) {
        int currentIndex = index;

        while (currentIndex >= 0 && array[currentIndex] == array[index]) {
            currentIndex--;
        }

        return currentIndex + 1;
    }
}
