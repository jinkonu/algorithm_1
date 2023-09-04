package low_1.dynamicProgramming_1;

/*
2023년 8월 30일 수요일
(1)
    dp 문제인데, 뒤에서부터 앞으로 답을 찾아나가야 한다고 생각하기가 힘들었다.
    계속 앞에서 뒤로 가는 것만 생각하니까 답이 나오지 않았다.
(2)
    뒤에서 앞으로 가면서, 현재 인덱스에서 뒤로 봤을 때 자기보다 값이 크면서 증가수열을 잘 쌓아놓은 애한테 붙어서 하나 증가해주면 된다.
 */

import java.io.*;

public class LongAscendingPartialSequence_11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] A = new int[N];
        int[] B = new int[N];
        int maxAll = 1;

        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(input[i]);

        B[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            int maxTmp = 0;

            for (int j = i; j < N; j++)
                if (B[j] > maxTmp && A[j] > A[i])
                    maxTmp = B[j];

            B[i] = maxTmp + 1;
            if (B[i] > maxAll) maxAll = B[i];
        }

        result.append(maxAll);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
