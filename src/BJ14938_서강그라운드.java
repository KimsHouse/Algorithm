import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ14938_서강그라운드 {
    static class player {
        int current;
        int sumRange;
        int sumItem;
    }

    static int N, R, V, tot, maxValue = 987654321;
    static int[] items, dist;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        R = sc.nextInt(); // 수색 범위
        V = sc.nextInt(); // 간선 개수

        map = new int[N+1][N+1];
        items = new int[N+1];
        //dist = new int[N+1];
        //visited = new boolean[N+1];

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

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            //bag = 0;
            //System.out.println("idx = "+i);
            getItems(i);
            //System.out.println();
        }


        //System.out.println(Arrays.toString(items));
        //System.out.println(Arrays.deepToString(map));
        System.out.println(tot);

    }

    private static void getItems(int start) {
       Queue<int[]> queue = new LinkedList<>();
       queue.offer(new int[]{start, 0});
       int bag = items[start];
       visited[start] = true;

       while (!queue.isEmpty()){
           int[] xy = queue.poll();
           int idx = xy[0];
           int dis = xy[1];

           //bag += items[start];
           for (int i = 1; i <= N; i++) {
               if(idx == i) continue;
               if(!visited[i] && (dis+map[idx][i]) <= R && map[idx][i] != maxValue){
                   visited[i] = true;
//                       System.out.println(Arrays.toString(visited));
//                       System.out.println("dis : "+dis);
//                       System.out.println("dis + map :"+(dis+map[idx][i]));
//                       System.out.println("idx : "+idx +" i : "+i);
//                       System.out.println("map : "+map[idx][i]);
//                       System.out.println("item : "+items[i]);
//                       System.out.println("bag : "+bag);
//                       System.out.println("bag + item: "+(bag+items[i]));
                   bag += items[i];
                   queue.offer(new int[]{i, dis + map[idx][i]});
                   //System.out.println("bag : "+bag);
                   if(bag > tot) tot = bag;
               }
           }
       }
    }
}
