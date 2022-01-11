import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1818_책정리 {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);

        tk = new StringTokenizer(br.readLine().trim());

        for(int i = 0; i < N; i++){
            int val = arr[i] = Integer.parseInt(tk.nextToken());
            if(list.get(list.size()-1) < val) {
                list.add(val);
            } else {
                int idx = binary(val, 1, list.size()-1, list);
                list.set(idx, val);
            }
        }
        System.out.println(arr.length-(list.size()-1));
    }

    private static int binary(int target, int start, int end, ArrayList<Integer> list){
        while(start < end){
            int mid = (start + end) / 2;

            if(list.get(mid) < target) start = mid + 1;
            else end = mid;
        }
        return end;
    }
}
