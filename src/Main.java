public class Main {

    public static void main(String[] args) {
        long N = 60466175;
        StringBuilder sb = new StringBuilder();

        while (N != 0) {
            long remainder = N % 36;
            N /= 36;

            sb.append(remainder + " ");
        }

        System.out.println(sb);

        System.out.println((int)'0');
    }
}