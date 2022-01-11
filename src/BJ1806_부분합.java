import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1806_부분합 {
    static int maxValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        int[] arr = new int[N+1];

        tk = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        twoPoint(arr, N, M);

        //System.out.println(Arrays.toString(arr));
    }

    private static void twoPoint(int[] arr, int N, int target) {
        StringBuilder sb = new StringBuilder();
        int res = maxValue;
        int sum = 0;
        int end = 0;

        for(int start = 0; start < N; start++){

            while(sum < target && end < N){
                sum += arr[end];
                end += 1;
//                System.out.println("sum : "+sum);
//                System.out.println("e s : "+end+" "+start);
            }
            if(sum >= target) {
                res = Math.min(res, (end-start));
                //System.out.println(arr[end]+" "+arr[start]);
                //System.out.println(end+" "+start);
                //System.out.println(end-start-1);
            }
            sum -= arr[start];
        }
        //sb.append(res);
        if(res == maxValue) System.out.println(0);
        else System.out.println(res);
    }
}
