import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1475_방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] set = br.readLine().toCharArray();
        int[] count = new int[11];

        int result = 0;

        for(int i = 0; i < set.length; i++){
            int idx = set[i] - '0';

            if(idx == 6){
                if(count[6] > count[9]) count[9]++;
                else count[6]++;
            }

            else if(idx == 9) {
                if(count[9] > count[6]) count[6]++;
                else count[9]++;
            }

            else {
                count[idx]++;
            }

            result = Math.max(result, count[idx]);
        }

        System.out.println(result);

    }
}
