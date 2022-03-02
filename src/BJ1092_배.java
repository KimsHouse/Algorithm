import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1092_배 {
    static List<Integer> cranes;
    static List<Integer> boxes;
    static int time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());
        cranes = new ArrayList<>();
        tk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cranes.add(Integer.parseInt(tk.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        boxes = new ArrayList<>();
        tk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(tk.nextToken()));
        }

        Collections.sort(cranes, Collections.reverseOrder());
        Collections.sort(boxes, Collections.reverseOrder());

        System.out.println(cranes);
        System.out.println(boxes);

        if(cranes.get(0) < boxes.get(boxes.size()-1)) System.out.println(-1);
        else{
            loading();
            System.out.println(time);
        }




    }

    private static void loading() {
        int cnt = 0;
        while(cnt < boxes.size()){
            for (int i = 0; i < cranes.size(); i++) {
                if(cnt >= boxes.size()) break;
                if(cranes.get(i) >= boxes.get(cnt)) cnt++;
            }

            time++;
        }
    }
}
