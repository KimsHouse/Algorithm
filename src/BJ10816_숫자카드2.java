import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ10816_숫자카드2 {
    static int[] cards, sang;
    //static HashMap<Long, Integer> sang;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        StringBuilder sb=  new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        cards = new int[N];
        tk = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            cards[i] = Integer.parseInt(tk.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        //HashMap<Long, Integer> sang = new HashMap<>();
        //sang = new HashMap<>();
        sang = new int[M];
        tk = new StringTokenizer(br.readLine(), " ");

        Arrays.sort(cards);

        for(int i = 0; i < M; i++){
            long s = Integer.parseInt(tk.nextToken());
//            //sang.put(s, 0);
//            //sang[i] = Integer.parseInt(tk.nextToken());
//            int left = binary_left(0, N-1, s, i);
//            //System.out.println("l : "+left);
//            int right =binary_right(0, N-1, s, i);
//            //System.out.println("r : "+right);
//            System.out.print((right-left)+" ");
            sb.append(binary_right(0, N-1, s, i) - binary_left(0, N-1, s, i)).append(' ');
        }

        System.out.println(sb);
//        for (int i = 0; i < M; i++) {
//            binary(0, N-1, s);
//        }

    }

    private static int binary_right(int start, int end, long target, int idx) {
        int mid = 0;
        int value = 0;

        while(start <= end) {
            mid = (start+end) / 2;
            if(cards[mid] > target) end = mid - 1;
            else if(cards[mid] <= target){
                if (cards[mid] == target) value = mid+1;
                start = mid+1;
            }

        }

        return value;
    }

    private static int binary_left(int start, int end, long target, int idx) {
        int mid = 0;
        int value = 0;
        while(start <= end) {
            mid = (start+end) / 2;


            if(cards[mid] >= target) {
                if (cards[mid] == target) value = mid;
                end = mid - 1;
            }
            else if(cards[mid] < target) start = mid+1;

        }
        return value;
    }
}
