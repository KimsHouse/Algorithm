import java.io.*;
import java.util.*;

public class BJ2805_나무자르기 {
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        int[] trees = new int[N];

        tk = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(trees);

        int endValue = trees[N-1];

        binary(0, endValue, M, trees);

    }

    private static void binary(int start, int end, int height, int[] tree){
        int mid;

        while(start <= end) {
            mid = (start + end) / 2;

            //System.out.println("mid : "+mid);
            long result = cutTree(mid, tree);
            //System.out.println("result : "+result);

            if(result == height) {
                System.out.println(+mid);
                return;
            }


            if(result > height) {
                start = mid + 1;
                if(result != 0) stack.push(mid);
            }
            else if(result < height) {
                end = mid - 1;

            }
        }
        //System.out.print("s : ");
        System.out.println(stack.pop());
    }

    private static long cutTree(int mid, int[] tree){
        int tLen = tree.length;
        long sum = 0;
        //System.out.println("---cutTre---");
        //System.out.println(Arrays.toString(tree));
        for(int i = tLen-1; i >=0; i--){
            if(tree[i] - mid < 0) break;
            //System.out.println(tree[i]+" - "+mid);
            int val = tree[i] - mid;
            sum += val;
            //System.out.println("sum : "+sum);
        }
        return sum;
    }
}
