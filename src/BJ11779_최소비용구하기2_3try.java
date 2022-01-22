import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ11779_최소비용구하기2_3try {
    static class Node {
        int next, value;

        public Node(int next, int value) {
            this.next = next;
            this.value = value;
        }
    }

    static int N, M, max = 1234567890;
    static int[] dist, prev;
    static int[][] map;

    static boolean[] visited;
    static List<Node>[] list;

   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer tk;

       N = Integer.parseInt(br.readLine());
       M = Integer.parseInt(br.readLine());

       dist = new int[N+1];
       prev = new int[N+1];
       visited = new boolean[N+1];
       list = new ArrayList[N+1];
       map = new int[N+1][N+1];


       for(int i = 1; i <= N; i++){
           dist[i] = max;
           prev[i] = max;
           list[i] = new ArrayList<>();
//           for(int j = 1; j <= N; j++){
//               if(i == j) map[i][j] = 0;
//               map[i][j] = max;
//           }
       }



       for(int i = 0; i < M; i++) {
           tk = new StringTokenizer(br.readLine(), " ");

           int r = Integer.parseInt(tk.nextToken());
           int c = Integer.parseInt(tk.nextToken());
           int v = Integer.parseInt(tk.nextToken());

           if(map[r][c] > v) continue;

           list[r].add(new Node(c, v));

       }

       tk = new StringTokenizer(br.readLine(), " ");
       int start = Integer.parseInt(tk.nextToken());
       int end = Integer.parseInt(tk.nextToken());


       dijk(start);
       System.out.println(dist[end]);
       trace(end);
       //System.out.println(Arrays.toString(dist));
       //System.out.println(Arrays.toString(prev));

   }

   private static void dijk(int start){
       dist[start] = 0;
       prev[start] = 0;

       PriorityQueue<Node> pQ = new PriorityQueue<>((a, b) -> a.value-b.value);
       pQ.offer(new Node(start, 0));
       while(!pQ.isEmpty()){
           Node node = pQ.poll();
           int cur = node.next;
           int val = node.value;

           if(val > dist[cur] || visited[cur]) continue;

           for(Node n : list[cur]){
               if (dist[n.next] > dist[cur] + n.value) {
                   dist[n.next] = dist[cur] + n.value;
                   prev[n.next] = cur;

                   pQ.offer(new Node(n.next, dist[n.next]));

               }
           }
           visited[cur] = true;
       }
   }

   private static void trace(int num){
       int idx = num;
       Stack<Integer> stack = new Stack<>();
       while(idx != 0){
           stack.push(idx);
           idx = prev[idx];
       }
       //stack.push(idx);
       System.out.println(stack.size());
       while(!stack.isEmpty()){
           System.out.print(stack.pop()+" ");
       }

   }
}
