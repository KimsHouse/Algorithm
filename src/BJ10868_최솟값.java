import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10868_최솟값 {
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        int arr[] = new int[N+1];
        tree = new int[N * 4];

        //tk = new StringTokenizer(br.readLine(), " ");
        for(int n = 1; n <= N; n++){
            arr[n] = Integer.parseInt(br.readLine());
        }

        buildArr(arr, 1, 0, N);
        StringBuilder sb = new StringBuilder();


        for(int m = 0; m < M; m++){
            tk = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(tk.nextToken());
            int end = Integer.parseInt(tk.nextToken());

            sb.append(findMin(start, end, 1, 0, N)).append("\n");

        }
        System.out.println(sb);

    }

    private static int findMin(int start, int end, int node, int nodeLeft, int nodeRight){
        if(end < nodeLeft || nodeRight < start ) return Integer.MAX_VALUE;

        if(start <= nodeLeft && nodeRight <= end) return tree[node];

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        int leftVal = findMin(start, end, node * 2, nodeLeft, mid);
        int rightVal = findMin(start , end, node * 2 + 1, mid + 1, nodeRight);

        return Math.min(leftVal, rightVal);
    }

    private static int buildArr(int[] arr, int node, int nodeLeft, int nodeRight){
        if(nodeLeft == nodeRight) return tree[node] = arr[nodeLeft];

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        int leftVal = buildArr(arr, node * 2, nodeLeft, mid);
        int rightVal = buildArr(arr, node * 2 + 1, mid + 1, nodeRight);

        return tree[node] = Math.min(leftVal, rightVal);
    }
}
