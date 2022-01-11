package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LISTEST2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        tk = new StringTokenizer(br.readLine(), " ");
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(tk.nextToken());
        }

        int[] list = new int[N];
        list[0] = arr[0];
        int idx = 1;
        int tmp = 0;

        for (int i = 1; i < N; i++) {
            if(list[idx-1] < arr[i]) list[idx++] = arr[i];
            else if (list[0] > arr[i]) list[0] = arr[i];
            else {
                tmp = Arrays.binarySearch(list, 0, idx, list[i]);
                list[tmp < 0 ? -tmp - 1 : tmp] = arr[i];
            }

        }
        System.out.println(idx);


    }
}
