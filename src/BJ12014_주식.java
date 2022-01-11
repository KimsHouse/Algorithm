import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ12014_주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tk;

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            StringBuilder sb = new StringBuilder();

            tk = new StringTokenizer(br.readLine()," ");

            int N = Integer.parseInt(tk.nextToken());
            int K = Integer.parseInt(tk.nextToken());

            int[] arr = new int[N];
            ArrayList<Integer> list = new ArrayList<>();
            list.add(-1);

            tk = new StringTokenizer(br.readLine()," ");
            for(int i = 0; i < N; i++){
                int val = arr[i] = Integer.parseInt(tk.nextToken());

                if(list.get(list.size()-1) < val) list.add(val);
                else {
                    int idx = binary(val, 1, list.size()-1, list);
                    list.set(idx, val);
                }
            }

            sb.append("Case #").append(t).append("\n");
            if((list.size()-1) == K) sb.append(1);
            else sb.append(0);

            System.out.println(sb);
        }
    }

    private static int binary(int target, int start, int end, ArrayList<Integer> list) {
        while(start < end) {
            int mid = (start + end) / 2;

            if(list.get(mid) < target) start = mid + 1;
            else end = mid;
        }
        return end;
    }
}
