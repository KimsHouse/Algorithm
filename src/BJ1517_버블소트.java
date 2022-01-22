import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1517_버블소트 {
    static int count;
    static boolean flag;
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

        System.out.println(Arrays.toString(treemax));
        for(int i = 0; i < N; i++){

//            if(flag) break;
//            flag = true;
            segmentSort(arr[i], 1, 0, N);
        }

        //buildArr_min(arr, 1, 0, N);

        System.out.println(Arrays.toString(treemax));
        //System.out.println(Arrays.toString(treemin));
        System.out.println(count);
        //System.out.println(Arrays.toString(arr));

    }

    private static void segmentSort(int curr, int node, int nodeLeft, int nodeRight){
        if(nodeLeft == nodeRight) return;

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;

        if(curr <= treemax[node * 2]){
            if(curr < treemax[node * 2]) count++;
            treemax[node * 2] = curr;
            return;
        }
        if(curr > treemax[node * 2 + 1]){
            count++;
            treemax[node * 2 + 1] = curr;
            return;
        }

        segmentSort(curr, node * 2, nodeLeft, mid);
        segmentSort(curr, node * 2 + 1, mid + 1, nodeRight);
        //System.out.println("hi");
        //return treemax[node];
    }

//    private static int segmentSort(int node, int nodeLeft, int nodeRight){
//        if(nodeLeft == nodeRight) return treemax[node];
//
//        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
//        int leftVal = segmentSort(node * 2, nodeLeft, mid);
//        int rightVal = segmentSort(node * 2 + 1, mid + 1, nodeRight);
//
//        if(leftVal > rightVal) {
//            treemax[node * 2] = rightVal;
//            treemax[node * 2 + 1] = leftVal;
//            flag = false;
//            count++;
//            //if(treemax[node] < rightVal) count++;
//            return treemax[node] = Math.min(rightVal, treemax[node]);
//        } else {
//            if(treemax[node] > rightVal) count++;
//            //treemax[node * 2 + 1] = treemax[node];
//            return Math.max(treemax[node], rightVal);
//        }
//    }

    private static int buildArr_max(int[] arr, int node, int nodeLeft, int nodeRight) {
        if(nodeLeft == nodeRight) return treemax[node] = arr[nodeLeft];

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        int leftVal = buildArr_max(arr, node * 2, nodeLeft, mid);
        int rightVal = buildArr_max(arr, node * 2 + 1, mid + 1, nodeRight);

        return treemax[node] = Math.max(leftVal, rightVal);

    }

//    private static int buildArr_min(int[] arr, int node, int nodeLeft, int nodeRight) {
//        if(nodeLeft == nodeRight) return treemin[node] = arr[nodeLeft];
//
//        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
//        int leftVal = buildArr_min(arr, node * 2, nodeLeft, mid);
//        int rightVal = buildArr_min(arr, node * 2 + 1, mid + 1, nodeRight);
//
//        return treemin[node] = Math.min(leftVal, rightVal);
//
//    }
}
