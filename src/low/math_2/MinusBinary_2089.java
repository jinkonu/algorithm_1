package low.math_2;

import java.io.*;

/*
2023년 8월 26일 토요일
(1)
    여러모로 너무 힘들었다.
    결국에는 chatGPT의 도움으로, 내 코드를 간략히 해달라고 했더니 정답을 내놓아줬다.
    이전의 코드가 왜 틀린지는 아직도 알 길이 없다...
(2)
    나눠서 나머지를 구하는 방식은 10진수를 2진수로 바꿀 때 원래 쓰는 방식이다.
    그런데 나머지가 -1일 때 어떻게 해야할 지 모르고 있었다.
    1로 바꾸고 몫을 하나 늘려주면 커버된다.
 */

public class MinusBinary_2089 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        long input = Long.parseLong(br.readLine());

        if (input == 0) {
            result.append(0);
        } else {
            while (input != 0) {
                long remainder = input % -2;
                input /= -2;

                if (remainder < 0) {
                    remainder += 2;
                    input += 1;
                }
                result.insert(0, remainder);
            }
        }
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}

