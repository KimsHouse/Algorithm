import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1946_신입사원 {
    static int T;
    static int max = 987654321;
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //T = sc.nextInt();
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            //int N = sc.nextInt();
            int N = Integer.parseInt(br.readLine());
            int count = 0;
            List<int[]> list = new ArrayList<>();
            StringTokenizer tk = null;
            for (int n = 0; n < N; n++) {
//                int a = sc.nextInt();
//                int b = sc.nextInt();
                tk = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(tk.nextToken());
                int b = Integer.parseInt(tk.nextToken());

                list.add(new int[]{a, b});

            }
            Collections.sort(list, new Comparator<int[]>(){

                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int curr = max;
            for (int i = 0; i < N; i++) {
                if (curr > list.get(i)[1]) {
                    curr = list.get(i)[1];
                    count++;
                }
                if(curr == 1) break;
                //System.out.println("["+list.get(i)[0]+", "+list.get(i)[1]+"]");
            }
            //System.out.println(count);
            sb.append(count).append("\n");
            //System.out.println(Arrays.deepToString(list));

        }
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());

    }
}
