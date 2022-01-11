import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ14002_가장긴증가하는부분수열4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        tk = new StringTokenizer(br.readLine(), " ");
        for(int n = 0; n < N; n++){
            arr[n] = Integer.parseInt(tk.nextToken());
        }

        int LIS = 1;
        int[] list = new int[N];
        list[0] = 1;

        for (int i = 1; i < N; i++) {
            list[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    list[i] = Math.max(list[i], list[j]+1);
                    LIS = Math.max(LIS, list[i]);
//                    System.out.println(Arrays.toString(list));
//                    System.out.println("LIS : "+LIS);
                }
            }
//            System.out.println();
        }

        sb.append(LIS).append("\n");

        Stack<Integer> stack = new Stack<>();
        for (int i = N-1; i >= 0; i--) {
            if(list[i] == LIS){
//                System.out.println(list[i]+" "+LIS);
//                System.out.println(arr[i]);
                stack.push(arr[i]);
                LIS--;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);


    }


}
