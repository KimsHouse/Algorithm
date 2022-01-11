import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ12015_가장긴증가하는부분수열2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        tk = new StringTokenizer(br.readLine(), " ");
        for(int n = 0; n < N; n++){
            arr[n] = Integer.parseInt(tk.nextToken());
        }

        LIS(arr, N);

        //System.out.println(Arrays.toString(arr));
    }
    private static void LIS(int[] arr, int N){
        int[] list = new int[N];
        //Arrays.fill(list, Integer.MIN_VALUE);
        int LIS = 0;

        for (int i = 0; i < N; i++) {
            int idx;
            //if(arr[i] > 0)
                idx = Binary(arr[i], 0, LIS, LIS + 1, list);
            //else idx = Binary_min(arr[i], 0, LIS, LIS + 1, list);
            //System.out.println("idx : "+idx);
            //System.out.println();
            if(idx == -1) list[LIS++] = arr[i];
            else list[idx] = arr[i];
        }

        //System.out.println(Arrays.toString(list));
        //System.out.println(Arrays.toString(arr));
        System.out.println(LIS);

    }


    private static int Binary(int target, int start, int end, int size, int[] list) {
        int res = 0;
        int mid;
//        System.out.println("start : "+start);
//
//        System.out.println("end : "+end);
//        System.out.println("size : "+size);
        while(start <= end){
            mid = (start + end) / 2;

//            System.out.println("mid : "+mid);
//            System.out.println("lm : "+list[mid]);
            if(target <= list[mid]){
                res = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }
        //System.out.println();

        if(start == size) return -1;
        else return res;
    }
}
