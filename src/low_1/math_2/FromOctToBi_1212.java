package low_1.math_2;

import java.io.*;

public class FromOctToBi_1212 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String octal = br.readLine();
        for (int i = 0; i < octal.length(); i++) {
            int num = octal.charAt(i) - '0';
            for (int j = 0; j < 3; j++) {
                result.insert(i * 3, num % 2);
                num /= 2;
            }
        }
        while (true) {
            if (result.length() > 1 && result.charAt(0) == '0')
                result.deleteCharAt(0);
            else break;
        }
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}

//            StringBuilder tmp = new StringBuilder();
//                tmp.insert(0, num % 2);