import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1780_종이의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][N+1];
        int[] count = new int[3];

        for(int i = 1; i <= N; i++){
            tk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        cutPaper(arr,1, N, 1, N, N, count);

        for(int i = 0; i < 3; i++){
            System.out.println(count[i]);
        }

    }

    private static void cutPaper(int[][] list, int hs, int he, int ws, int we, int N, int[] count){
        if(N < 1 || hs > he || ws > we) return;


        System.out.println(hs+" ~ "+he);
        System.out.println(ws+" ~ "+we);


        boolean tflag = false;

        for (int k = 0; k < 3; k++) {
            boolean flag = true;
            int num = k-1;
            loop:
            for (int i = hs; i <= he; i++) {
                for (int j = ws; j <= we; j++) {
                    if(list[i][j] != num){
                        flag = false;
                        break loop;
                    }
                }
            }

            if(flag){
                count[num+1]++;
                System.out.println(Arrays.toString(count));
                tflag = true;
            }
        }
        System.out.println();

        if(!tflag) {
            System.out.println("n : " + N);
//            System.out.println("{"+hs+"~"+(he/3)+", "+ws+"~"+(we/3)+"} "+
//
//                    "{"+((he/3)+1)+"~"+(he/3)*2+", "+((we/3)+1)+"~"+(we/3)*2+"} "+
//
//                    "{"+((he/3)*2+1)+"~"+he+", "+((we/3)*2+1)+"~"+we+"} ");

            System.out.println(1);
            cutPaper(list, hs, (he / 3), ws, (we / 3), N / 3, count);
            cutPaper(list, hs, (he / 3), (we / 3) + ws, (we / 3) * 2, N / 3, count);
            cutPaper(list, hs, (he / 3), (we / 3) * 2 + ws, we, N / 3, count);
//
            System.out.println(2);
            cutPaper(list, (he / 3) + hs, (he / 3) * 2, ws, (we / 3), N / 3, count);
            cutPaper(list, (he / 3) + hs, (he / 3) * 2, (we / 3) + ws, (we / 3) * 2, N / 3, count);
            cutPaper(list, (he / 3) + hs, (he / 3) * 2, (we / 3) * 2 + ws, we, N / 3, count);
//
            System.out.println(3);
            cutPaper(list, (he / 3) * 2 + hs, he, ws, (we / 3), N / 3, count);
            cutPaper(list, (he / 3) * 2 + 1, he, (we / 3) + 1, (we / 3) * 2, N / 3, count);
            cutPaper(list, (he / 3) * 2 + 1, he, (we / 3) * 2 + 1, we, N / 3, count);
        }
    }
}
