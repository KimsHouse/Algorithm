import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17406_배열돌리기 {
    static int N, M, K, min = Integer.MAX_VALUE;
    static int[][] arr, copy, list;
    //static ArrayList<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        K = Integer.parseInt(tk.nextToken());

        arr = new int[N+1][M+1];
        copy = new int[N+1][M+1];
        list = new int[K][3];

        for(int i =1; i <= N; i++){
            tk = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= M; j++){
                int num = Integer.parseInt(tk.nextToken());
                arr[i][j] = num;
                copy[i][j] = num;
            }
        }

        for(int i = 0; i < K; i++){
            tk = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(tk.nextToken());
            int m = Integer.parseInt(tk.nextToken());
            int k = Integer.parseInt(tk.nextToken());

            list[i] = new int[]{n, m, k};

        }
        min = Integer.MAX_VALUE;
        //System.out.println(Arrays.deepToString(list));
        permutation(0, new int[K][3], new boolean[K], list);
//
//        arr = rotateArr(n-k, m-k, n+k, m+k, arr);
//        int min = Integer.MAX_VALUE;
//        for (int j = 1; j <= N; j++) {
//            int sum = 0;
//            for (int l = 1; l <= M; l++) {
//                sum += arr[j][l];
//            }
//            min = Math.min(min, sum);
//        }
        System.out.println(min);
    }

    private static void permutation(int cnt, int[][] selected, boolean[] visited, int[][] list) {
        if(cnt == K){
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    arr[i][j] = copy[i][j];
                }
            }

//            System.out.println("bf");
//            for (int i = 1; i <= N; i++) {
//                for (int j = 1; j <= M; j++) {
//                    System.out.print(arr[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            for (int i = 0; i < K; i++) {
                //System.out.println(Arrays.toString(selected[i]));
                int n = selected[i][0];
                int m = selected[i][1];
                int k = selected[i][2];

                arr = rotateArr(n-k, m-k, n+k, m+k, arr);

            }

            System.out.println("af");
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();

            for (int j = 1; j <= N; j++) {
                int sum = 0;
                for (int l = 1; l <= M; l++) {
                    sum += arr[j][l];
                }
                //System.out.println("sum = "+sum);
                min = Math.min(min, sum);
            }
            //System.out.println(min);
        }

        for(int i = 0; i < K; i++){
            if(!visited[i]){
                selected[i] = list[cnt];
                visited[i] = true;
                permutation(cnt+1, selected, visited, list);
                visited[i] = false;
            }
        }
    }

    private static int[][] rotateArr(int r1, int c1, int r2, int c2, int[][] arr){
        //System.out.println(r1+" "+c1+" "+r2+" "+c2);

        int fir = arr[r1][c2];
        for(int i = c2; i > c1; i--){
            //System.out.println(i);
            arr[r1][i] = arr[r1][i-1];
        }

        int sec = arr[r2][c2];
        for(int i = r2; i > r1; i--){
            arr[i][c2] = arr[i-1][c2];
        }

        int thr = arr[r2][c1];
        for(int i = c1; i < c2; i++){
            arr[r2][i] = arr[r2][i+1];
        }

        int fur = arr[r1][c1];
        for(int i = r1; i < r2; i++){
            arr[i][c1] = arr[i+1][c1];
        }

        arr[r1+1][c2] = fir;
        arr[r2][c2-1] = sec;
        arr[r2-1][c1] = thr;
        arr[r1][c1+1] = fur;

        r1 += 1;
        c1 += 1;
        r2 -= 1;
        c2 -= 1;

        if(r2-r1 <= 1 || c2-c1 <= 1) return arr;
        else return rotateArr(r1, c1, r2, c2, arr);

    }
}
