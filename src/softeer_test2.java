import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class softeer_test2 {
    static class obj {
        int num;
        char w;

        public obj(int num, char w) {
            this.num = num;
            this.w = w;
        }
    }

    static int N;
    static ArrayList<obj>[] list;
    static PriorityQueue<obj> pQ;
    static int[] order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        order = new int[N];

        Arrays.fill(order, -1);
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine()," ");
            int t = Integer.parseInt(tk.nextToken());
            char c = tk.nextToken().charAt(0);

            list[t].add(new obj(i, c));
        }

        output();
        System.out.println(Arrays.toString(order));
    }

    private static void output() {
        pQ = new PriorityQueue<>((a, b) -> ((a.w) - (b.w)));
        for (int i = 0; i < N+1; i++) {

            int flag = 0;
            int bf = -1;
            for (int j = 0; j < list[i].size(); j++) {
                int curr = list[i].get(j).num;
                char currC = list[i].get(j).w;

                if(currC == bf) flag++;
                if(flag == 4) return;
                pQ.offer(new obj(curr, currC));
                //System.out.println(list[i].get(j).w);
                bf = currC;
            }

            if(!pQ.isEmpty()) {
                obj o = pQ.poll(); // 하나 뺌

                //if(list[i].size() == 0) continue;

                int idx = o.num;
                int time = o.w;

                System.out.println((char)time+" "+i);

                order[idx] = i;
            }

        }
    }
}
