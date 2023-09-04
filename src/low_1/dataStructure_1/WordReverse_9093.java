package low_1.dataStructure_1;

/* 2023년 8월 17일 목요일
(1)
    Scanner의 next()는 개행 문자("\n")을 받아들이지 않는다.
    그래서 여러 줄을 나눠서 입력받을 때에는 nextLine()이 맞다.
(2)
    nextInt()는 개행 문자("\n")를 가져가지 않는다.
    그래서 이후의 nextLine()에는 개행 문자만 받아들이게 되므로, 주의해야 한다.
(3)
    StringBuilder의 reverse()를 통해 간편하게 문자열 하나를 뒤집어줄 수 있다.
 */

import java.util.Scanner;

public class WordReverse_9093 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCount = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCount; i++) {
            String tmp[] = scanner.nextLine().split(" ");
            for (int j = 0; j < tmp.length; j++) {
                sb.append(new StringBuilder(tmp[j]).reverse()).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
