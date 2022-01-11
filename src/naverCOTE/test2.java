package naverCOTE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

//        String sen = br.readLine();
//        String key = br.readLine();
//
//        tk = new StringTokenizer(br.readLine(), " ");
//        int tlen = tk.countTokens();
//        int[] skip = new int[tlen];
//        for (int i = 0; i < tlen; i++) {
//            skip[i] = Integer.parseInt(tk.nextToken());
//        }


        //String sen = "i love coding";
        String sen = "abcde fghi";
        //String sen = "encrypt this sentence";

        //String key = "mask";
        //String key = "mode";
        String key = "axyz";
        //String key = "something";

        //int[] skip = new int[]{0, 0, 3, 2, 3, 4};
        //int[] skip = new int[]{0, 10};
        int[] skip = new int[]{3, 9, 0, 1};
        //int[] skip = new int[]{0, 1, 3, 2, 9, 2, 0, 3, 0, 2, 4, 1, 3};

        System.out.println(solution(sen, key, skip));


    }

    private static String solution(String sentence, String keyword, int[] skips) {
        String answer = "";

        for (int i = 0, j = 0, k = 0; i < sentence.length();) {

            int index = -1;
            if(skips.length > j) index = skips[j];
            String ch = Character.toString(keyword.charAt(k));
            String st = Character.toString(sentence.charAt(i));

            if(index == 0){
                answer += ch;
                j++;
                k++;
                if(k == keyword.length()) k = 0;

                continue;
            }

            answer += st;

            if(index != -1 && st.equals(ch)) {
                answer += ch;
                k++;
                j++;
            }
            if(skips.length > j) skips[j]--;
            i++;

            System.out.println("answer : "+answer);
        }
        return answer;
    }
}
