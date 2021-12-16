import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1197_최소스패닝트리 {
    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int[] parents;

    private static void make(){
        // 모든 원소를 자신을 대표자로 만듬
        parents = new int[V+1];
        for (int i = 0; i <= V; i++) {
            parents[i] = i;
        }
    }

    // a가 속한 집합의 대표자 찾기
    private static int find(int a) {
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    //두 원소를 하나의 집합으로 합치기
    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false; // 이미 같은 집합으로 합치지 않음

        parents[bRoot] = aRoot;
        return true;
    }

    static int V, E;
    static Edge[] edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(tk.nextToken());
        E = Integer.parseInt(tk.nextToken());

        edgeList = new Edge[E];

        for(int i = 0; i < E; i++) {
            tk = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(tk.nextToken());
            int end = Integer.parseInt(tk.nextToken());
            int weight = Integer.parseInt(tk.nextToken());
            edgeList[i] = new Edge(start, end, weight);
        }

        Arrays.sort(edgeList); // 오름차순 정렬
        make(); // 모든 정점을 각각ㄱ의 집합으로 만들고 출발

        // 간선 하나씩 시도하며 트리를 만들어감
        int cnt = 0;
        int result = 0;
        for(Edge edge : edgeList){
            if(union(edge.start, edge.end)){
                result += edge.weight;
                if(++cnt == V-1) break; // 신장트리 완성
            }
        }

        System.out.println(result);
    }
}
