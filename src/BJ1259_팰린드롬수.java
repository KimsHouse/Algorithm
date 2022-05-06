import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1259_팰린드롬수 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String input = br.readLine();
            if(input.equals("0")) break;
            char[] strArr = input.toCharArray();

            boolean flag = true;
            for (int i = 0, j = strArr.length-1; i < strArr.length; i++, j--) {
                if(strArr[i] != strArr[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
