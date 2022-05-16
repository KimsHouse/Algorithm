import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] bars = br.readLine().split("");
        int curr = 0;
        int result = 0;
        boolean flag = false;
        String before = "";

        System.out.println(Arrays.toString(bars));

        for(int i = 0; i < bars.length; i++){
            if(bars[i].equals("(")){
                if(before.equals("(") || before.equals("")) {
                    result++;
                    curr++;
                } else if(before.equals(")")){
                    if(flag) {
                        result++;
                        curr++;
                    } else {
                        result += 2;
                        curr++;
                    }
                }
                flag = false;
            } else if(bars[i].equals(")")) {
                if(before.equals("(")) {
                    result--;
                    curr--;
                    result += curr;
                    flag = true;
                } else if(before.equals(")")) {
                    curr--;
                    flag = false;
                }
            }

        }

        System.out.println(result);

    }
}
