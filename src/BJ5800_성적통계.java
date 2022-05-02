import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ5800_성적통계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int T = Integer.parseInt(br.readLine());


        for (int t = 1; t <= T; t++) {
            tk = new StringTokenizer(br.readLine(), " ");
            ArrayList<Integer> list = new ArrayList<>();
            int result = 0;
            int N = Integer.parseInt(tk.nextToken());
            for (int n = 0; n < N; n++) {
                int score = Integer.parseInt(tk.nextToken());
                list.add(score);
            }
            Collections.sort(list);
            Collections.reverse(list);
            int max = list.get(0);
            int min = list.get(list.size()-1);



            for (int i = 1; i < list.size(); i++) {
                int res = Math.abs(list.get(i-1))-Math.abs(list.get(i));
                result = Math.max(result, res);
            }

            System.out.println("Class "+t);
            System.out.println("Max "+max+", Min "+min+", Largest gap "+result);
        }



    }
}
