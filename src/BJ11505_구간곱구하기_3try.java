import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11505_구간곱구하기_3try {
    static long[] tree;
    public static void main(String[] args) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());

        long[] arr = new long[N+1];
        tree = new long[N*4];

        for(int n = 1; n <= N; n++){
            arr[n] = Long.parseLong(br.readLine());
        }

        buildArr(arr, 1, 0, N);

        System.out.println(Arrays.toString(tree));
        StringBuilder sb = new StringBuilder();
        for(int nk = 0; nk < M+K; nk++){
            tk = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());

            if(a == 1) {
                long c = Long.parseLong(tk.nextToken());
                //updateArr(b, c, 1, 0, N);
            }
            else if(a == 2) {
                int c = Integer.parseInt(tk.nextToken());
                //sb.append(sumArr(b, c, 1, 0, N)/1000000007).append("\n");
            }
        }

        System.out.println(sb);
        //bw.write(sb.toString());
        //bw.flush();
        //bw.close();
        //br.close();

    }

    private static long buildArr(long[] arr, int node, int nodeLeft, int nodeRight){
        if(nodeLeft == nodeRight) return tree[node] = arr[nodeLeft];

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        long leftVal = buildArr(arr, node * 2, nodeLeft, mid);
        long rightVal = buildArr(arr, node * 2 + 1, mid + 1, nodeRight);

        return tree[node] = merge(leftVal, rightVal);
    }

    private static long merge(long left, long right) {return left * right;}

}
