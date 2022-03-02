import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10819_차이를최대로 {
    static int N, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        tk = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        permutation(0, arr, new int[N], new boolean[N]);

        System.out.println(ans);
    }

    private static void permutation(int cnt, int[] arr, int[] selected, boolean[] visited) {
        if(cnt == N){
//            for (int i = 0; i < N; i++) {
//                System.out.print(selected[i]+" ");
//            }
//            System.out.println();
            int result = sum(selected);

            ans = Math.max(ans, result);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                selected[i] = arr[cnt];
                permutation(cnt+1, arr, selected, visited);
                visited[i] = false;
            }
        }

    }

    private static int sum(int[] selected) {
        int res = 0;

        for (int i = 1; i < N; i++) {
            res += Math.abs(selected[i-1] - selected[i]);
        }

        //System.out.println("res : "+res);
        return res;

    }
}
