import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2145_숫자놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String input = br.readLine();
            if(input.equals("0")) break;
            char[] num = input.toCharArray();

            int result = 0;


            while (true) {
                //System.out.println(Arrays.toString(num));
                num = sumNum(num);
                if(num.length == 1) break;
            }

            System.out.println(num[0]);
        }

    }

    private static char[] sumNum(char[] num) {
        int sum = 0;

        for (int i = 0; i < num.length; i++) {
            //System.out.println("num : "+num[i]);
            sum += num[i] - '0';
        }
        String str = Integer.toString(sum);
        char[] ch = str.toCharArray();
        //System.out.println(sum);
        return ch;
    }
}
