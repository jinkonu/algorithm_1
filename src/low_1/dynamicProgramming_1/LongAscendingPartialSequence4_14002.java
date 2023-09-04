package low_1.dynamicProgramming_1;

/*
2023년 8월 30일 수요일
(1)
    11053번 문제의 또 다른 버전이다.
    11053번에서는 개수만 기억하면 되었지만, 여기서는 수열을 기억해야 한다.
    그래서 Stack<Integer> 타입의 엔트리를 갖는 리스트를 선언해서, 각 인덱스마다 가능한 수열을 push()했다.
(2)
    for loop로 인덱스를 뒤에서 앞으로 훑으면서,
    해당 인덱스 i보다 뒤로 가면서 A[i]보다 크면서 부분수열이 가장 큰 스택을 베껴왔다.
    그리고 베낀 스택에 A[i]만 하나 더 넣어서 해당 인덱스의 스택으로 저장했다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LongAscendingPartialSequence4_14002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] A = new int[N];
        List<Stack<Integer>> list = new ArrayList<>();
        Stack<Integer> maxPointer;

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
            list.add(new Stack<>());
        }

        list.get(N - 1).push(A[N - 1]);
        maxPointer = list.get(N - 1);
        for (int i = N - 2; i >= 0; i--) {
            Stack<Integer> maxTmp = new Stack<>();

            for (int j = i + 1; j < N; j++)
                if (list.get(j).size() > maxTmp.size() && A[j] > A[i])
                    maxTmp = list.get(j);

            list.get(i).addAll(maxTmp);
            list.get(i).push(A[i]);

            if (maxPointer.isEmpty() || list.get(i).size() > maxPointer.size())
                maxPointer = list.get(i);
        }

        for (Integer integer : maxPointer) {
            result.insert(0, " " + integer);
        }
        result.deleteCharAt(0).insert(0, maxPointer.size() + "\n");
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
