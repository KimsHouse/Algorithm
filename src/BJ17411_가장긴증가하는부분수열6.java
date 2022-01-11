import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ17411_가장긴증가하는부분수열6 { // 미해결
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] index = new int[N];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        tk = new StringTokenizer(br.readLine()," ");

        int maxLen = Integer.MIN_VALUE;
        int count = 0;

        for(int i = 0; i < N; i++){
            int val = arr[i] = Integer.parseInt(tk.nextToken());

            if(list.get(list.size()-1) < val) {
                list.add(val);
                maxLen = list.size()-1;
                count = 1;
                //System.out.println("if");
            }
            else {
                int idx = binary(val, 1, list.size()-1, list);
                list.set(idx, val);
                //if(maxLen < list.size()-1) maxLen = list.size()-1;
                count++;
                //System.out.println("else");

            }

        }
        System.out.println(maxLen+" "+count);
    }

    private static int binary(int target, int start, int end, ArrayList<Integer> list){
        while(start < end) {
            int mid = (start + end) / 2;

            if(list.get(mid) < target) start = mid + 1;
            else end = mid;
            //System.out.println("binary");
        }
        return end;
    }
}
