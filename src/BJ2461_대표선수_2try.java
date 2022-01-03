import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2461_대표선수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        List<int[]> list = new LinkedList<>();

        for(int n = 1; n <= N; n++){
            tk = new StringTokenizer(br.readLine(), " ");
            for(int m = 0; m < M; m++) {
                list.add(new int[]{n, Integer.parseInt(tk.nextToken())});
            }
        }

        Collections.sort(list, (a, b) -> a[1]-b[1]);

        int len = list.size();
        twoPoint(list, len, N);


    }

    private static void twoPoint(List<int[]> list, int N, int M) {
//        LinkedHashSet<Integer> hSet = new LinkedHashSet<>();
//        Iterator<Integer> it;
        int[] cls = new int[M];
        int chk = 0;
        int res = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
//        long gaus = ((long) M * (1 + M )) / 2; // 등차수열 합 공식

//        System.out.println("g : "+gaus);
        while(end < N){
            //System.out.println(list.get(end)[1]+" "+list.get(start)[1]);
//            System.out.println(end-start);
//            chk += list.get(end)[0];

            //System.out.println("chk : "+chk);

            if(chk < M) {

                //System.out.println("cls : "+(cls[list.get(end)[0]-1]));
                //System.out.println("idx : "+(list.get(end)[0]-1));
                if(cls[list.get(end)[0]-1] == 0) chk++;
                cls[list.get(end)[0]-1]++;
                //System.out.println(Arrays.toString(cls));
                end++;
            }

            if(chk == M) {
//                System.out.println(list.get(end-1)[1]+" "+list.get(start)[1]);
//                System.out.println(end+"  "+start);
//                System.out.println("res ; "+res);
                res = Math.min(res, list.get(end-1)[1]-list.get(start)[1]);
                cls[list.get(start)[0]-1]--;
                if(cls[list.get(start)[0]-1] == 0) chk--;
                start++;


//                System.out.println("chk : "+chk);
//                if(chk == gaus){
//                    res = Math.min(res, list.get(end)[1]-list.get(start)[1]);
//                    System.out.println("res : "+res);
//                }
//                start++;
//                chk -= list.get(end-(M-1))[0];
            }


            //System.out.println();
        }

        //System.out.println(hSet);
        System.out.println(res);
    }
}
