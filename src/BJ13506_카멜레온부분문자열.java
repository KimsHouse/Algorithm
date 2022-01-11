import java.io.*;
import java.util.*;

public class BJ13506_카멜레온부분문자열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String pat = br.readLine();

        int[] num = makeArr(pat);

        System.out.println(Arrays.toString(num));
    }

    private static int[] makeArr(String pat){
        int[] num = new int[pat.length()];
        char[] pattern = pat.toCharArray();

        for(int i = 1, j = 0; i < pattern.length; i++){
            while(j > 0 && pattern[i] != pattern[j]) j = num[j-1];
            if(pattern[i] == pattern[j]) num[i] = ++j;
        }

        return num;
    }
}
