package low.dynamicProgramming_1;

/*
2023년 8월 30일 수요일
(1)
    또다른 dp 문제...
    n개의 수열에 있어서 k개 연속만 뽑아서 최대로 만들어야 한다.
(2)
    i = 0부터 n까지, 매번 addSequence[i] = sequence[i]에다가 j = i + 1부터 n까지 진행시킨다.
    j for loop에서는 addSeqeunce[i]에 sequence[j]를 계속 더한다. 언제까지? sequence[j]가 음수일 때까지.
    addSequence[음수 인덱스]에 sequence[음수 인덱스]를 더해본다.
(3)
    만약 0보다 같거나 작아질 경우, 해당 인덱스는 수열을 형성하는 데 아무런 쓸모가 없으므로 바로 넘겨야 한다.
    만약 0보다 클 경우, 해당 인덱스는 수열을 형성하는 데 필수적이므로 거기서 j for loop를 다시 시작해야 한다.
 */

import java.io.*;

public class SequentialAdd_1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] sequence = new int[N];
        int[] addSequence = new int[N];
        int maxTotal = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++)
            sequence[i] = Integer.parseInt(input[i]);

        for (int i = 0; i < N; i++) {
            addSequence[i] += sequence[i];

            if (addSequence[i] > 0)
                for (int j = i + 1; j < N; j++) {
                    if (sequence[j] < 0) {
                        addSequence[j] = addSequence[i];
                        i = j - 1;
                        break;
                    }

                    else
                        addSequence[i] += sequence[j];
                }
        }

        for (int i : addSequence) {
            if (maxTotal < i) maxTotal = i;
        }

        result.append(maxTotal);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
