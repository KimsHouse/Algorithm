import java.util.*;

public class BJ11724_연결요소의개수 {
    static int N, V, count;
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        V = sc.nextInt();
        visited = new boolean[N+1];

        graph = new int[N+1][N+1];

        List<int[]> list = new ArrayList<>();

        for (int i = 1; i <= V; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
            graph[b][a] = 1;
            list.add(new int[]{a, b});
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            bfs(i);
            //dfs(i);

        }

        System.out.println(count);
        //System.out.println(Arrays.deepToString(graph));

    }

    private static void dfs(int idx) {
        if(visited[idx]) return;

        visited[idx] = true;
        for (int i = 1; i <= N; i++) {
            if(graph[idx][i] == 1){
                count++;
                dfs(i);
            }
        }
    }

    private static void bfs(int idx) {
       Queue<Integer> queue = new LinkedList<>();
       visited[idx] = true;
       queue.add(idx);
       while (!queue.isEmpty()){
           int v = queue.poll();

           for (int i = 1; i <= N; i++) {
               if(!visited[i] && graph[v][i] == 1) {
                   queue.add(i);
                   visited[i] = true;
               }
           }
       }
       count++;
    }

}
