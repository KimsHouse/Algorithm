import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1305_광고 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] num = makeArr(s);

        System.out.println(Arrays.toString(num));
        System.out.println(s.length()-num[s.length()-1]); // 문자열 최대길이 - (접두사/접미사) 최대길이
    }

    private static int[] makeArr(String pat) {
        int[] num = new int[pat.length()];

        int j = 0;
        for (int i = 1; i < pat.length(); i++) {
            while(j > 0 && pat.charAt(i) != pat.charAt(j)){ // j가 0보다 크거나 패턴[i]가 패턴[j]와 다를 때
                j = num[j-1]; // 이전 원소값을 j에 넣음
            }

            if(pat.charAt(i) == pat.charAt(j)){ // 패턴[i]가 패턴[j]와 같으면 j++ // i와 j가 같이 증가
                num[i] = ++j;
            }
        }

        return num;
    }
}
