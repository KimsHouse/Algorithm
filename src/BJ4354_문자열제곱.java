import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ4354_문자열제곱 {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        String pat = "";

        for (int i = 0; i < 10; i++) {
            str = br.readLine();

            if(str.equals("."))break;
            cnt = 0;

            int[] num = makeArr(str);

            //int slen = str.length()- num[str.length()-1];
            // 주어진 문자열이 홀수 일때는 slen / slen-num[slen-1] 이 나누어 떨어지는지 확인해야한다.
            if(str.length() % (str.length() - num[str.length()-1]) != 0) System.out.println(1);
            else System.out.println(str.length()/(str.length()-num[str.length()-1]));
            //if((str.length()-num[str.length()-1]) % str.length() != 0) slen = str.length();
//            if(num[slen] == 0) slen = str.length();
//            else if(num[slen] == str.length()-1) slen = 1;

//            kmp(str, str.substring(0, slen));
//
//            System.out.println(cnt);
        }

    }

    private static void kmp(String parent, String pattern) {
        int[] arr = makeArr(pattern);
        int count = 0;
        for (int i = 0, j = 0; i < parent.length(); i++) {
            while(j > 0 && parent.charAt(i) != pattern.charAt(j)) j = arr[j-1];
            if(parent.charAt(i) == pattern.charAt(j)) {
                if(j == pattern.length()-1) {
                    //System.out.println("hi");
                    j = arr[j];
                    count++;
                } else {
                    ++j;
                }

            }
        }
        if(count > cnt) cnt = count;

    }

    private static int[] makeArr(String str) {
        int[] arr = new int[str.length()];
        char[] pattern = str.toCharArray();

        for (int i = 1, j = 0; i < pattern.length; i++) {
            while(j > 0 && pattern[i] != pattern[j]) j = arr[j-1];
            if(pattern[i] == pattern[j]) arr[i] = ++j;
        }
        //System.out.println(Arrays.toString(arr));

        return arr;
    }
}
