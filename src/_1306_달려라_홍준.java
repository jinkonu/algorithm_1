import java.io.*;

import static java.lang.Math.max;

public class _1306_달려라_홍준 {

    static long[] seg;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // sliding window 문제는 1개를 빼고 1개를 더해가면서 전체 윈도우를 유지하는 게 중요하다.
        // sum += [i + M - 1] - [i - M]
        String[] inputs = reader.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        arr = new long[N];

        inputs = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(inputs[i]);
        }

        seg = new long[N * 4];
        seginit(1, 0, N - 1);

        for (int start = M - 1; start <= N - M; start++) {
            result.append(find(1, 0, N - 1, start - (M - 1), start + (M - 1)) + " ");
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static long find(int node, int s, int e, int left, int right) {
        if(right < s || left > e) return -1;
        else if(left <= s && e <= right) {
            return seg[node];
        }
        else {
            int mid = (s+e)/2;
            return max(find(node*2 ,s, mid,left,right),find(node*2+1, mid+1 , e , left , right));
        }
    }

    private static long seginit(int node, int s, int e) {
        if(s==e) {return seg[node]= arr[s];}
        int mid = (s+e)/2;
        return seg[node] = max(seginit(2*node ,s,mid) , seginit(2*node+1,mid+1, e));
    }
}
