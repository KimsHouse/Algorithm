import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11505_구간곱구하기 {
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());

        int[] arr = new int[N+1];
        tree = new int[N*4];

        for(int n = 0; n < N; n++){
            arr[n] = Integer.parseInt(br.readLine());
        }

        for(int m = 0; m < M+M; m++){
            tk = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            int c = Integer.parseInt(tk.nextToken());

            if(a == 1) updateArr(arr, b, c, 1, 0, N);
            else if(a == 2) System.out.println(proArr(arr, b, c, 1, 0, N));
        }
        buildArr(arr, 1, 0, N);
        System.out.println(Arrays.toString(tree));
    }
    private static int proArr(int[] arr, int start, int end, int node, int nodeLeft, int nodeRight){
        if(end < nodeLeft || nodeRight < start) return 1;

        if(start <= nodeLeft && nodeRight <= end) {
            return tree[node];
        }

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        int leftValue = buildArr(arr, node * 2, nodeLeft, mid);
        int rightValue = buildArr(arr, node * 2 + 1, mid + 1, nodeRight);

        return tree[node] = leftValue * rightValue;

    }

    private static int updateArr(int[] arr, int index, int newValue, int node, int nodeLeft, int nodeRight){

        if(index < nodeLeft || nodeRight < index) {
            return tree[node];
        }

        if(nodeLeft == nodeRight) return tree[node] = newValue;

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        int leftValue = buildArr(arr, node * 2, nodeLeft, mid);
        int rightValue = buildArr(arr, node * 2 + 1, mid + 1, nodeRight);

        return tree[node] = leftValue * rightValue;

    }

    private static int buildArr(int[] arr, int node, int nodeLeft, int nodeRight){
        if(nodeLeft == nodeRight) {
            //System.out.println("ba : "+arr[nodeLeft]);
            if(arr[nodeLeft] == 0) return tree[node] = 1;
            else return tree[node] = arr[nodeLeft];
        }

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        int leftValue = buildArr(arr, node * 2, nodeLeft, mid);
        int rightValue = buildArr(arr, node * 2 + 1, mid + 1, nodeRight);

        return tree[node] = leftValue * rightValue;

    }
}
