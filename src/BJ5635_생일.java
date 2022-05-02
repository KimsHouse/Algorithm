import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ5635_생일 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());
        String[][] names = new String[N][4];


        for (int i = 0; i < N; i++) {

            tk = new StringTokenizer(br.readLine(), " ");

            names[i][0] = tk.nextToken();
            names[i][3] = tk.nextToken();
            names[i][2] = tk.nextToken();
            names[i][1] = tk.nextToken();

        }

        String adult = names[0][0];
        String kid = names[0][0];
        int year = Integer.parseInt(names[0][1]);
        int month = Integer.parseInt(names[0][2]);
        int day = Integer.parseInt(names[0][3]);

        for (int i = 1; i < N; i++) {

            if(year < Integer.parseInt(names[i][1])){
                adult = names[i][0];
                year = Integer.parseInt(names[i][1]);
                month = Integer.parseInt(names[i][2]);
                day = Integer.parseInt(names[i][3]);
            }

            else if(year == Integer.parseInt(names[i][1])) {
                if(month < Integer.parseInt(names[i][2])){
                    adult = names[i][0];
                    year = Integer.parseInt(names[i][1]);
                    month = Integer.parseInt(names[i][2]);
                    day = Integer.parseInt(names[i][3]);
                }
                else if(month == Integer.parseInt(names[i][2])) {
                    if(day < Integer.parseInt(names[i][3])){
                        adult = names[i][0];
                        year = Integer.parseInt(names[i][1]);
                        month = Integer.parseInt(names[i][2]);
                        day = Integer.parseInt(names[i][3]);
                    }
                }
            }
        }

        year = Integer.parseInt(names[0][1]);
        month = Integer.parseInt(names[0][2]);
        day = Integer.parseInt(names[0][3]);

        for (int i = 1; i < N; i++) {

            if(year > Integer.parseInt(names[i][1])){
                kid = names[i][0];
                year = Integer.parseInt(names[i][1]);
                month = Integer.parseInt(names[i][2]);
                day = Integer.parseInt(names[i][3]);
            }

            else if(year == Integer.parseInt(names[i][1])) {
                if(month > Integer.parseInt(names[i][2])){
                    kid = names[i][0];
                    year = Integer.parseInt(names[i][1]);
                    month = Integer.parseInt(names[i][2]);
                    day = Integer.parseInt(names[i][3]);
                }
                else if(month == Integer.parseInt(names[i][2])) {
                    if(day > Integer.parseInt(names[i][3])){
                        kid = names[i][0];
                        year = Integer.parseInt(names[i][1]);
                        month = Integer.parseInt(names[i][2]);
                        day = Integer.parseInt(names[i][3]);
                    }
                }
            }
        }



        System.out.println(adult);
        System.out.println(kid);
    }
}
