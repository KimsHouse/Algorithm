import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ1654_랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(tk.nextToken());
        int N = Integer.parseInt(tk.nextToken());

        int[] Lan = new int[K];

        long end = 0;
        for (int i = 0; i < K; i++) {
            Lan[i] = Integer.parseInt(br.readLine());
            if(end < Lan[i]) end = Lan[i];
        }

        Arrays.sort(Lan);
        //long end = Lan[K-1]+1;

        binary(0, end+1, N, Lan);

    }

    private static void binary(long start, long end, long target, int[] lan) {
        long mid;
        Stack<Long> stack = new Stack<>();
        while(start < end){
            mid = (start + end) / 2;
            //System.out.println(mid);
            long result = cutCable(mid, lan);

//            if(result == target) {
//                System.out.println(mid);
//                return;
//            }

            if(result >= target){
                start = mid + 1;
                //stack.push(mid);
            }
            else if (result < target) {
                end = mid;
            }
        }
        System.out.println(start-1);
//        if(!stack.isEmpty()) System.out.println(stack.pop());
//        else System.out.println(0);
    }

    private static long cutCable(long mid, int[] lan){
        long res = 0;
        for (int i = 0; i < lan.length; i++) {
            if(mid > lan[i] || mid == 0) continue;
            //System.out.println(lan[i]+" / "+mid);
            //long val =
            res += lan[i]/mid;
        }
        //System.out.println(res);
        return res;
    }
}
