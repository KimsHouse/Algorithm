import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1517_버블소트_ans {
    static int N;
    static long count;
    static long[] arr, copy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        copy = new long[N];

        tk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(tk.nextToken());
        }

        binary(0, N-1);
        System.out.println(count);
    }

    private static void binary(int start, int end) {
        if(start != end){
            int mid = (start + end) / 2;
            binary(start, mid);
            binary(mid+1, end);
            merge(start, end);
        }
    }

    private static void merge(int start, int end){
        int mid = (start + end) / 2;
        int left1 = start;
        int cen = mid + 1;
        int left2 = start;

        while(left1 <= mid && cen <= end){
            if(arr[left1] > arr[cen]){
                copy[left2++] = arr[cen++];
                count += mid - left1 + 1;
            } else copy[left2++] = arr[left1++];
        }

        if(left1 > mid){
            while(cen <= end){
                copy[left2++] = arr[cen++];
            }
        } else {
            while(left1 <= mid){
                copy[left2++] = arr[left1++];
            }
        }

        for (int i = start; i <= end; i++) {
            arr[i] = copy[i];
        }
    }
}