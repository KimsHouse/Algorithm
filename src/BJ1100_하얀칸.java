import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1100_하얀칸 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] map = new char[8][8];

        //boolean flag;
        int count = 0;
        for (int i = 0; i < 8; i++) {
            //if(i % 2 == 0) flag = true;
            //else flag = false;
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = str.charAt(j);
                if(((i+j) % 2 == 0)) {
                    //System.out.println(i+" "+j);
                    if (map[i][j] == 'F') count++;
                }
            }
        }

        System.out.println(count);
    }
}
