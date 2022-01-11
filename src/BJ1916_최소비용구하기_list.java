import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1916_최소비용구하기_list {
    static class bus{
        int end;
        int val;

        public bus(int end, int val) {
            this.end = end;
            this.val = val;
        }
    }

    static int N, M, maxValue = 1234567890;
    static int[] dist;

    static PriorityQueue<bus> bQ;
    static ArrayList<bus>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        dist = new int[N+1];
        list = new ArrayList[N+1];

//        for (int i = 1; i <= M; i++) {
//            list[i] = new ArrayList<>();
//        }

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            dist[i] = maxValue;
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int v = sc.nextInt();

            list[x].add(new bus(y, v));
            //bQ.add(new bus(x, y, v));

        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        dijk(start);
        System.out.println(dist[end]);

    }

    private static void dijk(int start) {
        dist[start] = 0;
        bQ = new PriorityQueue<>((a, b) -> (a.val-b.val));
        bQ.offer(new bus(start, 0));
        //System.out.println("bq size : "+bQ.size());
        //for (int i = 0; i < M; i++) {
        while(!bQ.isEmpty()){
            bus q = bQ.poll();
            int end = q.end;
            int val = q.val;

            if(val > dist[end]) continue;
//            System.out.println("u : "+u);
//            System.out.println("v : "+v);
//            System.out.println("val : "+val);

            for (int j = 0; j < list[end].size(); j++) {
                int next = list[end].get(j).end;
                int value = list[end].get(j).val;

                if(dist[next] > dist[end] + value) {
                    //if(next == start) continue;
                    dist[next] = dist[end] + value;
                    bQ.offer(new bus(next, dist[next]));
                    //System.out.println(Arrays.toString(dist));
                }
            }

        }
    }


}
