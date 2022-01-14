import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jktest {

    static int N;
    static int M;
    static int K;
    static int minSum;
    static boolean[] check;
    static int[] selected;
    static RCS[] list;

    static class RCS {

        int r;
        int c;
        int s;

        public RCS(int r, int c, int s) {
            super();
            this.r = r;
            this.c = c;
            this.s = s;
        }

    }
   
   private static void printArr(int[][] arr) {
      for(int i=1; i<=N; i++) {
         for(int j=1; j<=M; j++) {
            System.out.print(arr[i][j] + " ");
         }
         System.out.println();
      }
   }

    private static void permutation(int cnt, int[][] originArr) {
        if(cnt == K) {

            int[][] copyArr = new int [N+1][M+1];
            for(int i=1; i<=N; i++) {
                System.arraycopy(originArr[i], 0, copyArr[i], 0, M+1);
            }

            int[][] resultArr = new int [N+1][M+1];
            for(int i=0; i<K; i++) {
                int index = selected[i];
                RCS temp = list[index];

                resultArr = rotateArr(copyArr, temp.r, temp.c, temp.s);
                copyArr = resultArr;

//                printArr(resultArr);
//                System.out.println();
//                printArr(copyArr);
//                System.out.println();


            }

            for(int i=1; i<=N; i++) {
                int tempSum = 0;
                for(int j=1; j<=M; j++) {
                    tempSum += resultArr[i][j];
                }
                minSum = Math.min(minSum, tempSum);
            }
            return;
        }


        for(int i=0; i<K; i++) {
            if(!check[i]) {
                selected[cnt] = i;
                check[i] = true;
                permutation(cnt+1, originArr);
                check[i] = false;
            }
        }
    }

    private static int[][] rotateArr(int[][] arr, int r, int c, int s){
        int[][] newArr = new int [N+1][M+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                newArr[i][j] = arr[i][j];
            }
        }

        int start_x = r-s, start_y = c-s, end_x = r+s, end_y = c+s;
        int rotateCnt = (end_x - start_x + 1) / 2;

        for(int j=0; j<rotateCnt; j++) {
            start_x += j;
            start_y += j;
            end_x -= j;
            end_y -= j;

            int fir = arr[start_x][end_y];
            for(int i = end_y; i > start_y; i--){
                //System.out.println(i);
                newArr[start_x][i] = arr[start_x][i-1];
            }

            int sec = arr[end_x][end_y];
            for(int i = end_x; i > start_x; i--){
                newArr[i][end_y] = arr[i-1][end_y];
            }

            int thr = arr[end_x][start_y];
            for(int i = start_y; i < end_y; i++){
                newArr[end_x][i] = arr[end_x][i+1];
            }

            int fur = arr[start_x][start_y];
            for(int i = start_x; i < end_x; i++){
                newArr[i][start_y] = arr[i+1][start_y];
            }

            newArr[start_x+1][end_y] = fir;
            newArr[end_x][end_y-1] = sec;
            newArr[end_x-1][start_y] = thr;
            newArr[start_x][start_y+1] = fur;

//            for(int j=start_y; j<end_y; j++) {
//                System.out.println("j : "+j);
//                newArr[start_x][j+1] = arr[start_x][j];
//                newArr[end_x][j] = arr[end_x][j+1];
//            }
//
//            for(int j=start_x; j<end_x; j++) {
//                newArr[j+1][end_y] = arr[j][end_y];
//                newArr[j][start_y] = arr[j+1][start_y];
//            }


        }

        return newArr;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] arr = new int [N+1][M+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list = new RCS [K];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            list[i] = new RCS(r, c, s);
        }

        selected = new int [K];
        check = new boolean [K];
        minSum = Integer.MAX_VALUE;

        permutation(0, arr);

        System.out.println(minSum);
    }

}