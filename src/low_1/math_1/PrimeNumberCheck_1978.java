package low_1.math_1;

/*
2023년 8월 23일 수요일
(1)
    소수를 구하는 방식은 "에라토스테네스의 체" 방식을 활용한다.
    1> 1은 소수가 아니다.
    2> k = 2부터 k = N^(1/2)까지, k * 2부터 N까지 소수에서 제한다.
    3> 2>의 과정을 반복하고 남은 것들이 소수다.
(2)
    우리 문제는 수의 범위 내에서 소수의 개수를 찾는 것이 아니다.
    주어진 수가 소수인지 아닌지 확인해아 한다.
    이 과정에서, input 중 최댓값을 범위로 잡고 소수를 전부 구해서 소수인지 대조하는 방식을 택했다.
(3)
    소수를 전부 구하는 과정 중에서 input이 소수에서 제외되는지 확인하면 좀 더 빠르게 빠져나올 수도 있을 것이다.
 */

import java.io.*;
import java.util.Arrays;

public class PrimeNumberCheck_1978 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int inputSize = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] numArr = new int[inputSize];
        for (int i = 0; i < inputSize; i++)
            numArr[i] = Integer.parseInt(input[i]);

        Arrays.sort(numArr);
        int biggest = numArr[inputSize - 1];
        boolean[] flag = new boolean[biggest];

        flag[0] = true;                                 // 1은 소수가 아니다.
        for (int i = 2; i <= Math.sqrt(biggest); i++) {
            for (int j = i * 2; j <= biggest; j += i)   // j 초기값이 i * 2인 이유는, 2나 3 같은 자기 자신은 소수일 수 있기 때문에
                if (!flag[j - 1])
                    flag[j - 1] = true;                 // 소수가 아니면 true다.
        }

        int count = 0;
        for (int i = 0; i < inputSize; i++) {
            if (!flag[numArr[i] - 1]) count++;          // flag 값이 false이면 소수 개수에 추가해준다.
        }

        result.append(count);

        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
