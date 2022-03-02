import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        //List<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> ans = new Stack<>();


        tk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(tk.nextToken());
            arr[i] = n;
        }

        for (int i = N-1; i >= 0; i--) {

            while(!stack.isEmpty()) {
                //System.out.println("s : "+stack);
                int top = stack.peek();
                if (arr[i] < top) {

                    ans.push(top);
                    //System.out.println(arr[i]+" "+ans);
                    break;
                } else stack.pop();
            }
            //System.out.println("as : "+stack);
            if(stack.isEmpty()) {
                ans.push(-1);
                //System.out.println("ans : "+ans);
            }
            stack.push(arr[i]);
        }

        while (!ans.isEmpty()){
            //System.out.print(ans.pop()+" ");
            sb.append(ans.pop()).append(" ");
        }

//        for (int i = N-1, j = 0; i >= 0 && j < N; i--, j++) {
//            stack.push(arr[i]);
//            int val = -1;
//            while (!stack.isEmpty()){
//                val = stack.pop();
//                if(arr[i] < val){
//                    //
//                    stack.push(val);
//                    break;
//                }
//            }
//            if(stack.isEmpty()) {
//                //System.out.print((-1)+" ");
//                sb.append(-1).append(" ");
//            }
//            else {
////                System.out.print(val+" ");
//                sb.append(val).append(" ");
//            }
//            stack.push(val);
//            //stack.push(arr[i]);
//        }

        //System.out.println(stack);
//        for (int i = 0; i < N; i++) {
//
//            //System.out.println(stack);
//            while (!stack.isEmpty()){
//                val = stack.pop();
//                if(arr[i] < val){
//                    //sb.append(val).append(" ");
//                    stack.push(val);
//                    break;
//                }
//            }
//
//            if(stack.isEmpty()) {
//                //System.out.print((-1)+" ");
//                sb.append(-1).append(" ");
//            }
//            else {
////                System.out.print(val+" ");
//                sb.append(val).append(" ");
//            }
//            stack.push(val);
//        }
        System.out.println(sb);



    }
}
