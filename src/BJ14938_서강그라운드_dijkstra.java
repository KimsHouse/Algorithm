package Algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ14938_서강그라운드_dijkstra {
    static int N, R, V, tot, maxValue = 987654321;
    static int[] items;
    static int[][] map, copy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        R = sc.nextInt(); // 수색 범위
        V = sc.nextInt(); // 간선 개수

        map = new int[N+1][N+1];
        copy = new int[N+1][N+1];
        items = new int[N+1];

        for (int n = 1; n <= N; n++) {
            items[n] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], maxValue);
        }

        for (int v = 1; v <= V; v++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int i = sc.nextInt();

            //map[v][v] = 0;
            map[x][y] = i;
            map[y][x] = i;
        }

        getItems();


        //System.out.println(Arrays.toString(items));
        //System.out.println(Arrays.deepToString(map));
        System.out.println(tot);

    }

    private static void getItems() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                copy[i][j] = map[i][j];
                if(i == j) copy[i][j] = 0;
            }
        }

        for (int k = N; k >= 1; k--) { // 경유지
            for (int i = 1; i <= N; i++) { // 출발
                for (int j = 1; j <= N; j++) { // 도착
                    if(copy[i][k] + copy[k][j] < copy[i][j] && (i != j && j != k && i != k)){ // Integer.MAX_VALUE 일떄 넣는 경우가 있음
                        copy[i][j] = copy[i][k] + copy[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if(copy[i][j] <= R) sum += items[j];
            }
            if(tot < sum) tot = sum;
        }

    }

}
