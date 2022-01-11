package Algorithm;

import java.io.IOException;

public class 이분탐색 {
    static int N = 12;
    static int[] arr = {1, 3, 5, 7, 9,11, 14, 15, 18, 19, 25, 28};
    static int data = 7;

    public static void main(String[] args) throws IOException {
        boolean result = binary(arr, 0, N-1, data);
        System.out.println(result);
    }

    private static boolean binary(int[] arr, int start, int end, int target){
        int mid;
        while(start <= end){

            mid = (start + end) / 2;

            if(arr[mid] == target) return true;
            else if(arr[mid] < target){
                start = mid + 1;
            } else if(arr[mid] > target){
                end = mid - 1;
            }
        }
        return false;
    }
}
