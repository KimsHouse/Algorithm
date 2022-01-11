import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2352_반도체설계 {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         ArrayList<Integer> list = new ArrayList<>();
         StringTokenizer tk;

         int N = Integer.parseInt(br.readLine());
         int[] arr = new int[N];

         tk = new StringTokenizer(br.readLine(), " ");

         int LIS = 0;
         list.add(-1);

         for(int i = 0; i < N; i++){
             int val = arr[i] = Integer.parseInt(tk.nextToken());
             if(list.get(list.size()-1) < val) {
                 list.add(val);
             } else {
                 int idx = binary(val, 1, list.size()-1, list);
                 list.set(idx, val);
             }
         }
         //System.out.println(list);
         System.out.println(list.size()-1);
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
