package low_1.math_1;

/*
2023년 8월 23일 수요일
(1)
    주어진 입력값의 범위에 해당하는 소수를 찾는 부분은 PrimeNumberCheck_1978, PrimeNumberCheck_1929를 참고했다.
(2)
    다만, 이 두 문제와 달리 이번에는 해당 index에 대응하는 수가 소수인지 알려주는 boolean[] flag를 1부터 정의했다.
    그러니까 2가 소수인지 확인하기 위해 flag[1]을 보는 것이 아닌 flag[2]를 봐야 하는 식이다.
(3)
    확인할 짝수에 대해 범위 내의 작은 소수(x)부터 하나 잡고,
    그 수(x)를 짝수에서 빼서 남은 수(y)를 다시 인덱스로 활용해 flag[y] = false인지 확인해서 맞으면 바로 루프를 빠져나온다.
    왜냐하면, 문제 조건 상 y - x가 가장 커야 하고, 처음 합을 찾았을 때가 가장 y - x가 크기 때문이다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Goldbach_6588 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        List<Integer> odds = new ArrayList<>();
        int input = Integer.parseInt(br.readLine());
        do {
            odds.add(input);
            input = Integer.parseInt(br.readLine());
        } while (input != 0);

        // FIND MIN & MAX
        int max = odds.get(0);
        int min = odds.get(0);
        for (Integer odd : odds) {
            if (max < odd) max = odd;
            if (odd < min) min = odd;
        }

        // PRIME NUMBER SET
        boolean[] flag = new boolean[max + 1];
        flag[0] = flag[1] = true;                                         // 1은 소수가 아니다.
        for (int i = 2; i <= Math.sqrt(max); i++) {
            for (int j = i * 2; j <= max; j += i)               // j 초기값이 i * 2인 이유는, 2나 3 같은 자기 자신은 소수일 수 있기 때문에
                if (!flag[j])
                    flag[j] = true;                         // 소수가 아니면 true다.
        }


        // GOLDBACH CHECK
        for (Integer odd : odds) {
            for (int i = 2; i < odd; i++) {
                if (!flag[i] && !flag[odd - i]) {
                    result.append(odd).append(" = ").append(i).append(" + ").append(odd - i).append("\n");
                    break;
                }
            }
        }
//        TreeMap<Integer, Integer> primeNumSet = new TreeMap<>();
//        for (int i = 0; i < max; i++)
//            if (!flag[i])
//                primeNumSet.put(i + 1, i + 1);
//
//        // GOLDBACH CHECK
//        for (Integer odd : odds) {
//            for (Integer integer : primeNumSet.keySet()) {
//                if (primeNumSet.containsKey(odd - integer)) {
//                    result.append(odd).append(" = ").append(integer).append(" + ").append(odd - integer).append("\n");
//                    break;
//                }
//            }
//        }

        // LOGIC FINISH
        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}