import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ10282_해킹 {
    static class Node{
        int next, value;

        public Node(int next, int value) {
            this.next = next;
            this.value = value;
        }
    }

    static int n, max = 20000000;
    static int[] dist, prev;

    static boolean[] visited;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            tk = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(tk.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(tk.nextToken()); // 의존성 개수
            int c = Integer.parseInt(tk.nextToken()); // 해킹당한 컴퓨터 번호

            dist = new int[n+1];
            prev = new int[n+1];
            visited = new boolean[n+1];
            list = new ArrayList[n+1];

            for(int i = 1; i <= n; i++){
                list[i] = new ArrayList<>();
            }
            //Arrays.fill(list, new ArrayList<>());
            for(int i = 0; i < d; i++){
                //System.out.println("hi");
                tk = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(tk.nextToken());
                int y = Integer.parseInt(tk.nextToken());
                int v = Integer.parseInt(tk.nextToken());

//                System.out.println(x+" "+y+" "+v);
//                System.out.println(y+" "+x+" "+v);
//                System.out.println();
                //[x].add(new Node(y, v));
                list[y].add(new Node(x, v));
            }

//            for (int i = 1; i <= n; i++) {
//                System.out.println(list[i].size());
//                for(Node nn : list[i]){
//                    System.out.println(i+" "+nn.next+" "+nn.value);
//                }
//                System.out.println();
//            }


            dijk(c);
            //System.out.println(Arrays.toString(prev));
            //trace(end);
        }
    }
    private static void trace(int end){
        int idx = end;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        while(idx != 0){
            stack.push(idx);
            res += dist[idx];
            idx = prev[idx];
        }
//        int res = 0;
//        while (!stack.isEmpty()){
//            res += dist[stack.pop()];
//        }
        //System.out.println(res);
    }

    private static int dijk(int start){
        Arrays.fill(dist, max);
        Arrays.fill(visited, false);
        Arrays.fill(prev, 0);
        dist[start] = 0;
        prev[start] = 0;

        int prv = 0;
        int count = 0;

        PriorityQueue<Node> pQ = new PriorityQueue<>((a, b) -> a.value-b.value);
        pQ.offer(new Node(start, 0));
        while(!pQ.isEmpty()){
            Node node = pQ.poll();
            int cur = node.next;
            //System.out.println("1 cur : "+cur);
            int val = node.value;
            int res = 0;
            //if(val > dist[cur] || visited[cur]) continue;
            if(!visited[cur]) {
                visited[cur] = true;
                count++;
            } else continue;

            for(Node n : list[cur]){
            //for (int i = 0; i < list[cur].size(); i++) {
                //Node n = list[cur].get(i);
                if(dist[n.next] > dist[cur] + n.value){
                    dist[n.next] = dist[cur] + n.value;
                    prv = n.next;
                    prev[n.next] = cur;


                    pQ.offer(new Node(n.next, dist[n.next]));
                }


            }
            //System.out.println(count+" "+res);

            visited[cur] = true;
        }
        int result = -1;
        for (int i = 1; i <= n; i++) {
            if(dist[i] != max) {
                //System.out.println(Arrays.toString(dist));
                result = Math.max(dist[i], result);
            }
        }
        System.out.println(count+" "+result);
        //System.out.println(prv);
//        System.out.println(Arrays.toString(prev));
//        System.out.println(Arrays.toString(dist));

        return prv;
    }
}
