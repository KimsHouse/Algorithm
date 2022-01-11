import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14465_소가길을건너간이유5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());
        int B = Integer.parseInt(tk.nextToken());

        boolean[] arr = new boolean[N+1];

        for(int b = 0; b < B; b++){
            int idx = Integer.parseInt(br.readLine());
            arr[idx] = true;
        }

        int res = 987654321;
        int cnt = 0;


        for(int i = 1; i <= K; i++) {
            if(arr[i]) cnt++;
        }

        res = Math.min(res, cnt);

        //System.out.println(Arrays.toString(arr));
        for(int i = K+1; i <= N; i++){
            if(arr[i-K]) cnt--;
            if(arr[i]) cnt++;

            //.out.println("cnt : "+cnt);
            res = Math.min(res, cnt);
        }

        System.out.println(res);

    }
}
