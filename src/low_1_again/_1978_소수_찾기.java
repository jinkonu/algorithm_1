package low_1_again;

/*
*   2부터 1000의 제곱근까지 합성수를 구한다. -> boolean[1001]
*   확인해야 할 수 x에 대해 boolean[x] = false면 +1
*
*   참고로, 1은 소수가 아닌데 테스트 케이스에는 들어갈 수 있다.
*   그러니까 코너 케이스를 조심히 생각하자...
* */

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class _1978_소수_찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // 2부터 1000의 제곱근까지 합성수를 구한다. -> boolean[1001]
        // 확인해야 할 수 x에 대해 boolean[x] = false면 +1
        int N = Integer.parseInt(reader.readLine());
        List<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        int max = numbers.get(N - 1);
        int count = 0;
        int startNumber = 2;
        int endNumber = (int) round(sqrt(max));

        boolean[] isComposite = new boolean[max + 1];
        isComposite[1] = true;

        for (int i = startNumber; i <= endNumber; i++) {
            int tmpNum = i * 2;

            while (tmpNum <= max) {
                isComposite[tmpNum] = true;
                tmpNum += i;
            }
        }

        for (Integer x : numbers) {
            if (!isComposite[x])
                ++count;
        }

        result.append(count);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
