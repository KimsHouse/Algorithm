package Algorithm;

import java.util.Arrays;

public class 다익스트라 {
    static int number = 6;
    static int INF = 987654321;

    static int[][] a = new int[][]
        {
            {0, 2, 5, 1, INF, INF},
            {2, 0, 3, 2, INF, INF},
            {5, 3, 0, 3, 1, 5},
            {1, 2, 3, 0, 1, INF},
            {INF, INF, 1, 1, 0, 2},
            {INF, INF, 5, INF, 2, 0},
        };

    static boolean[] v = new boolean[6];
    static int[] d = new int[6];

    static int getSmallIndex() {
        int min = INF;
        int index = 0;
        for (int i = 0; i < number; i++) {
            if(d[i] < min && !v[i]){
                min = d[i];
                index = i;
            }
        }
        return index;
    }

    static void dijkstra(int start){
        for (int i = 0; i < number; i++) {
            d[i] = a[start][i];
        }

        System.out.println("d : "+ Arrays.toString(d));
        System.out.println("v : "+Arrays.toString(v));
        v[start] = true;

        for (int i = 0; i < number; i++) {
            int curr = getSmallIndex();
            System.out.println("-----------------------------------------");

            v[curr] = true;
            System.out.println("v : "+Arrays.toString(v));

            for (int j = 0; j < number; j++) {
                if(!v[j]){
                    if(d[curr] + a[curr][j] < d[j]) {
                        System.out.println("bf d : "+Arrays.toString(d));
                        d[j] = d[curr] + a [curr][j];

                        System.out.println("curr : "+curr+" j : "+j);
                        System.out.println("d[curr] : "+d[curr]+", a[curr][j] : "+a[curr][j]+", d[j] : "+d[j]);
                        System.out.println("af d : "+Arrays.toString(d)+"\n");
                    }
                }
            }
            //.out.println("d : "+Arrays.toString(d));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        dijkstra(0);
        for (int i = 0; i < number; i++) {
            System.out.print(d[i]+" ");
        }
    }
}
