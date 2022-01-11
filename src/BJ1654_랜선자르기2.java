import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ1654_랜선자르기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(tk.nextToken());
        int N = Integer.parseInt(tk.nextToken());

        int[] Lan = new int[K];

        for (int i = 0; i < K; i++) {
            Lan[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(Lan);
        long end = Lan[K-1];

        binary(1, end, N, Lan);

    }

    private static void binary(long start, long end, long target, int[] lan) {
        long mid;

        while(start <= end){
            mid = (start + end) / 2;

            long result = cutCable(mid, lan);

            if(result >= target){
                start = mid + 1;
            }
            else if (result < target) {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }

    private static long cutCable(long mid, int[] lan){
        long res = 0;
        for (int i = 0; i < lan.length; i++) {
            res += lan[i]/mid;
        }
        return res;
    }
}
