import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11365_밀비급일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String[] sentence = br.readLine().split(" ");
            if(sentence[0].equals("END")) break;
            for (int i = sentence.length-1; i >= 0; i--) {
                for (int j = sentence[i].length()-1; j >= 0; j--) {
                    sb.append(sentence[i].charAt(j));
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
