import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ13335_트럭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(tk.nextToken()); // 총 트럭 대수
        int W = Integer.parseInt(tk.nextToken()); // 다리 위에 올라갈 수 있는 트럭 개수
        int L = Integer.parseInt(tk.nextToken()); // 다리 위에 올라갈 수 있는 트럭 최대 무게

        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        tk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(tk.nextToken());
            truck.offer(value);
        }

        for (int i = 0; i < W; i++) {
            bridge.offer(0);
        }
        //System.out.println(truck);
        int currWeight = 0;
        int time = 0;

        while(!bridge.isEmpty()) {
            time++;
            currWeight -= bridge.poll();
            if(!truck.isEmpty()){
                if(currWeight + truck.peek() <= L) {
                    currWeight += truck.peek();
                    bridge.offer(truck.poll());
                } else {
                    bridge.offer(0);
                }
            }
        }

        System.out.println(time);
    }
}
