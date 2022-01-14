package Algorithm;

import java.util.Arrays;

public class segmenttree_array {
    static int N = 12;
    static int[] arr = {1, 2, 3, 4, 5, 6, 7 ,8, 9, 10, 11, 12};
    static int[] tree;
    public static void main(String[] args) {
        tree = new int[N * 4];

        System.out.println(segment_sum(arr, 1, 0, N-1)); // 구간합 가능

        System.out.println("tree : "+Arrays.toString(tree));
        //System.out.println(queryRec(3, N-2, 1, 0, N-1));
        System.out.println(updateRec(3, 6, 1, 0, N-1));
        System.out.println(queryRec(3, N-2, 1, 0, N-1));
        //System.out.println("bf : "+Arrays.toString(arr));
        //System.out.println(segment_rep());
        //System.out.println("af : "+Arrays.toString(arr));
        //
    }

    private static int updateRec(int index, int newValue, int node, int nodeLeft, int nodeRight){
        if(index < nodeLeft || nodeRight < index) return tree[node];

        if(nodeLeft == nodeRight) return tree[node] = newValue;

        int mid = nodeLeft + (nodeRight - nodeLeft)/2;
        int leftVal = updateRec(index, newValue, node * 2, nodeLeft, mid);
        int rightVal = updateRec(index, newValue, node * 2 + 1, mid+1, nodeRight);

        return tree[node] = merge(leftVal, rightVal);
    }

    private static int queryRec(int left, int right, int node, int nodeLeft, int nodeRight){

        if(right < nodeLeft || nodeRight < left) return 0; // 범위가 넘어갔을 때,  sum이면 0을 리턴 min이면 MaxValue, max면 MinValue

        if(left <= nodeLeft && nodeRight <= right) return tree[node];

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;

        return merge(queryRec(left, right, node * 2, nodeLeft, mid), queryRec(left, right, node * 2 + 1, mid + 1, nodeRight));

    }

    private static int segment_sum(int[] arr, int node, int nodeLeft, int nodeRight) {
        if(nodeLeft == nodeRight) return tree[node] = arr[nodeLeft];

        int mid = nodeLeft + (nodeRight - nodeLeft)/2;
        int leftVal = segment_sum(arr, node * 2, nodeLeft, mid);
        int rightVal = segment_sum(arr, node * 2 + 1, mid+1, nodeRight);

        return tree[node] = merge(leftVal, rightVal);

    }

    private static int merge(int left, int right){
        return left + right;
    }

}
