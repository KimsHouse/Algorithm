import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2357_최솟값과최댓값 {
    static int[] mintree, maxtree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk;
        StringBuilder sb = new StringBuilder();
        tk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        int[] arr = new int[N+1];
        maxtree = new int[N * 4];
        mintree = new int[N * 4];

        for(int n = 1; n <= N; n++){
            arr[n] = Integer.parseInt(br.readLine());
        }
        //System.out.println(Arrays.toString(arr));
        segment_min(arr, 1, 0, N);
        segment_max(arr, 1, 0, N);

        //System.out.println(Arrays.toString(mintree));
        //System.out.println(Arrays.toString(maxtree));


        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());

//            System.out.println(update_max(1, a, b, 0, N));
//            System.out.println(update_max1(1, a, b, 0, N));

            sb.append(update_min(1, a, b, 0, N)).append(" ").append(update_max(1, a, b, 0, N)).append("\n");
        }

        System.out.println(sb);


    }

    private static int update_max(int node, int start, int end, int nodeLeft, int nodeRight){
        if(end < nodeLeft || nodeRight < start) return Integer.MIN_VALUE; // 한 쪽 끝이 주어진 범위를 넘어가는 경우

        if(start <= nodeLeft && nodeRight <= end) return maxtree[node]; // 양 쪽 끝이 주어진 범위 내에 주어진 경우

        // 범위가 걸치는 경우

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        int leftVal = update_max(node * 2, start, end, nodeLeft, mid);
        int rightVal = update_max(node * 2 + 1, start ,end, mid + 1, nodeRight);

//        System.out.println("l : "+leftVal);
//        System.out.println("r : "+rightVal);

        return Math.max(leftVal, rightVal);
    }

    private static int update_min(int node, int start, int end, int nodeLeft, int nodeRight){
        if(end < nodeLeft || nodeRight < start) return Integer.MAX_VALUE;

        if(start <= nodeLeft && nodeRight <= end) return mintree[node];

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        int leftVal = update_min(node * 2, start, end, nodeLeft, mid);
        int rightVal = update_min(node * 2 + 1, start ,end, mid + 1, nodeRight);

//        System.out.println("l : "+leftVal);
//        System.out.println("r : "+rightVal);

        return Math.min(leftVal, rightVal);
    }

    private static int segment_max(int[] arr, int node, int nodeLeft, int nodeRight){
        if(nodeLeft == nodeRight) return maxtree[node] = arr[nodeLeft];

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        int leftVal = segment_max(arr, node * 2, nodeLeft, mid);
        int rightVal = segment_max(arr, node * 2 + 1, mid + 1, nodeRight);


        return maxtree[node] = Math.max(leftVal, rightVal);
    }

    private static int segment_min(int[] arr, int node, int nodeLeft, int nodeRight){
        if(nodeLeft == nodeRight) return mintree[node] = arr[nodeLeft];

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        int leftVal = segment_min(arr, node * 2, nodeLeft, mid);
        int rightVal = segment_min(arr, node * 2 + 1, mid + 1, nodeRight);


        return mintree[node] = Math.min(leftVal, rightVal);
    }
}
