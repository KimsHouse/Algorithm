import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_A_2022는무엇이특별할까 {
    static int N, D, min = Integer.MAX_VALUE, result;
    static int[] arr, num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(tk.nextToken());
        D= Integer.parseInt(tk.nextToken());

        arr = new int[D];

        num = numeral(N, D);
        permutation(0, new int[D], new boolean[D]);

        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);

        //System.out.println(Arrays.toString(num));
        //System.out.println(Arrays.toString(arr));
    }

    private static void permutation(int cnt, int[] selected, boolean[] visited) {
        if(cnt == D){
            //System.out.println(Arrays.toString(selected));
            int res = demical(selected, D);
            //System.out.println("res : "+res);
            if(res > N && Math.abs(res-N) < min){
                min = Math.abs(res-N);
                result = res;
            }
        }

        for (int i = 0; i < D; i++) {
            if((i == 0 && cnt < num[0]) || (i == 0 && cnt == 0)) continue;
            if(!visited[i]){
                selected[i] = cnt;
                visited[i] = true;
                permutation(cnt+1, selected, visited);
                visited[i] = false;
            }
        }
    }

    private static int demical(int[] selected, int d) {
        int res = 0;

        for (int i = d-1, j = 0; i >= 0 ; i--, j++) {
            res += selected[i] * Math.pow(d, j);
        }

        //System.out.println(res);
        return res;
    }

    private static int[] numeral(int n, int d) {
        int[] num = new int[d];
        for (int i = d - 1; i > 0; i--) {
            num[i] = (n % d);
            n /= d;
//            System.out.println(num[i]);
//            System.out.println(n);
            arr[i] = i;
        }
        num[0] = n;
        //System.out.println(Arrays.toString(num));
        return num;
    }
}
