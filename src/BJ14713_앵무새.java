import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ14713_앵무새 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<String>[] queue = new Queue[N];

        for (int i = 0; i < N; i++) {
            String[] msg = br.readLine().split(" ");
            queue[i] = new LinkedList<>();
            for (int j = 0; j < msg.length; j++) {
                queue[i].offer(msg[j]);
            }
//            System.out.println(queue[i]);
        }

        String[] l = br.readLine().split(" ");
        Queue<String> L = new LinkedList<>();

        for (int i = 0; i < l.length; i++) {
            L.offer(l[i]);
        }
//        System.out.println(L);



        while (!L.isEmpty()){
            boolean flag = true;

            for (int j = 0; j < queue.length; j++) {
                for (int k = 0; k < queue[j].size(); k++) {
                    if(!L.isEmpty() && L.peek().equals(queue[j].peek())) {
                        flag = false;
                        L.poll();
                        queue[j].poll();
                    } else break;
                }
            }
            if(flag) break;
        }

        boolean pos = true;
//        System.out.println("L : "+L);
        for (int i = 0; i < queue.length; i++) {
            if(!L.isEmpty() || !queue[i].isEmpty()) {
                pos = false;
                break;
            }
        }

        if(pos) System.out.println("Possible");
        else System.out.println("Impossible");

    }
}

