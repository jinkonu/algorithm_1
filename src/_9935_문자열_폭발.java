import java.io.*;

public class _9935_문자열_폭발 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // sliding window 개념으로 접근해야 할 것 같다
        // i부터 시작해서 조건을 충족하지 못하면 i + 1부터 다시
        // 모두 조건을 충족할 경우 length - 1만큼 앞으로 가서 다시 해야한다
        // sliding window가 아닌, stack으로 생각했을 때 문자열을 딱 1번만 훑는다
        /*StringBuilder string = new StringBuilder(reader.readLine());
        String bomb = reader.readLine();

        for (int i = 0; i <= string.length() - bomb.length();) {
            if (string.substring(i, i + bomb.length()).equals(bomb)) {
                string.delete(i, i + bomb.length());
                i = Math.max(0, i - bomb.length() - 1);
            }
            else {
                ++i;
            }
        }

        if (string.isEmpty()) {
            System.out.println("FRULA");
        }
        else {
            System.out.println(string);
        }*/

        String string = reader.readLine();
        String bomb = reader.readLine();

        // 폭발 문자열의 길이와 마지막 문자
        int bombLen = bomb.length();
        char lastBombChar = bomb.charAt(bombLen - 1);

        // 결과를 저장할 스택
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            stack.append(string.charAt(i));

            // 스택의 마지막 문자가 폭발 문자열의 마지막 문자와 일치하는 경우 폭발 문자열 검사
            if (stack.length() >= bombLen && stack.charAt(stack.length() - 1) == lastBombChar) {
                boolean isBomb = true;
                // 폭발 문자열과 일치하는지 확인
                for (int j = 0; j < bombLen; j++) {
                    if (stack.charAt(stack.length() - bombLen + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }
                // 폭발 문자열과 일치하면 스택에서 제거
                if (isBomb) {
                    stack.delete(stack.length() - bombLen, stack.length());
                }
            }
        }

        // 스택이 비어있으면 "FRULA" 출력
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            System.out.println(stack.toString());
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
