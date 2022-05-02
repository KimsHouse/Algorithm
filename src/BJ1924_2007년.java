import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1924_2007년 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");

        int month = Integer.parseInt(tk.nextToken());
        int day = Integer.parseInt(tk.nextToken());

        int[] dayOfMonth = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeek = new String[] {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int total = day;

        for(int i = 0; i < month-1; i++) {
            total += dayOfMonth[i];
        }

        System.out.println(dayOfWeek[total%7]);



    }
}
