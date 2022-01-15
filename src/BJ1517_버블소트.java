import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1517_버블소트 {
    static int[] treemax, treemin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        treemax = new int[N * 4];
        treemin = new int[N * 4];

        tk = new StringTokenizer(br.readLine(), " ");

        for(int n = 1; n <= N; n++){
            arr[n] = Integer.parseInt(tk.nextToken());
        }

        buildArr_max(arr, 1, 0, N);
        buildArr_min(arr, 1, 0, N);

        System.out.println(Arrays.toString(treemax));
        System.out.println(Arrays.toString(treemin));

        //System.out.println(Arrays.toString(arr));

    }

    private static int buildArr_max(int[] arr, int node, int nodeLeft, int nodeRight) {
        if(nodeLeft == nodeRight) return treemax[node] = arr[nodeLeft];

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        int leftVal = buildArr_max(arr, node * 2, nodeLeft, mid);
        int rightVal = buildArr_max(arr, node * 2 + 1, mid + 1, nodeRight);

        return treemax[node] = Math.max(leftVal, rightVal);

    }

    private static int buildArr_min(int[] arr, int node, int nodeLeft, int nodeRight) {
        if(nodeLeft == nodeRight) return treemin[node] = arr[nodeLeft];

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        int leftVal = buildArr_min(arr, node * 2, nodeLeft, mid);
        int rightVal = buildArr_min(arr, node * 2 + 1, mid + 1, nodeRight);

        return treemin[node] = Math.min(leftVal, rightVal);

    }
}
