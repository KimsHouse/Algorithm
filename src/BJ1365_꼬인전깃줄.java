import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1365_꼬인전깃줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        ArrayList<Integer> list = new ArrayList<>();
        int[] index = new int[N];

        list.add(-1);

        tk = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            int val = arr[i] = Integer.parseInt(tk.nextToken());

            if(list.get(list.size()-1) < val) {
                list.add(val);
                index[i] = list.size()-1;
            } else {
                int idx = binary(val, 1, list.size()-1, list);
                list.set(idx, val);
                index[i] = idx;
            }
        }

        int LIS = list.size()-1;
        int count = 0;
        for(int i = N-1; i >= 0; i--){
            if(index[i] == LIS) {
                LIS--;
                continue;
            }
            count++;
        }
        System.out.println(count);
        //System.out.println(Arrays.toString(index));

    }

    private static int binary(int target, int start, int end, ArrayList<Integer> list) {
        while(start < end){
            int mid = (start + end) / 2;

            if(list.get(mid) < target) start = mid + 1;
            else end = mid;
        }
        return end;
    }
}
